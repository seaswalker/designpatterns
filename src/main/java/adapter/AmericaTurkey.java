package adapter;

/**
 * ���ۻ�
 * @author skywalker
 *
 */
public class AmericaTurkey implements Turkey {

	@Override
	public void gobble() {
		System.out.println("���ۻ��ڽл�");
	}

	@Override
	public void fly() {
		System.out.println("���ۻ��ڱĴ�");
	}

}
