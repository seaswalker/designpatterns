package factory;

/**
 * 抽象工厂----原料工厂
 * @author skywalker
 *
 */
public interface PizzaIngredientFactory {

	public Sauce getSauce();
	
	public Cheese getCheese();
}
