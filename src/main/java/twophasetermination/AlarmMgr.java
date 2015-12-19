package twophasetermination;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 高精功能入口类
 * @author skywalker
 *
 */
public class AlarmMgr {

	private static final AlarmMgr INSTANCE = new AlarmMgr();
	private volatile boolean shutedRequested = false;
	private final AlarmSendingThread alarmSendingThread;
	
	private AlarmMgr() {
		alarmSendingThread = new AlarmSendingThread();
	}
	
	/**
	 * 不要再构造函数中启动线程!!!
	 */
	public void init() {
		alarmSendingThread.start();
	}
	
	public static AlarmMgr getInstance() {
		return INSTANCE;
	}
	
	public void sendAlarm(String message) {
		alarmSendingThread.sendMessage(message);
	}
	
	public void shutDown() {
		if (shutedRequested) {
			throw new IllegalStateException("the thread has been shutdown");
		}
		alarmSendingThread.terminate();
		shutedRequested = true;
	}
	
	/**
	 * 消息发送线程
	 * @author skywalker
	 *
	 */
	private class AlarmSendingThread extends AbstractTerminatableThread {

		private final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
		
		@Override
		protected void doRun() {
			try {
				String messgae = queue.take();
				terminationToken.reservations.decrementAndGet();
				System.out.println(messgae + "被发送");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * 发送消息
		 * @param message
		 */
		public void sendMessage(String message) {
			try {
				queue.put(message);
				terminationToken.reservations.getAndIncrement();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		protected void doCleanup(Exception ex) {
			if (ex != null && !(ex instanceof InterruptedException)) {
				ex.printStackTrace();
			}
			System.out.println("断开连接...");
		}
		
	}
	
}
