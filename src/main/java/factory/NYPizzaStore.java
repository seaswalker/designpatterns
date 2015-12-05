package factory;

/**
 * ŦԼ�����̵꣬����ŦԼ��ζ������
 * @author skywalker
 *
 */
public class NYPizzaStore extends PizzaStore {
	
	private PizzaIngredientFactory factory = new NYIngredientFactory();

	@Override
	protected Pizza createPizza(String type) {
		if("cheese".equals(type)) {
			pizza = new CheesePizza(factory);
			pizza.name = "New York Cheese Pizza";
		}else if("sauce".equals(type)) {
			pizza = new SaucePizza(factory);
			pizza.name = "New York Sauce Pizza";
		}
		return pizza;
	}

}
