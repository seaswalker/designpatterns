package status;

/**
 * 已经售出
 * @author skywalker
 *
 */
public class SoldStatus implements State {
	
	private GumballMachine gumballMachine;
	
	public SoldStatus(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("已经为您准备好糖果，请稍等....");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("已经为您准备好糖果，请稍等....");
	}

	@Override
	public void turnCrank() {
		System.out.println("已经为您准备好糖果，请稍等....");
	}

	@Override
	public void dispense() {
		System.out.println("您的糖果来了！");
		gumballMachine.dispatch();
		if(gumballMachine.getCount() < 1) {
			gumballMachine.setState(gumballMachine.getSoldOutStatus());
		}else {
			gumballMachine.setState(gumballMachine.getNoQuarterStatus());
		}
	}

}
