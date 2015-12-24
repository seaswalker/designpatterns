package master_slave;

/**
 * 子任务处理失败异常
 * @author skywalker
 *
 */
@SuppressWarnings("serial")
public class SubTaskFailureException extends Exception {

	@SuppressWarnings("rawtypes")
	public final RetryInfo retryInfo;

	@SuppressWarnings("rawtypes")
	public SubTaskFailureException(RetryInfo retryInfo, Exception cause) {
		super(cause);
		this.retryInfo = retryInfo;
	}
	
}
