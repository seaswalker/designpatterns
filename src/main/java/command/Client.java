package command;

public class Client {

	public static void main(String[] args) {
		Light light = new Light("���");
		LightOnCommand lightOnCommand = new LightOnCommand(light);
		LightOffCommand lightOffCommand = new LightOffCommand(light);
		Controler controler = new Controler();
		controler.setCommand(0, lightOnCommand, lightOffCommand);
		
		TV tv = new TV("����");
		TVOnCommand tvOnCommand = new TVOnCommand(tv);
		TVOffCommand tvOffCommand = new TVOffCommand(tv);
		controler.setCommand(1, tvOnCommand, tvOffCommand);
		
		/*controler.onLigthOnPressed();
		controler.onLigthOffPressed();
		
		controler.undo();
		
		controler.onTVOnPressed();
		controler.onTVOffPressed();*/
		
		MacroOnCommand macroOnCommand = new MacroOnCommand(new Command[] {lightOnCommand, tvOnCommand});
		MacroOffCommand macroOffCommand = new MacroOffCommand(new Command[] {lightOffCommand, tvOffCommand});
		controler.setCommand(0, macroOnCommand, macroOffCommand);
		//�õ�Ƶ�λ�ò��Ժ�����
		controler.onLigthOnPressed();
		controler.onLigthOffPressed();
	}
	
}
