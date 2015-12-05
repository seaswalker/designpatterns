package status;

/**
 * ��ʤ��������
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
		System.out.println("���Ѿ�Ͷ��");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("����Ϊ��׼���ǹ�...");
	}

	@Override
	public void turnCrank() {
		System.out.println("����Ϊ��׼���ǹ�...����ȴ�");
	}

	@Override
	public void dispense() {
		System.out.println("Ϊ�������˵�һö�ǹ�");
		gumballMachine.dispatch();
		if(gumballMachine.getCount() < 1) {
			gumballMachine.setState(gumballMachine.getSoldOutStatus());
			System.out.println("�ܲ��ң�ֻ����һö��");
			return;
		}
		gumballMachine.dispatch();
		System.out.println("���ĵڶ�ö�ǹ�����");
		if(gumballMachine.getCount() < 1) {
			gumballMachine.setState(gumballMachine.getSoldOutStatus());
		}else {
			gumballMachine.setState(gumballMachine.getNoQuarterStatus());
		}
	}

}
