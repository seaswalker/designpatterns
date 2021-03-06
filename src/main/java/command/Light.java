package command;

/**
 * 电灯，提供基本的API
 * @author skywalker
 *
 */
public class Light {

	private String name;
	
	public Light(String name) {
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
