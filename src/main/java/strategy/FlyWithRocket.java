package strategy;

/**
 * ������Ϊʵ����-�û��
 * @author skywalker
 *
 */
public class FlyWithRocket implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("��rocket����");
	}

}
