package status;

/**
 * 获胜，两个糖
 * @author skywalker
 *
 */
public class WinnerStatus implements State {
	
	private GumballMachine gumballMachine;
	
	public WinnerStatus(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("您已经投币");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("正在为您准备糖果...");
	}

	@Override
	public void turnCrank() {
		System.out.println("正在为您准备糖果...，请等待");
	}

	@Override
	public void dispense() {
		System.out.println("为您做好了第一枚糖果");
		gumballMachine.dispatch();
		if(gumballMachine.getCount() < 1) {
			gumballMachine.setState(gumballMachine.getSoldOutStatus());
			System.out.println("很不幸，只有这一枚了");
			return;
		}
		gumballMachine.dispatch();
		System.out.println("您的第二枚糖果来了");
		if(gumballMachine.getCount() < 1) {
			gumballMachine.setState(gumballMachine.getSoldOutStatus());
		}else {
			gumballMachine.setState(gumballMachine.getNoQuarterStatus());
		}
	}

}
