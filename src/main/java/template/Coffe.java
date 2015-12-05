package template;

/**
 * ¿§·È
 * @author skywalker
 *
 */
public class Coffe extends CaffeineBeverage {

	@Override
	protected void brew() {
		System.out.println("³å¿§·È...");
	}

	@Override
	protected void addCondiments() {
		System.out.println("¼ÓÅ£ÄÌ...");
	}
	
	/**
	 * ÖØĞ´¹³×Ó
	 */
	@Override
	protected boolean isAddCondiments() {
		return false;
	}

}
