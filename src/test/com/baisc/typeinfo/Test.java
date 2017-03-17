package test.com.baisc.typeinfo;

public class Test {

	static {
		System.out.println("init");
	}
	private int i = 3;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		Class c = Test.class;
		Class c = Test.class;
//		Class c = Class.forName("test.com.baisc.typeinfo.Test");
		/*Test t = (Test) c.newInstance();
		System.out.println(t.i);
		System.out.println(c.getClass().getName());
		System.out.println(c.getClass().getName());*/
		
	}
}
