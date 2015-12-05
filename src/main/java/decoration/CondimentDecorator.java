package decoration;

/**
 * 调料 装饰者
 * @author skywalker
 *
 */
public abstract class CondimentDecorator extends Beverage {

	private Beverage beverage;
	
	public Beverage getBeverage() {
		return beverage;
	}

	public CondimentDecorator(Beverage beverage) {
		this.beverage = beverage;
	}
	
	/**
	 * 再次重写此方法
	 */
	@Override
	public abstract String getDescription();	
}
