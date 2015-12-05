package bridge;

/**
 * 测试
 * 注意桥接模式指的是将抽象和实现放在两个层次中，以往都是用一个接口引用一个具体的实现，现在更加灵活了
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
