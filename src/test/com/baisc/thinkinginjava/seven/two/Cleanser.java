package test.com.baisc.thinkinginjava.seven.two;


public class Cleanser extends Test{

	private String s = "cleanser";

	public void append(String a) {
		s += a;
	}

	public void dilute() {
		append(" dilute() ");
	}

	public void apply() {
		append(" apply()");
	}

	public void scrub() {
		append(" scrub()");
	}

	@Override
	public String toString() {
		return s;
	}

	public static void main(String[] args) {

		Cleanser cleanser = new Cleanser();
		cleanser.dilute();
		cleanser.apply();
		cleanser.scrub();
		System.out.println(cleanser);
		
	}
}
