package producer_consumer;

import java.util.concurrent.BlockingDeque;

public interface WorkingStealingEnabledChannel<E> extends Channel<E> {

	/**
	 * 此方法用来实现工作窃取算法
	 * @param queue 优先从此队列取
	 * @return
	 * @throws InterruptedException
	 */
	E take(BlockingDeque<E> queue) throws InterruptedException;
	
}
