package status;

/**
 * 状态接口
 * @author skywalker
 *
 */
public interface State {

	/**
	 * 投币
	 */
	public void insertQuarter();
	
	/**
	 * 退钱
	 */
	public void ejectQuarter();
	
	/**
	 * 拨动曲柄
	 */
	public void turnCrank();
	
	/**
	 * 发出糖果
	 */
	public void dispense();
	
}
