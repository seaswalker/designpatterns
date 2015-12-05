package command;

/**
 * 代打开电视
 * @author skywalker
 *
 */
public class TVOnCommand implements Command {
	
	private TV tv;
	
	public TVOnCommand(TV tv) {
		this.tv = tv;
	}

	@Override
	public void execute() {
		tv.on();
	}

	@Override
	public void undo() {
		tv.off();
	}
	
}
