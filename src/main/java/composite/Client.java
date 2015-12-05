package composite;

/**
 * 测试组合
 * @author skywalker
 *
 */
public class Client {

	public static void main(String[] args) {
		MenuComponent top = new Menu("菜单", "总菜单");
		MenuComponent breakfast = new Menu("早餐", "只卖早餐");
		breakfast.add(new MenuItem("有条", "", 12));
		breakfast.add(new MenuItem("豆浆", "哈哈", 1));
		top.add(breakfast);
		
		Menu lanch = new Menu("午餐", "只卖午餐");
		lanch.add(new MenuItem("馒头", "大馒头", 0.5));
		lanch.add(new MenuItem("米饭", "", 1.0));
		top.add(lanch);
		
		Menu sweet = new Menu("甜点", "");
		sweet.add(new MenuItem("大白兔", "", 2.0));
		lanch.add(sweet);
		
		//top.print();
		
		//测试组合迭代器(外部迭代器)
		ComponentIterator iterator = new ComponentIterator(top.iterator());
		while(iterator.hasNext()) {
			System.out.println(iterator.next().getName());
		}
	}
	
}
