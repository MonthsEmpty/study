package test.com.designpatterns.command;

public class RoomLight implements Light{

	@Override
	public void on() {

		System.out.println("Room light is on");
	}

	@Override
	public void off() {
		
		System.out.println("Room light is off");
	}

}
