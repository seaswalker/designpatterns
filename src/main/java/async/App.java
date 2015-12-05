package async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * ≤‚ ‘
 * @author skywalker
 *
 */
public class App {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		AsyncExecutor executor = new ThreadAsyncExecutor();
		
		AsyncResult<Integer> result1 = executor.startProcess(() -> {
			TimeUnit.SECONDS.sleep(2);
			return 1;
		});
		
		executor.startProcess(() -> {
			return "hello";
		}, (result, ex) -> {
			if (ex.isPresent()) {
				System.out.println("task failed");
			} else {
				System.out.println(result + " skywalker");
			}
		});
		
		System.out.println(executor.endProcess(result1));
	}
	
}
