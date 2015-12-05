package composite;

import java.util.Iterator;

/**
 * 空对象模式
 * 空迭代器
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
