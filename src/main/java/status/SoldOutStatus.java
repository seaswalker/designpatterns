package status;

/**
 * ����
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
		System.out.println("������");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("������");
	}

	@Override
	public void turnCrank() {
		System.out.println("������");
	}

	@Override
	public void dispense() {
		System.out.println("������");
	}
	
}
