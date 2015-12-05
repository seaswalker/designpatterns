package builder;

import builder.House.HouseBuilder;

/**
 * 自己以前使用的Builder模式和这个不太一样，所以写一写
 * @author skywalker
 *
 */
public class App {

	public static void main(String[] args) {
		House house = new HouseBuilder("skywalker").withAddress("青岛").withMaster("skywalker").withPrice(1000).build();
		System.out.println(house);
	}
	
}
