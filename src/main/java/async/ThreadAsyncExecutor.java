package async;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAsyncExecutor implements AsyncExecutor {
	
	//线程计数
	private static final AtomicInteger counter = new AtomicInteger(0);

	@Override
	public <T> AsyncResult<T> startProcess(Callable<T> task) {
		return startProcess(task, null);
	}

	@Override
	public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback) {
		CompletableResult<T> asyncResult = new CompletableResult<T>(callback);
		//启动一个worker线程，此处使用线程池更好
		new Thread(() -> {
			try {
				asyncResult.setValue(task.call());
			} catch (Exception e) {
				asyncResult.setException(e);
			}
		}, "worker-" + counter.getAndIncrement()).start();
		return asyncResult;
	}

	@Override
	public <T> T endProcess(AsyncResult<T> result) throws InterruptedException, ExecutionException {
		if (!result.isComplete()) {
			result.await();
		}
		return result.getValue();
	}
	
	private static class CompletableResult<T> implements AsyncResult<T> {
		
		//运行状态
		private static final int RUNNING = 1;
		private static final int FAILED = 2;
		private static final int FINSHED = 3;
		
		private volatile int status = RUNNING;
		//最终的执行结果
		private T value;
		private Exception exception;
		private final Object lock;
		private final Optional<AsyncCallback<T>> callback;
		
		public CompletableResult(AsyncCallback<T> callback) {
			this.lock = new Object();
			this.callback = Optional.ofNullable(callback);
		}
		
		/**
		 * worker线程执行完毕，调用此方法设置最终结果
		 * @param value
		 */
		public void setValue(T value) {
			this.status = FINSHED;
			this.value = value;
			callback.ifPresent(cb -> {
				cb.onComplete(value, Optional.empty());
			});
			//通知所有等待的线程
			synchronized (lock) {
				lock.notifyAll();
			}
		}
		
		/**
		 * worker线程抛出异常
		 * @param exception
		 */
		public void setException(Exception exception) {
			this.status = FAILED;
			this.exception = exception;
			callback.ifPresent(cb -> {
				cb.onComplete(value, Optional.of(exception));
			});
			synchronized (lock) {
				lock.notifyAll();
			}
		}

		@Override
		public boolean isComplete() {
			return status > RUNNING;
		}

		@Override
		public T getValue() throws ExecutionException {
			if (status == FINSHED) {
				return value;
			} else if (status == FAILED) {
				throw new ExecutionException(exception);
			} else {
				throw new IllegalStateException("Execution not complete yet");
			}
		}

		@Override
		public void await() throws InterruptedException {
			synchronized (lock) {
				if (!isComplete()) {
					lock.wait();
				}
			}
		}
		
	}

}
