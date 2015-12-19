package producer_consumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * 使用Semaphore控制生产者的速度--处理通道积压
 * @author skywalker
 *
 */
public class SemaphoreBasedChannel<E> implements Channel<E> {

	private final Semaphore semaphore;
	private final BlockingQueue<E> queue;
	
	public SemaphoreBasedChannel(int limit, BlockingQueue<E> queue) {
		super();
		this.semaphore = new Semaphore(limit);
		this.queue = queue;
	}
	@Override
	public void put(E e) throws InterruptedException {
		semaphore.acquire();
		try {
			queue.put(e);
		} finally {
			semaphore.release();
		}
	}

	@Override
	public E take() throws InterruptedException {
		return queue.take();
	}
	
}
