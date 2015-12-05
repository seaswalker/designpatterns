package strategy;

/**
 * ��ƤѼ
 * @author skywalker
 *
 */
public class RubberDuck extends Duck {
	
	public RubberDuck(FlyBehavior flyBehavior, ChirpBehavior chirpBehavior) {
		super(flyBehavior, chirpBehavior);
	}

	@Override
	public void display() {
		System.out.println("������ƤѼ");
	}

	@Override
	public void swim() {
		System.out.println("�һ���Ӿ");
	}

}
