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
 * Reactorģʽ
 * ���߳��൱��Netty���Ӷ��߳�ģ���е�Acceptor�̣߳����ڼ��������¼�
 * �������൱�ڣ�ʵ���ϱ�demo����ӽ��ܴ󵽴�����һ���߳�(Netty���߳�ģʽ)
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
		
		//������¼�����������Acceptor
		//��ʵ�˴��� Acceptor�߳��൱��Netty���Ӷ��߳�ģ���е����̳߳أ�ֻ����������ֱ��newһ���µ��߳�
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
	 * �����ɷ�
	 * @param key
	 */
	private void dispatch(SelectionKey key) {
		Runnable r = (Runnable) key.attachment();
		if (r != null)
			r.run();
	}

}
