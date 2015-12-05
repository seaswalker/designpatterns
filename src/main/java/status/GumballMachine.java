package status;

/**
 * 自动糖果贩卖机
 * @author skywalker
 *
 */
public class GumballMachine {

	private NoQuarterStatus noQuarterStatus;
	private HasQuarterStatus hasQuarterStatus;
	private SoldStatus soldStatus;
	private SoldOutStatus soldOutStatus;
	private WinnerStatus winnerStatus;
	
	//当前状态
	private State state;
	//糖果数量
	private int count = 0;
	
	public GumballMachine(int count) {
		this.noQuarterStatus = new NoQuarterStatus(this);
		this.hasQuarterStatus = new HasQuarterStatus(this);
		this.soldOutStatus = new SoldOutStatus(this);
		this.soldStatus = new SoldStatus(this);
		this.winnerStatus = new WinnerStatus(this);
		this.count = count;
		this.state = noQuarterStatus;
	}
	
	
	public void insertQuarter() {
		state.insertQuarter();
	}
	
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}
	
	/**
	 * 发放糖果
	 */
	public void dispatch() {
		if(count > 0) {
			count --;
		}
	}
	
	@Override
	public String toString() {
		return "当前状态:" + state + ",剩余糖果:" + count;
	}

	public NoQuarterStatus getNoQuarterStatus() {
		return noQuarterStatus;
	}

	public HasQuarterStatus getHasQuarterStatus() {
		return hasQuarterStatus;
	}

	public SoldStatus getSoldStatus() {
		return soldStatus;
	}

	public SoldOutStatus getSoldOutStatus() {
		return soldOutStatus;
	}

	public WinnerStatus getWinnerStatus() {
		return winnerStatus;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public int getCount() {
		return count;
	}
	
}
