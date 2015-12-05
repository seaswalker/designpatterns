package strategy;

/**
 * 橡皮鸭
 * @author skywalker
 *
 */
public class RubberDuck extends Duck {
	
	public RubberDuck(FlyBehavior flyBehavior, ChirpBehavior chirpBehavior) {
		super(flyBehavior, chirpBehavior);
	}

	@Override
	public void display() {
		System.out.println("我是橡皮鸭");
	}

	@Override
	public void swim() {
		System.out.println("我会游泳");
	}

}
