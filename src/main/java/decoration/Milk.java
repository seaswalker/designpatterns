package decoration;

/**
 * Å£ÄÌ µ÷ÁÏ
 * @author skywalker
 *
 */
public class Milk extends CondimentDecorator {

	public Milk(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return getBeverage().getDescription() + ", Milk";
	}

	@Override
	public double cost() {
		return getBeverage().cost() + 2.0;
	}

}
