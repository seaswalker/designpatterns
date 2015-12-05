package factory;

public abstract class Pizza {

	protected String name;
	//Ω¥¡œ¿‡–Õ
	protected Sauce sauce;
	protected Cheese cheese;
	
	public void prepare() {
		System.out.println("preparing " + name);
		if(sauce != null) {
			System.out.println("add " + sauce.getName() + " on it");
		}
		if(cheese != null) {
			System.out.println("add " + cheese.getName() + " on it");
		}
	}
	
	protected void bake() {
		System.out.println("baking for 30 minutes");
	}

	protected void cut() {
		System.out.println("cutting " + name);
	}
	
	protected void box() {
		System.out.println("bioxing " + name);
	}
	
	protected String getName() {
		return name;
	}
	
}
