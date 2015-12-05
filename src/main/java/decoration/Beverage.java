package decoration;

/**
 * 饮料抽象类
 * @author skywalker
 *
 */
public abstract class Beverage {
	
	protected String description;

	/**
	 * 返回价格
	 */
	public abstract double cost();

	public String getDescription() {
		return description;
	} 
	
}
