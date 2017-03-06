package test.com.baisc.collections;

public class C extends B{

	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void printTest() {
		System.out.println("CCC");
	}
	
	public static void main(String[] args) {
		A a = new C();
		a.printTest();
	}

}
