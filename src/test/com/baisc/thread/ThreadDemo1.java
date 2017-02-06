package test.com.baisc.thread;

public class ThreadDemo1 {

	public static void main(String[] args) {
		MyThread mt1 = new MyThread("线程1");
		MyThread mt2 = new MyThread("线程2");
		Thread t1 = new Thread(mt1);
		Thread t2 = new Thread(mt2);
		t1.start();
		t2.start();
		
	}
}
