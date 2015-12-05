package factory;

/**
 * ŦԼԭ�Ϲ���
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
