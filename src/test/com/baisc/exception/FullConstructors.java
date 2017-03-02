package test.com.baisc.exception;

public class FullConstructors {

	public static void f() throws MyException {
		System.out.println("Throwing MyException from f()");
		throw new MyException();
	}
	
	public static void g() throws MyException{
		System.out.println("Throwing MyException from g()");
		throw new MyException("Originated in g()");
	}
	
	public static void main(String[] args) {
		
		try {
			f();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		try {
			g();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
	}
}
