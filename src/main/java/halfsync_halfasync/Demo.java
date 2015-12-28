package halfsync_halfasync;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * 使用示例
 * @author skywalker
 *
 */
public class Demo {
	
	public static void main(String[] args) {
		XAsyncTask task = new XAsyncTask();
		List<Future<String>> results = new ArrayList<Future<String>>();
		try {
			results.add(task.doSomething("Hello", 1));
			results.add(task.doSomething("Pattern", 2));
			
			for (Future<String> f : results) {
				System.out.println(f.get());
			}
			Thread.sleep(200);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static class XAsyncTask extends AsyncTask<String> {

		@Override
		protected String doInBackground(Object... params) {
			String message = (String) params[0];
			Integer sequence = (Integer) params[1];
			return Thread.currentThread().getName() + " messgae " + sequence + ":" + message;
		}
		
		@Override
		protected void onPreExecute(Object... params) {
			String message = (String) params[0];
			Integer sequence = (Integer) params[1];
			System.out.println(Thread.currentThread().getName() + " messgae " + sequence + ":" + message);
		}
		
		/**
		 * 对外服务方法
		 * @param message
		 * @param sequence
		 * @return
		 */
		public Future<String> doSomething(String message, int sequence) {
			if (sequence < 0) {
				throw new IllegalArgumentException("Invalid sequence: " + sequence);
			}
			return dispatch(message, sequence);
		}
		
	}
	
}
