package test.com.baisc.thread;

public class ThreadMethods {

	public static void main(String[] args) {
		// isAlive();
		//join();
		interrupt();
	}

	// 判断线程是否启动
	public static void isAlive() {
		MyThread2 mt = new MyThread2();
		Thread thread = new Thread(mt, "线程");
		System.out.println("线程开始执行之前 -->" + thread.isAlive());
		thread.start();
		System.out.println("线程开始执行之后 -->" + thread.isAlive());
		for (int i = 0; i < 3; i++) {
			System.out.println("main 运行 -->" + i);
		}
		System.out.println("代码执行之后 -->" + thread.isAlive());
	}

	/**
	 * 线程的强制运行
	 * 线程强制运行期间，其他线程无法运行，必须等待此线程完成之后才可以继续执行
	 * 
	 */
	public static void join() {
		MyThread2 mt = new MyThread2();
		Thread thread = new Thread(mt, "线程");
		thread.start();
		for (int i = 0; i < 50; i++) {
			if (i > 2) {
				try {
					thread.join();
				} catch (Exception e) {

				}
			}
			System.out.println("Main 线程运行 --> " + i);
		}
	}
	
	/**
	 * 一个线程运行时，可以在另外一个线程直接通过interrupt()方法中断其运行状态
	 * 一旦中断之后将执行catch中的代码
	 */
	public static void interrupt(){
		MyThreadInterrupt mt = new MyThreadInterrupt();
		Thread t = new Thread(mt, "线程");
		t.start();
		try {
			Thread.sleep(2000);
//			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.interrupt();
	}
}
