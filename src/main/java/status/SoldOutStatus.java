package status;

/**
 * 售罄
 * @author skywalker
 *
 */
public class SoldOutStatus implements State {
	
	@SuppressWarnings("unused")
	private GumballMachine gumballMachine;
	
	public SoldOutStatus(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("已售罄");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("已售罄");
	}

	@Override
	public void turnCrank() {
		System.out.println("已售罄");
	}

	@Override
	public void dispense() {
		System.out.println("已售罄");
	}
	
}
