package decoration;

/**
 * ���ϳ�����
 * @author skywalker
 *
 */
public abstract class Beverage {
	
	protected String description;

	/**
	 * ���ؼ۸�
	 */
	public abstract double cost();

	public String getDescription() {
		return description;
	} 
	
}
