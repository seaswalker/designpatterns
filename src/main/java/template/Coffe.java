package template;

/**
 * ����
 * @author skywalker
 *
 */
public class Coffe extends CaffeineBeverage {

	@Override
	protected void brew() {
		System.out.println("�忧��...");
	}

	@Override
	protected void addCondiments() {
		System.out.println("��ţ��...");
	}
	
	/**
	 * ��д����
	 */
	@Override
	protected boolean isAddCondiments() {
		return false;
	}

}
