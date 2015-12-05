package status;

/**
 * �Ѿ��۳�
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
		System.out.println("�Ѿ�Ϊ��׼�����ǹ������Ե�....");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("�Ѿ�Ϊ��׼�����ǹ������Ե�....");
	}

	@Override
	public void turnCrank() {
		System.out.println("�Ѿ�Ϊ��׼�����ǹ������Ե�....");
	}

	@Override
	public void dispense() {
		System.out.println("�����ǹ����ˣ�");
		gumballMachine.dispatch();
		if(gumballMachine.getCount() < 1) {
			gumballMachine.setState(gumballMachine.getSoldOutStatus());
		}else {
			gumballMachine.setState(gumballMachine.getNoQuarterStatus());
		}
	}

}
