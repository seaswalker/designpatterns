package composite;

import java.util.Iterator;
import java.util.Stack;

/**
 * 外部迭代器
 * 组合的打印是内部迭代(或者说是递归)
 * @author skywalker
 *
 */
public class ComponentIterator implements Iterator<MenuComponent> {
	
	//存放迭代器
	private Stack<Iterator<MenuComponent>> iterators = new Stack<Iterator<MenuComponent>>();
	
	public ComponentIterator(Iterator<MenuComponent> iterator) {
		this.iterators.push(iterator);
	}

	@Override
	public boolean hasNext() {
		if(iterators.empty()) {
			return false;
		}
		Iterator<MenuComponent> next = iterators.peek();
		if(next.hasNext()) {
			return true;
		}else {
			iterators.pop();
			return hasNext();
		}
	}

	@Override
	public MenuComponent next() {
		if(hasNext()) {
			Iterator<MenuComponent> next = iterators.peek();
			MenuComponent component = next.next();
			//如果是菜单
			if(component instanceof Menu) {
				iterators.push(((Menu) component).iterator());
				return next();
			}else {
				return component;
			}
		}
		return null;
	}

}
