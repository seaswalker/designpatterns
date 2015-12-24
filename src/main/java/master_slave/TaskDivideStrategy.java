package master_slave;

/**
 * 对原始任务进行划分的策略
 * @author skywalker
 *
 * @param <T> 子任务类型
 */
public interface TaskDivideStrategy<T> {

	/**
	 * 返回下一个子任务，如果返回null，那么表示没有后续子任务 
	 * @return 下一个子任务
	 */
	T nextChunk();
	
}
