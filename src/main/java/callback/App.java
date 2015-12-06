package callback;

public class App {

	public static void main(String[] args) {
		SimpleTask task = new SimpleTask();
		task.executeWith(() -> {
			System.out.println("callback executed");
		});
	}
	
}
