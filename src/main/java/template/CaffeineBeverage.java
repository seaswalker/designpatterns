package template;

/**
 * �����࣬����������
 * @author skywalker
 *
 */
public abstract class CaffeineBeverage {

	/**
	 * �ӹ���ģ�淽��
	 */
	final void prepare() {
		boilWater();
		brew();
		pour();
		if(isAddCondiments()) {
			addCondiments();
		}
	}
	
	
	/**
	 * ��ˮ
	 */
	protected void boilWater() {
		System.out.println("������ˮ...");
	}

	/**
	 * ���ݣ�������ʵ��
	 */
	protected abstract void brew();
	
	/**
	 * ��������
	 */
	protected void pour() {
		System.out.println("��������...");
	}
	
	/**
	 * ��ӵ��ϡ�����ʵ��
	 */
	protected abstract void addCondiments();
	
	/**
	 * ����
	 * �Ƿ������
	 */
	protected boolean isAddCondiments() {
		return true;
	}
	
}
