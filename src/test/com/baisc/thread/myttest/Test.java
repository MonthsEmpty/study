package test.com.baisc.thread.myttest;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		Count count = new Count();
		Thread thread = new Thread(count);
		thread.start();
		Thread.sleep(10000);
		Thread thread1 = new Thread(count);
		thread1.start();
	}
}
