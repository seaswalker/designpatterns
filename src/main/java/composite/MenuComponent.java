package composite;

/**
 * 菜单组件，子菜单和菜单项的父类
 * @author skywalker
 *
 */
public abstract class MenuComponent implements Iterable<MenuComponent> {

	public String getName() {
		throw new UnsupportedOperationException();
	}
	
	public String getDecrition() {
		throw new UnsupportedOperationException();
	}
	
	public double getPrice() {
		throw new UnsupportedOperationException();
	}
	
	public void print() {
		throw new UnsupportedOperationException();
	}
	
	public void add(MenuComponent component) {
		throw new UnsupportedOperationException();
	}
	
	public void remove(MenuComponent component) {
		throw new UnsupportedOperationException();
	}
	
}
