package master_slave;

import java.util.concurrent.Future;

/**
 * 对Master-Slave中slave参与者的抽象
 * @author skywalker
 *
 * @param <T> 子任务类型
 * @param <V> 子任务处理结果类型
 */
public interface SlaveSpec<T, V> {

	/**
	 * 向slave提交一个任务
	 * @param task 任务
	 * @return
	 * @throws InterruptedException
	 */
	Future<V> submit(final T task) throws InterruptedException;
	
	/**
	 * 初始化Slave实例提供的服务
	 */
	void init();
	
	/**
	 * 停止slave提供的服务
	 */
	void shutdown();
	
}
