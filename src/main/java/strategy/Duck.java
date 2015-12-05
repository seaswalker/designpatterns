package strategy;

/**
 * Ѽ�ӳ�����
 * @author skywalker
 *
 */
public abstract class Duck {
	
	protected FlyBehavior flyBehavior;
	protected ChirpBehavior chirpBehavior;
	
	public Duck(FlyBehavior flyBehavior, ChirpBehavior chirpBehavior) {
		this.flyBehavior = flyBehavior;
		this.chirpBehavior = chirpBehavior;
	}
	
	public FlyBehavior getFlyBehavior() {
		return flyBehavior;
	}

	public ChirpBehavior getChirpBehavior() {
		return chirpBehavior;
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setChirpBehavior(ChirpBehavior chirpBehavior) {
		this.chirpBehavior = chirpBehavior;
	}

	/**
	 * ��ʾ��Ϣ
	 */
	public abstract void display();
	
	/**
	 * ��Ӿ
	 */
	public abstract void swim();
	
	/**
	 * ����
	 */
	public void performFly() {
		flyBehavior.fly();
	}
	
	/**
	 * ����
	 */
	public void performChirp() {
		chirpBehavior.chirp();
	}
	
}
