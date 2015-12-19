package producer_consumer;

import java.util.concurrent.BlockingDeque;

public class WorkStealingChannel<E> implements WorkingStealingEnabledChannel<E> {
	
	/**
	 * 被当前通道管理的所有队列
	 */
	private final BlockingDeque<E>[] managedQueues;
	
	public WorkStealingChannel(BlockingDeque<E>[] managedQueues) {
		this.managedQueues = managedQueues;
	}

	/**
	 * 随机放入一个队列中
	 */
	@Override
	public void put(E e) throws InterruptedException {
		BlockingDeque<E> queue = managedQueues[e.hashCode() % managedQueues.length];
		queue.put(e);
	}

	@Override
	public E take() throws InterruptedException {
		return take(null);
	}

	/**
	 * 实现工作窃取算法
	 */
	@Override
	public E take(BlockingDeque<E> queue) throws InterruptedException {
		E product = null;
		//首先试图从指定的队列取
		if (queue != null) {
			product = queue.poll();
		}
		int queueIndex = -1;
		//从其它队列取
		while (product == null) {
			queueIndex = (queueIndex + 1) % managedQueues.length;
			BlockingDeque<E> target = managedQueues[queueIndex];
			product = target.takeLast();
			if (target == queue) {
				break;
			}
		}
		//随机从其它队列的队尾取
		if (product == null) {
			queueIndex = (int) System.currentTimeMillis() % managedQueues.length;
			product = managedQueues[queueIndex].takeLast();
		}
		return product;
	}

}
