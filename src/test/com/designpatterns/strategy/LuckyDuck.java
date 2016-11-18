package test.com.designpatterns.strategy;

public class LuckyDuck extends Duck{

	public LuckyDuck(FlyBehavior flyBehavior) {
		this.setFlyBehavior(flyBehavior);
	}
	
	public LuckyDuck() {

	}
	
	@Override
	void display() {

		System.out.println("lucky duck");
	}

}
