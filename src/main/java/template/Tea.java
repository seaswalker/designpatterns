package template;

/**
 * ��
 * @author skywalker
 *
 */
public class Tea extends CaffeineBeverage {

	@Override
	protected void brew() {
		System.out.println("�ݲ�...");
	}

	@Override
	protected void addCondiments() {
		System.out.println("�ӵ���");
	}

}
