package callback;

/**
 * 任务
 * @author skywalker
 *
 */
public abstract class Task {

	void executeWith(Callback callback) {
		execute();
		if (callback != null) { 
			callback.call();
		}
	}
	
	abstract void execute();
	
}
