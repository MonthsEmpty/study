package test.com.baisc.exception;

public class Test {

	public void test() throws SimpleException {
		System.out.println("Throw SimpleException from f()");
		throw new SimpleException();
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		try {
			test.test();
		} catch (SimpleException e) {
			System.out.println("Caught it!");
		}
	}
}
