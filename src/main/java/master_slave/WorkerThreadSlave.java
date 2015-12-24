package master_slave;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import twophasetermination.AbstractTerminatableThread;

/**
 * 基于工作者线程的Slave参与者通用实现
 * @author skywalker
 *
 * @param <T> 子任务类型
 * @param <V> 子任务处理结果类型
 */
public abstract class WorkerThreadSlave<T, V> extends AbstractTerminatableThread implements SlaveSpec<T, V> {

	private final BlockingQueue<Runnable> taskQueue;

	public WorkerThreadSlave(BlockingQueue<Runnable> taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	@Override
	public Future<V> submit(T task) throws InterruptedException {
		FutureTask<V> ft = new FutureTask<V>(new Callable<V>() {
			@Override
			public V call() throws Exception {
				V result = null;
				try {
					result = doProcess(task);
				} catch (Exception e) {
					throw newSubTaskFailureException(task, e);
				}
				return result;
			}
		});
		taskQueue.put(ft);
		terminationToken.reservations.incrementAndGet();
		return ft;
	}
	
	private SubTaskFailureException newSubTaskFailureException(final T task, Exception cause) {
		RetryInfo<T, V> retryInfo = new RetryInfo<T, V>(task, new Callable<V>() {
			@Override
			public V call() throws Exception {
				return doProcess(task);
			}
		});
		return new SubTaskFailureException(retryInfo, cause);
	}
	
	/**
	 * 留给子类实现。用于实现子任务的处理逻辑
	 * @param task
	 * @return 子任务处理结果
	 * @throws Exception
	 */
	protected abstract V doProcess(T task) throws Exception;
	
	@Override
	protected void doRun() {
		try {
			taskQueue.take().run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			terminationToken.reservations.decrementAndGet();
		}
	}
	
	@Override
	public void init() {
		start();
	}
	
	@Override
	public void shutdown() {
		terminate(true);
	}
	
}
