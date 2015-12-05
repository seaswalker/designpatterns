package command;

/**
 * ∫Íπÿ±’√¸¡Ó
 * @author skywalker
 *
 */
public class MacroOffCommand implements Command {
	
	private Command[] commands;
	
	public MacroOffCommand(Command[] commands) {
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
