package bridge;

/**
 * 具体的抽象
 * @author skywalker
 *
 */
public class ConcreteAbstraction extends Abstraction {

	public ConcreteAbstraction(Implemention implemention) {
		super(implemention);
	}
	
	public void otherOperate() {
		System.out.println("其它方法");
	}

}
