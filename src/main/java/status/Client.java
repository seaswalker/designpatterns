package status;

public class Client {

	public static void main(String[] args) {
		GumballMachine machine = new GumballMachine(5);
		
		machine.insertQuarter();
		machine.turnCrank();
		
		System.out.println(machine);
		
		machine.insertQuarter();
		machine.ejectQuarter();
	}
	
}
