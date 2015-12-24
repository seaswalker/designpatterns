package master_slave;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * Master参与者可复用实现
 * @author skywalker
 *
 * @param <T>
 * @param <V>
 * @param <R> 原始任务处理结果类型
 */
public abstract class AbstractMaster<T, V, R> {

	protected volatile Set<? extends SlaveSpec<T, V>> slaves;
	private volatile SubTaskDispatchStrategy<T, V> subTaskDispatchStrategy;
	
	protected void init() {
		slaves = createSlaves();
		subTaskDispatchStrategy = newSubTaskDispatchStrategy();
		for (SlaveSpec<T, V> slave : slaves) {
			slave.init();
		}
	}
	
	/**
	 * 对子类暴露的服务方法
	 * @param params
	 * @return
	 * @throws Exception
	 */
	protected R service(Object...params) throws Exception {
		final TaskDivideStrategy<T> taskDivideStrategy = newTaskDivideStrategy(params);
		
		Iterator<Future<V>> subResults = subTaskDispatchStrategy.dispatch(slaves, taskDivideStrategy);
		
		for (SlaveSpec<T, V> slave : slaves) {
			slave.shutdown();
		}
		
		R result = combineResult(subResults);
		return result;
	}
 	
	/**
	 * 子类实现，创建一组Slave
	 * @return
	 */
	protected abstract Set<? extends SlaveSpec<T, V>> createSlaves();
	
	protected abstract SubTaskDispatchStrategy<T, V> newSubTaskDispatchStrategy();
	
	protected abstract TaskDivideStrategy<T> newTaskDivideStrategy(Object...params);
	
	/**
	 * 合并子结果
	 * @param subResult
	 * @return
	 */
	protected abstract R combineResult(Iterator<Future<V>> subResult);
 	
}
