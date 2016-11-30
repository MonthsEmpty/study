package test.com.designpatterns.command;

public class SimpleRemoteControl {

	Command command;
	
	public Command getCommand() {
		return command;
	}


	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void buttonWasPressed(){
		command.execute();
	}
	
}
