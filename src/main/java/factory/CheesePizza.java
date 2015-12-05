package factory;

public class CheesePizza extends Pizza {
	
	//原料工厂
	private PizzaIngredientFactory factory;
	
	public CheesePizza(PizzaIngredientFactory factory) {
		this.factory = factory;
	}

	public CheesePizza() {
		name = "cheese pizza";
		cheese = factory.getCheese();
	}
	
}
