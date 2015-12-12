package guardedsuspension;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 负责连接告警服务器，并向服务器发送告警信息
 * @author skywalker
 *
 */
public class AlarmAgent {

	//是否已连上告警服务器
	private volatile boolean connectedToServer = false;
	//心跳定时器(守护线程)
	private final Timer heartBeatTimer = new Timer(true);
	private final Predicacate predicacate = new Predicacate() {
		@Override
		public boolean evaluate() {
			return connectedToServer;
		}
	};
	private final Blocker blocker = new ConditionVarBlocker();
	
	public AlarmAgent() {
		init();
	}

	protected void init() {
		new Thread(new ConnectingTask()).start();
		//开启周期性的心跳检测
		//在一分钟后每两秒检测一次
		heartBeatTimer.schedule(new HeartbeatTask(), 60000, 2000);
	}
	
	/**
	 * 发送告警信息
	 * @param message 信息
	 * @throws Exception 
	 */
	public void sendAlarm(String message) throws Exception {
		GuardedAction<Void> guardedAction = new GuardedAction<Void>(predicacate) {
			@Override
			public Void call() throws Exception {
				doSendAlarm(message);
				return null;
			}
		};
		blocker.callWithGuard(guardedAction);
	}
	
	/**
	 * 真正向服务器发送警告信息
	 * @param message
	 */
	private void doSendAlarm(String message) {
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 已连接到服务器
	 * @throws Exception 
	 */
	protected void onConnected() throws Exception {
		//其实可以直接调用blocker.singal()
		blocker.signalAfter(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				connectedToServer = true;
				return Boolean.TRUE;
			}
		});
	}
	
	protected void onDisconnected() {
		connectedToServer = false;
	}
	
	//连接报警服务器
	private class ConnectingTask implements Runnable {
		@Override
		public void run() {
			//省略其它代码
			try {
				onConnected();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//心跳检测
	private class HeartbeatTask extends TimerTask {

		@Override
		public void run() {
			if (!testConnection()) {
				onDisconnected();
				reconnect();
			}
		}
		
	}
	
	/**
	 * 测试和服务器的连接，真正的实现应该是向服务器发送心跳包
	 */
	private boolean testConnection() {
		return true;
	}
	
	/**
	 * 重建和服务器的连接
	 */
	private void reconnect() {
		//直接在心跳线程执行
		new ConnectingTask().run();
	}
	
}
