package composite;

import java.util.Iterator;

/**
 * �ն���ģʽ
 * �յ�����
 * @author skywalker
 *
 */
public class NullIterator implements Iterator<MenuComponent> {

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public MenuComponent next() {
		return null;
	}

}
