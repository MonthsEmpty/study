package test.com.designpatterns.strategy;

public abstract class Duck {

	protected FlyBehavior flyBehavior;
	
	public void setFlyBehavior(FlyBehavior flyBehavior){
		this.flyBehavior = flyBehavior;
	}
	
	abstract void display();
	
	public void fly(){
		if(flyBehavior != null){
			this.flyBehavior.fly();
		}else{
			System.out.println("i can't fly!");
		}
	}
}
