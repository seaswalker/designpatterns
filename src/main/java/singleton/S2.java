package singleton;

/**
 * �ڶ��ֵ�����ֱ�ӳ�ʼ��
 * @author skywalker
 *
 */
public class S2 {

	private static S2 s2 = new S2();
	
	private S2() {}
	
	public synchronized static S2 getInstance() {
		return s2;
	}
	
}
