package test.com.baisc.innerclass;

public class Color {

	private String clr = "clo";
	
	private static String condition = "static";
	
	//这种方式外部还是不可用它
	public Green g = this.new Green();
	
	public class Red{
	
		public void print(){
			System.out.println("red");
		}
	}
	
	/**
	 * 私有内部类
	 * 需要在外部内中的某个方法或者参数实例化他，不然他就废了。
	 * @author Administrator
	 *
	 */
	private class Green{
		
		public void print(){
			System.out.println(clr);
		}
	}
	
	public void printGreen(){
		new Green().print();
	}
	
	public static class yellow{
		public void print(){
			System.out.println(condition);
		}
	}
	
}
