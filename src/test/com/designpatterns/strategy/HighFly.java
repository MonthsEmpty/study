package test.com.designpatterns.strategy;

public class HighFly implements FlyBehavior{

	@Override
	public void fly() {

		System.out.println("i can fly high");
	}

}
