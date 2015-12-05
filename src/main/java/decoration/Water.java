package decoration;

/**
 * Ë®  ÒûÁÏ
 * @author skywalker
 *
 */
public class Water extends Beverage {
	
	private double price = 0.0;

	public Water() {
		description = "Water";
	}

	@Override
	public double cost() {
		return price;
	}
	
	@Override
	public String getDescription() {
		return description;
	}

}
