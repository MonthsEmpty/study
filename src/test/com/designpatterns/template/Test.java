package test.com.designpatterns.template;

public class Test {

	public static void main(String[] args) {
		/*Tea tea = new Tea();
		tea.prepareRecipe();*/
		
		CoffeeinBeverageWithHook coffeeinBeverageWithHook = new CoffeeWithHook();
		
		System.out.println("Making coffee...");
		coffeeinBeverageWithHook.prepareRecipe();
		
		
	}
}
