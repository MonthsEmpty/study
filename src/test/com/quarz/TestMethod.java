package test.com.quarz;

public class TestMethod {

	private static int count = 0;
	
	public static void test(){
		count++;
		System.out.println(count);
		try {
			if(count == 3){
				System.out.println("准备抛异常");
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			System.out.println(e);
		} finally{
			System.out.println("finally is over");
		}
	}
	
	public static void main(String[] args) {
		count = 2;
		test();
	}
}
