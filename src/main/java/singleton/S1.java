package singleton;

/**
 * ��һ�ַ�ʽ��ֱ��ͬ��
 * @author skywalker
 *
 */
public class S1 {

	private static S1 s1;
	
	private S1() {}
	
	public synchronized static S1 getInstance() {
		if(s1 == null) {
			s1 = new S1();
		}
		return s1;
	}
	
}
