package decoration;

/**
 * ���� װ����
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
	 * �ٴ���д�˷���
	 */
	@Override
	public abstract String getDescription();	
}
