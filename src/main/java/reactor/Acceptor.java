package reactor;

import java.io.IOException;
import java.nio.channels.SocketChannel;

public class Acceptor implements Runnable {
	
	private Reactor reactor;
	
	public Acceptor(Reactor reactor) {
		this.reactor = reactor;
	}

	@Override
	public void run() {
		try {
			SocketChannel channel = reactor.serverSocketChannel.accept();
			if (channel != null) {
				new SocketReadHandler(reactor.selector, channel);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
