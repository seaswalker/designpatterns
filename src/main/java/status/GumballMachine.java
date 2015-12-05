package status;

/**
 * �Զ��ǹ�������
 * @author skywalker
 *
 */
public class GumballMachine {

	private NoQuarterStatus noQuarterStatus;
	private HasQuarterStatus hasQuarterStatus;
	private SoldStatus soldStatus;
	private SoldOutStatus soldOutStatus;
	private WinnerStatus winnerStatus;
	
	//��ǰ״̬
	private State state;
	//�ǹ�����
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
	 * �����ǹ�
	 */
	public void dispatch() {
		if(count > 0) {
			count --;
		}
	}
	
	@Override
	public String toString() {
		return "��ǰ״̬:" + state + ",ʣ���ǹ�:" + count;
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
