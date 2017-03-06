package test.com.baisc.thinkinginjava.seven.two;

public class Detergent extends Cleanser{

	@Override
	public void scrub() {
		append(" Detergent.scrub()");
		super.scrub();
	}
	
	// Add methods to the interface:
	public void foam(){
		append(" foam()");
	}
	
	
	
	public static void main(String[] args) {
		Detergent detergent = new Detergent();
		detergent.dilute();
		detergent.apply();
		detergent.scrub();
		detergent.foam();
		System.out.println(detergent);
	}
	
}
