package bridge;

/**
 * ����
 * ע���Ž�ģʽָ���ǽ������ʵ�ַ�����������У�����������һ���ӿ�����һ�������ʵ�֣����ڸ��������
 * @author skywalker
 *
 */
public class App {

	public static void main(String[] args) {
		ConcreteImplementor implementor = new ConcreteImplementor();
		ConcreteAbstraction abstraction = new ConcreteAbstraction(implementor);
		abstraction.operate();
		abstraction.otherOperate();
	}
	
}
