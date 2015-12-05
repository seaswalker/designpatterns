package factory;

public class CheesePizza extends Pizza {
	
	//ԭ�Ϲ���
	private PizzaIngredientFactory factory;
	
	public CheesePizza(PizzaIngredientFactory factory) {
		this.factory = factory;
	}

	public CheesePizza() {
		name = "cheese pizza";
		cheese = factory.getCheese();
	}
	
}
