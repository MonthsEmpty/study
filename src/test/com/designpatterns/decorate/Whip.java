package test.com.designpatterns.decorate;

public class Whip extends CondimentDecorator{

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ",Whip";
	}

	@Override
	public double cost() {
		return .43 + beverage.cost();
	}

}
