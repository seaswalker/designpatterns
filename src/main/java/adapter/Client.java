package adapter;

public class Client {

	public static void main(String[] args) {
		Turkey turkey = new AmericaTurkey();
		Duck duck = new DuckAdapter(turkey);
		duck.chirp();
		duck.fly();
	}
	
}
