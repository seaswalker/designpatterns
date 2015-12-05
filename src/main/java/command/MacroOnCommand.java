package command;

/**
 * ºê´ò¿ªÃüÁî
 * @author skywalker
 *
 */
public class MacroOnCommand implements Command {
	
	private Command[] commands;
	
	public MacroOnCommand(Command[] commands) {
		this.commands = commands;
	}

	@Override
	public void execute() {
		for(Command command : commands) {
			command.execute();
		}
	}

	@Override
	public void undo() {
		for(Command command : commands) {
			command.undo();
		}
	}
	
}
