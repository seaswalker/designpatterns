package adapter;

/**
 * Ñ¼×ÓÊÊÅäÆ÷
 * @author skywalker
 *
 */
public class DuckAdapter implements Duck {
	
	private Turkey turkey;
	
	public DuckAdapter(Turkey turkey) {
		this.turkey = turkey;
	}

	@Override
	public void chirp() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		turkey.fly();
	}

}
