package test.com.baisc.commonclass.Class;

public class ClassDemo {

	public static void main(String[] args) {
		String aa = "";
		Class myClass = aa.getClass();
		//返回的是Class对象所表示的那个类的全类名
		System.out.println(myClass.getName());
		
		//用Class实例化
		Class klass = null;
		try {
			klass = Class.forName("test.com.baisc.commonclass.Class.Print");
			Print print = (Print) klass.newInstance();
			print.print();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
