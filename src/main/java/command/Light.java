package command;

/**
 * ��ƣ��ṩ������API
 * @author skywalker
 *
 */
public class Light {

	private String name;
	
	public Light(String name) {
		this.name = name;
	}

	public void on() {
		System.out.println(name + "������");
	}
	
	public void off() {
		System.out.println(name + "���ر���");
	}

	public String getName() {
		return name;
	}

}
