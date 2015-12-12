package twophasetermination;

/**
 * 可以停止的线程
 * @author skywalker
 *
 */
public abstract class AbstractTerminatableThread extends Thread implements Terminatable {

	protected final TerminationToken terminationToken;

	public AbstractTerminatableThread() {
		this(new TerminationToken());
	}

	public AbstractTerminatableThread(TerminationToken terminationToken) {
		this.terminationToken = terminationToken;
		terminationToken.register(this);
	}
	
	@Override
	public void run() {
		Exception ex = null;
		try {
			while (true) {
				if (terminationToken.isShutdown() && terminationToken.reservations.get() <= 0) {
					break;
				}
				doRun();
			}
		} catch (Exception e) {
			ex = e;
		} finally {
			try {
				doCleanup(ex);
			} finally {
				terminationToken.notifyThreadTermination(this);
			}
		}
	}
	
	/**
	 * 真正的运行逻辑，交由子类实现
	 */
	protected abstract void doRun();
	
	/**
	 * 某些阻塞的方法不相应中断(比如Inputstream.read())此时需要一些特殊的处理方式
	 */
	protected void doTerminate() {}
	
	/**
	 * 线程终结前的清理工作
	 */
	protected void doCleanup(Exception ex) {};
	
	@Override
	public void terminate() {
		terminationToken.setShutdown();
		try {
			doTerminate();
		} finally {
			if (terminationToken.reservations.get() <= 0) {
				//没有正在等待的任务，强行停止
				super.interrupt();
			}
		}
	}
	
	/**
	 * 此方法在参数为true的情况下回使调用此方法的线程等待直到当前线程停止
	 * @param waitUtilThreadTerminated
	 */
	public void terminate(boolean waitUtilThreadTerminated) {
		terminate();
		if (waitUtilThreadTerminated) {
			try {
				this.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
	
}
