package command;

/**
 * ����
 * @author skywalker
 *
 */
public class TV {

	private String name;
	
	public TV(String name) {
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
