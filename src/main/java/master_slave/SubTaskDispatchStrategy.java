package master_slave;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * 子任务分派策略
 * @author skywalker
 *
 * @param <T> 子任务类型
 * @param <V> 子任务处理结果类型
 */
public interface SubTaskDispatchStrategy<T, V> {

	/**
	 * 子任务分派
	 * @param slaves 
	 * @param taskDivideStrategy 任务划分策略
	 * @return
	 * @throws InterruptedException
	 */
	Iterator<Future<V>> dispatch(Set<? extends SlaveSpec<T, V>> slaves, TaskDivideStrategy<T> taskDivideStrategy)
		throws InterruptedException;
	
}
