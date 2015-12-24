package master_slave;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * 简单的轮询派发策略算法
 * @author skywalker
 *
 * @param <T> 子任务类型
 * @param <V> 子任务处理结果类型
 */
public class RoundRobinSubTaskDispatchStrategy<T, V> implements SubTaskDispatchStrategy<T, V> {

	@SuppressWarnings("unchecked")
	@Override
	public Iterator<Future<V>> dispatch(Set<? extends SlaveSpec<T, V>> slaves,
			TaskDivideStrategy<T> taskDivideStrategy) throws InterruptedException {
		//子任务处理结果
		List<Future<V>> subResults = new LinkedList<Future<V>>();
		Object[] slaveArr = slaves.toArray();
		int i = -1, length = slaveArr.length;
		T task;
		while ((task = taskDivideStrategy.nextChunk()) != null) {
			i = (i + 1) % length;
			subResults.add(((SlaveSpec<T, V>) slaveArr[i]).submit(task));
		}
		return subResults.iterator();
	}

}
