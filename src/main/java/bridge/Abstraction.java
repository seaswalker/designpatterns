package bridge;

/**
 * ����
 * @author skywalker
 *
 */
public abstract class Abstraction {

	protected Implemention implemention;

	public Abstraction(Implemention implemention) {
		this.implemention = implemention;
	}
	
	public void operate() {
		implemention.operate();
	}
	
}
