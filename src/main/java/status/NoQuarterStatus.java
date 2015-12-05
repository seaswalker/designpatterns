package status;

/**
 * ��ʣ���ǹ���û��Ͷ��
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
		System.out.println("Ͷ�����");
		gumballMachine.setState(gumballMachine.getHasQuarterStatus());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("����δͶ�ң�");
	}

	@Override
	public void turnCrank() {
		System.out.println("����Ͷ�ң�");
	}

	@Override
	public void dispense() {
		System.out.println("����Ͷ�ң�");
		
	}

}
