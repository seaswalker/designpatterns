package adapter;

public class ChinaDuck implements Duck {

	@Override
	public void chirp() {
		System.out.println("天朝鸭子在叫");
	}

	@Override
	public void fly() {
		System.out.println("天朝鸭子在飞");
	}

}
