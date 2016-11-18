package test.com.designpatterns.decorate;

public class Test {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		beverage = new Mocha(beverage);
		System.out.println(beverage.getDescription() + beverage.cost());
		beverage = new Whip(beverage);
		System.out.println(beverage.getDescription() + beverage.cost());
	}
}
