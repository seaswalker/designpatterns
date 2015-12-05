package async;

import java.util.concurrent.ExecutionException;

/**
 * 一次异步执行的结果
 * @author skywalker
 *
 */
public interface AsyncResult<T> {

	boolean isComplete();
	
	T getValue() throws ExecutionException;
	
	/**
	 * 阻塞当前线程，知道执行结束
	 * @throws ExecutionException
	 */
	void await() throws InterruptedException;
	
}
