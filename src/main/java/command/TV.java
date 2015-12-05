package command;

/**
 * 电视
 * @author skywalker
 *
 */
public class TV {

	private String name;
	
	public TV(String name) {
		this.name = name;
	}

	public void on() {
		System.out.println(name + "被打开了");
	}
	
	public void off() {
		System.out.println(name + "被关闭了");
	}

	public String getName() {
		return name;
	}
	
}
