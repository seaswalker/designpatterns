package strategy;

/**
 * 鸭子抽象类
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
	 * 显示信息
	 */
	public abstract void display();
	
	/**
	 * 游泳
	 */
	public abstract void swim();
	
	/**
	 * 飞行
	 */
	public void performFly() {
		flyBehavior.fly();
	}
	
	/**
	 * 鸣叫
	 */
	public void performChirp() {
		chirpBehavior.chirp();
	}
	
}
