package async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * 异步执行接口
 * @author skywalker
 *
 */
public interface AsyncExecutor {

	<T> AsyncResult<T> startProcess(Callable<T> task);
	
	<T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback);
	
	/**
	 * 返回最终的结果，如果此时尚未完成，那么当前线程会被阻塞
	 * @param result 
	 * @return 执行结果
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	<T> T endProcess(AsyncResult<T> result) throws InterruptedException, ExecutionException;
	
}
