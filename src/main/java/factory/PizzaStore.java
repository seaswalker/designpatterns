package factory;

/**
 * �����࣬�����̵�
 * @author skywalker
 *
 */
public abstract class PizzaStore {
	
	protected Pizza pizza;
	
	/**
	 * �¶���
	 */
	public Pizza order(String type) {
		pizza = createPizza(type);
		pizza.bake();
		pizza.cut();
		pizza.box();
		System.out.println("��������������");
		return pizza;
	}
	
	//�������������󹤳�����
	protected abstract Pizza createPizza(String type);

}
