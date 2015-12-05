package decoration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Client {

	public static void main(String[] args) throws IOException {
		Beverage mochaWine = new Wine();
		mochaWine = new Mocha(mochaWine);
		System.out.println(mochaWine.getDescription() + " : " + mochaWine.cost());
		
		//done
		testInput();
	}
	
	public static void testInput() throws IOException {
		File file = new File("C:/Users/xsdwe_000/Desktop/½ø¶È.txt");
		LowerCaseInputStream lcis = new LowerCaseInputStream(new FileInputStream(file));
		int i = -1;
		while((i = lcis.read()) != -1) {
			System.out.print((char) i);
		}
		lcis.close();
	}
	
}
