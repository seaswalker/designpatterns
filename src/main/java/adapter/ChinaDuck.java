package adapter;

public class ChinaDuck implements Duck {

	@Override
	public void chirp() {
		System.out.println("�쳯Ѽ���ڽ�");
	}

	@Override
	public void fly() {
		System.out.println("�쳯Ѽ���ڷ�");
	}

}
