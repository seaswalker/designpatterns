package builder;

import builder.House.HouseBuilder;

/**
 * �Լ���ǰʹ�õ�Builderģʽ�������̫һ��������дһд
 * @author skywalker
 *
 */
public class App {

	public static void main(String[] args) {
		House house = new HouseBuilder("skywalker").withAddress("�ൺ").withMaster("skywalker").withPrice(1000).build();
		System.out.println(house);
	}
	
}
