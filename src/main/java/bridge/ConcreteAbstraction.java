package bridge;

/**
 * ����ĳ���
 * @author skywalker
 *
 */
public class ConcreteAbstraction extends Abstraction {

	public ConcreteAbstraction(Implemention implemention) {
		super(implemention);
	}
	
	public void otherOperate() {
		System.out.println("��������");
	}

}
