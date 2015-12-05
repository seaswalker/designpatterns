package status;

import java.util.Random;

/**
 * 已经投币
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
		System.out.println("请不要重复投币！");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("正在退款...");
		gumballMachine.setState(gumballMachine.getNoQuarterStatus());
	}

	@Override
	public void turnCrank() {
		System.out.println("正在为您准备糖果...");
		int num = random.nextInt(10);
		// 10%的几率中奖
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
