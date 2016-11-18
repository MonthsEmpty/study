package test.com.designpatterns.strategy;

public class Test {

	public static void main(String[] args) {
		Duck d = new LuckyDuck(new HighFly());
		d.fly();
		Duck dd = new LuckyDuck();
		dd.fly();
	}
}
