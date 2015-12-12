package twophasetermination;

import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实际上相当于把线程停止标志单独抽取为一个类，并且支持运行完任务后结束线程
 * @author skywalker
 *
 */
public class TerminationToken {

	private volatile boolean isShutdown = false;
	//还剩的任务数量
	public final AtomicInteger reservations = new AtomicInteger(0);
	/*
	 * 在多个可停止线程共享一个TerminationToken的情况下，用于记录这些线程，
	 * 以实现一个停止后，其它的也应该停止
	 */
	private final Queue<WeakReference<Terminatable>> coordinatedThreads;
	
	public TerminationToken() {
		coordinatedThreads = new ConcurrentLinkedQueue<WeakReference<Terminatable>>();
	}

	public void setShutdown() {
		isShutdown = true;
	}
	
	public boolean isShutdown() {
		return isShutdown;
	}
	
	/**
	 * 注册使用this的线程
	 * @param thread 线程
	 */
	public void register(Terminatable thread) {
		coordinatedThreads.add(new WeakReference<Terminatable>(thread));
	}
	
	/**
	 * 一个线程停止后，通知使用当前对象的其它线程停止
	 * @param thread 已经停止的线程
	 */
	public void notifyThreadTermination(Terminatable thread) {
		for (WeakReference<Terminatable> t : coordinatedThreads) {
			if (t.get() != thread) {
				t.get().terminate();
			}
		}
	}
	
}
