package async;

import java.util.Optional;

/**
 * 异步任务执行结束后自动被调用
 * @author skywalker
 *
 */
public interface AsyncCallback<T> {

	/**
	 * 回调函数
	 * @param value 任务的执行结果(执行成功)
	 * @param ex 执行失败的异常信息
	 */
	void onComplete(T value, Optional<Exception> ex);
	
}
