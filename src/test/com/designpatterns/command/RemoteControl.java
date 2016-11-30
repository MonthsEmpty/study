package test.com.designpatterns.command;

public class RemoteControl {

	Command[] onCommands;
	Command[] offCommands;
	
	public RemoteControl() {
		onCommands = new Command[7];
		offCommands = new Command[7];
		
		Command noCommand = new NoCommand();
		for(int i=0;i<7;i++){
			
			
			
			
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		
		
	}
}
