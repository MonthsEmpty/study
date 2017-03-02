package test.com.baisc.exception;

public class MyException extends Exception{
	
	private static final long serialVersionUID = -4376494508918411301L;

	public MyException() {

	}
	
	public MyException(String msg) {
		super(msg);
	}
}
