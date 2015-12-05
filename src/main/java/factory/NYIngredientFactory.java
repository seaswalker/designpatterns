package factory;

/**
 * 纽约原料工厂
 * @author skywalker
 *
 */
public class NYIngredientFactory implements PizzaIngredientFactory {

	@Override
	public Sauce getSauce() {
		return new MarinaraSauce();
	}

	@Override
	public Cheese getCheese() {
		return new ReggianoCheese();
	}

}
