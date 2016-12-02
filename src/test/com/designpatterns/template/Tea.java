package test.com.designpatterns.template;

public class Tea extends CoffeeinBeverage{

	@Override
	void brew() {
		System.out.println("Steeping the tea");
	}

	@Override
	void addCondiments() {
		System.out.println("Adding lemon");
	}
}
