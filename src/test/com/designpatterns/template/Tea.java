package test.com.designpatterns.template;

public class Tea {

	void prepare(){
		boilWater();
		steepTeaBag();
		addLemon();
		pourInCup();
	}
	
	public void boilWater(){
		System.out.println("Boiling water");
	}
	
	public void steepTeaBag(){
		System.out.println("Steeping the tea");
	}
	
	public void addLemon(){
		System.out.println("Adding lemon");
	}
	
	public void pourInCup(){
		System.out.println("Pouring into cup");
	}
}
