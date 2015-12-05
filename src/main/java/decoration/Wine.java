package decoration;

/**
 * ¾Æ ÒûÁÏ
 * @author skywalker
 *
 */
public class Wine extends Beverage {

	private double price = 10.0;

	public Wine() {
		description = "Wine";
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
