package async;

import java.util.Optional;

/**
 * �첽����ִ�н������Զ�������
 * @author skywalker
 *
 */
public interface AsyncCallback<T> {

	/**
	 * �ص�����
	 * @param value �����ִ�н��(ִ�гɹ�)
	 * @param ex ִ��ʧ�ܵ��쳣��Ϣ
	 */
	void onComplete(T value, Optional<Exception> ex);
	
}
