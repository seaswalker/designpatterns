package factory;

/**
 * 抽象类，披萨商店
 * @author skywalker
 *
 */
public abstract class PizzaStore {
	
	protected Pizza pizza;
	
	/**
	 * 下订单
	 */
	public Pizza order(String type) {
		pizza = createPizza(type);
		pizza.bake();
		pizza.cut();
		pizza.box();
		System.out.println("您的披萨做好了");
		return pizza;
	}
	
	//生成披萨，抽象工厂方法
	protected abstract Pizza createPizza(String type);

}
