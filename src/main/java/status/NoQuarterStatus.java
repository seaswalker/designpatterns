package status;

/**
 * 有剩余糖果，没有投币
 * @author skywalker
 *
 */
public class NoQuarterStatus implements State {
	
	private GumballMachine gumballMachine;
	
	public NoQuarterStatus(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("投币完成");
		gumballMachine.setState(gumballMachine.getHasQuarterStatus());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("您尚未投币！");
	}

	@Override
	public void turnCrank() {
		System.out.println("请先投币！");
	}

	@Override
	public void dispense() {
		System.out.println("请先投币！");
		
	}

}
