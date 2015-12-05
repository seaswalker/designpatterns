package status;

import java.util.Random;

/**
 * �Ѿ�Ͷ��
 * @author skywalker
 *
 */
public class HasQuarterStatus implements State {
	
	private GumballMachine gumballMachine;
	private Random random = new Random();
	
	public HasQuarterStatus(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("�벻Ҫ�ظ�Ͷ�ң�");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("�����˿�...");
		gumballMachine.setState(gumballMachine.getNoQuarterStatus());
	}

	@Override
	public void turnCrank() {
		System.out.println("����Ϊ��׼���ǹ�...");
		int num = random.nextInt(10);
		// 10%�ļ����н�
		if(num == 0) {
			gumballMachine.setState(gumballMachine.getWinnerStatus());
		}else {
			gumballMachine.setState(gumballMachine.getSoldStatus());
		}
	}

	@Override
	public void dispense() {
		System.out.println("fuck");
	}

}
