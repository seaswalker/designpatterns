package async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * �첽ִ�нӿ�
 * @author skywalker
 *
 */
public interface AsyncExecutor {

	<T> AsyncResult<T> startProcess(Callable<T> task);
	
	<T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback);
	
	/**
	 * �������յĽ���������ʱ��δ��ɣ���ô��ǰ�̻߳ᱻ����
	 * @param result 
	 * @return ִ�н��
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	<T> T endProcess(AsyncResult<T> result) throws InterruptedException, ExecutionException;
	
}
