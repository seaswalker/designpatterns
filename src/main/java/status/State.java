package status;

/**
 * ״̬�ӿ�
 * @author skywalker
 *
 */
public interface State {

	/**
	 * Ͷ��
	 */
	public void insertQuarter();
	
	/**
	 * ��Ǯ
	 */
	public void ejectQuarter();
	
	/**
	 * ��������
	 */
	public void turnCrank();
	
	/**
	 * �����ǹ�
	 */
	public void dispense();
	
}
