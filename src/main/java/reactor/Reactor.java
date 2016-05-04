package reactor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Reactor模式
 * 此线程相当于Netty主从多线程模型中的Acceptor线程，用于监听各种事件
 * 仅仅是相当于，实际上本demo代码从接受大到处理都是一个线程(Netty单线程模式)
 * @author skywalker
 *
 */
public class Reactor implements Runnable {
	
	public final Selector selector;
	public final ServerSocketChannel serverSocketChannel;
	
	public Reactor(int port) throws IOException {
		selector = Selector.open();
		serverSocketChannel = ServerSocketChannel.open();
		InetSocketAddress addr = new InetSocketAddress(InetAddress.getLocalHost(), port);
		serverSocketChannel.socket().bind(addr);
		serverSocketChannel.configureBlocking(false);
		SelectionKey key = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		//如果有事件到来，触发Acceptor
		//其实此处的 Acceptor线程相当于Netty主从多线程模型中的主线程池，只不过这里是直接new一个新的线程
		key.attach(new Acceptor(this));
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				int n = selector.select();
				if (n > 0) {
					Set<SelectionKey> keys = selector.selectedKeys();
					Iterator<SelectionKey> iterator = keys.iterator();
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						dispatch(key);
						iterator.remove();
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 任务派发
	 * @param key
	 */
	private void dispatch(SelectionKey key) {
		Runnable r = (Runnable) key.attachment();
		if (r != null)
			r.run();
	}

}
