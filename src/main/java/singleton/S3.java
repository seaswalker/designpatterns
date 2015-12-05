package singleton;

/**
 * �����ַ�ʽ����Ҫʱ���أ�����ֻ���ڵ�һ�γ�ʼ��ʱ��ͬ��
 * ˫�ؼ�����
 * @author skywalker
 *
 */
public class S3 {
	
	//������volatite�ؼ��ֳ��ó���֮һ����һ����״̬��־��
	private volatile static S3 s3;
	
	private S3() {}
	
	public static S3 getInstance() {
		if(s3 == null) {
			synchronized (S3.class) {
				//�ڶ����жϿ�
				if(s3 == null) {
					s3 = new S3();
				}
			}
		}
		return s3;
	}
	
}
