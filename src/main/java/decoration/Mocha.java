package decoration;

/**
 * Ä¦¿¨ µ÷ÁÏ
 * @author skywalker
 *
 */
public class Mocha extends CondimentDecorator {

	public Mocha(Beverage beverage) {
		super(beverage);
	}

	@Override
	public String getDescription() {
		return getBeverage().getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return getBeverage().cost() + 0.5;
	}

}
