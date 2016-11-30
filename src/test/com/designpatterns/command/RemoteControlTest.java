package test.com.designpatterns.command;

public class RemoteControlTest {

	public static void main(String[] args) {
		SimpleRemoteControl controller = new SimpleRemoteControl();
		Command onCommand = new LightOnCommand(new RoomLight());
		controller.setCommand(onCommand);
		controller.buttonWasPressed();
	}
}
