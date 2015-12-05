package factory;

public class Client {

	public static void main(String[] args) {
		PizzaStore store = new NYPizzaStore();
		store.order("cheese");
	}
	
}
