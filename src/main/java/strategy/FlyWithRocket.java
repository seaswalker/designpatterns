package strategy;

/**
 * 飞行行为实现累-用火箭
 * @author skywalker
 *
 */
public class FlyWithRocket implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("用rocket飞行");
	}

}
