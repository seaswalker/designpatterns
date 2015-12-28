package halfsync_halfasync;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Half-sync/Half-async可复用实现
 * @author skywalker
 *
 * @param <V> 同步任务的处理结果
 */
public abstract class AsyncTask<V> {

	//相当于此模式的同步层，用于执行异步层提交的任务
	private volatile Executor executor;
	private final static ExecutorService DEFAULT_EXECUTOR;
	
	static {
		DEFAULT_EXECUTOR = new ThreadPoolExecutor(1, 1, 8, TimeUnit.HOURS, new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(r, "AsyncTaskDefaultWorker");
				thread.setDaemon(true);
				return thread;
			}
		}, new RejectedExecutionHandler() {
			/**
			 * 支持拒绝重试
			 */
			@Override
			public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				if (!executor.isShutdown()) {
					try {
						executor.getQueue().put(r);
					} catch (InterruptedException e) {
						;
					}
				}
			}
		});
	}

	public AsyncTask(Executor executor) {
		this.executor = executor;
	}

	public AsyncTask() {
		this(DEFAULT_EXECUTOR);
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}
	
	/**
	 * 留给子类实现耗时短的任务，默认什么也不做
	 * @param params 客户端调用dispacth时所传递的参数列表
	 */
	protected void onPreExecute(Object...params) {
		
	}
	
	/**
	 * 用于实现同步任务执行结束后所需执行的操作，默认什么也不做
	 * @param result 同步处理的结果
	 */
	protected void onPostExecute(V result) {
		
	}
	
	protected void onExecutionError(Exception e) {
		e.printStackTrace();
	}
	
	/**
	 * 留给子类实现耗时较长的任务(同步任务)，由后台线程负责调用
	 * @param params 客户端调用dispatch时传递的参数
	 * @return 同步任务处理的结果
	 */
	protected abstract V doInBackground(Object...params);
	
	/**
	 * 对外(子类)暴露的服务方法
	 * @param params
	 * @return
	 */
	protected Future<V> dispatch(final Object...params) {
		FutureTask<V> ft = null;
		//初步层初步处理
		onPreExecute(params);
		
		Callable<V> callable = new Callable<V>() {
			@Override
			public V call() throws Exception {
				return doInBackground(params);
			}
		};
		
		ft = new FutureTask<V>(callable) {
			@Override
			protected void done() {
				try {
					onPostExecute(this.get());
				} catch (InterruptedException | ExecutionException e) {
					onExecutionError(e);
				} 
			}
		};
		
		//提交到同步层处理
		executor.execute(ft);
		return ft;
	}
	
}
