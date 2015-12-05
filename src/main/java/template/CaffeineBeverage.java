package template;

/**
 * 抽象类，咖啡因饮料
 * @author skywalker
 *
 */
public abstract class CaffeineBeverage {

	/**
	 * 加工，模版方法
	 */
	final void prepare() {
		boilWater();
		brew();
		pour();
		if(isAddCondiments()) {
			addCondiments();
		}
	}
	
	
	/**
	 * 烧水
	 */
	protected void boilWater() {
		System.out.println("正在烧水...");
	}

	/**
	 * 冲泡，由子类实现
	 */
	protected abstract void brew();
	
	/**
	 * 倒进杯子
	 */
	protected void pour() {
		System.out.println("倒进杯子...");
	}
	
	/**
	 * 添加调料。子类实现
	 */
	protected abstract void addCondiments();
	
	/**
	 * 钩子
	 * 是否加佐料
	 */
	protected boolean isAddCondiments() {
		return true;
	}
	
}
