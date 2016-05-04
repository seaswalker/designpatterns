package reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @author skywalker
 *
 */
public class SocketReadHandler implements Runnable {
	
	private SocketChannel socketChannel;
	
	public SocketReadHandler(Selector selector, SocketChannel socketChannel) throws IOException {
		this.socketChannel = socketChannel;
		socketChannel.configureBlocking(false);
		socketChannel.register(selector, SelectionKey.OP_READ, this);
		selector.wakeup();
	}

	@Override
	public void run() {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		try {
			socketChannel.read(buffer);
			//后续处理...
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
