package test.com.baisc.exception;

public class ExceptionSilencer {

	public static void main(String[] args) {
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println(e);
			return;
		}
	}
}
