package factory;

public class SaucePizza extends Pizza {
	
	//ԭ�Ϲ���
	private PizzaIngredientFactory factory;
	
	public SaucePizza(PizzaIngredientFactory factory) {
		this.factory = factory;
	}

	public SaucePizza() {
		name = "sauce pizza";
		sauce = factory.getSauce();
	}
	
}
