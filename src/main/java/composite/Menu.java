package composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 子菜单
 * @author skywalker
 *
 */
public class Menu extends MenuComponent {
	
	//子菜单
	private List<MenuComponent> components = new ArrayList<MenuComponent>();

	private String name;
	private String description;
	
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public String getDecrition() {
		return description;
	}
	
	@Override
	public void add(MenuComponent component) {
		components.add(component);
	}
	
	@Override
	public void remove(MenuComponent component) {
		components.remove(component);
	}
	
	/**
	 * 递归打印
	 */
	@Override
	public void print() {
		System.out.println("现在是" + name + "菜单:\n");
		for(MenuComponent component : components) {
			component.print();
		}
	}

	@Override
	public Iterator<MenuComponent> iterator() {
		return components.iterator();
	}
	
}
