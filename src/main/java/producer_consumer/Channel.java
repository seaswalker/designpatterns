package producer_consumer;

/**
 * 通道
 * @author skywalker
 *
 */
public interface Channel<E> {

	/**
	 * 加入通道
	 * @param e
	 * @throws InterruptedException
	 */
	void put(E e) throws InterruptedException;
	
	E take() throws InterruptedException;
	
}
