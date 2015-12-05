package template;

public class Client {

	public static void main(String[] args) {
		CaffeineBeverage coffee = new Coffe();
		coffee.prepare();
		
		CaffeineBeverage tea = new Tea();
		tea.prepare();
	}
	
}
