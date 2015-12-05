package command;

/**
 * 遥控器
 * @author skywalker
 *
 */
public class Controler {

	private Command[] onCommands = new Command[2];
	private Command[] offCommands = new Command[2];
	private NoCommand noCommand = new NoCommand();
	//记录上一步操作
	private Command pre = noCommand;
	
	public Controler() {
		for(int i = 0;i < 2;i ++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}
	
	public void setCommand(int plot, Command onCommand, Command offCommand) {
		onCommands[plot] = onCommand;
		offCommands[plot] = offCommand;
	}
	
	public void onLigthOnPressed() {
		onCommands[0].execute();
		pre = onCommands[0];
	}
	
	public void onLigthOffPressed() {
		offCommands[0].execute();
		pre = offCommands[0];
	}
	
	public void onTVOnPressed() {
		onCommands[1].execute();
		pre = onCommands[1];
	}
	
	public void onTVOffPressed() {
		offCommands[1].execute();
		pre = offCommands[1];
	}
	
	public void undo() {
		pre.undo();
	}
	
}
