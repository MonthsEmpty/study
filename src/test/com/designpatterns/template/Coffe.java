package test.com.designpatterns.template;

public class Coffe extends CoffeeinBeverage{

	@Override
	void brew() {
		System.out.println("Dripping coffee into filter");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}
}
