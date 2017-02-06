package test.com.baisc.thread;

public class MyThread implements Runnable{

	private String name;
	
	public MyThread(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i = 0;i<10 ;i++){
			System.out.println(name + "运行, i = " + i );
		}
	}
}
