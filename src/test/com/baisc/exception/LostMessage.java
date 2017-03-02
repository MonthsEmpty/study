package test.com.baisc.exception;

/**
 * 旧的异常被吃掉了，原始是重新抛出个新的异常
 * @author Administrator
 *
 */
public class LostMessage {

	void f() throws VeryImportException{
		throw new VeryImportException();
	}
	
	void dispose() throws HoHumException{
		throw new HoHumException();
	}
	
	public static void main(String[] args) {
		try {
			LostMessage lm = new LostMessage();
			try {
				lm.f();
			} finally {
				lm.dispose();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("123");
	}
}
