package async;

import java.util.concurrent.ExecutionException;

/**
 * һ���첽ִ�еĽ��
 * @author skywalker
 *
 */
public interface AsyncResult<T> {

	boolean isComplete();
	
	T getValue() throws ExecutionException;
	
	/**
	 * ������ǰ�̣߳�֪��ִ�н���
	 * @throws ExecutionException
	 */
	void await() throws InterruptedException;
	
}
