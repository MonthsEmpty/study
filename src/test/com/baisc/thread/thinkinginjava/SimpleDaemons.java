package test.com.baisc.thread.thinkinginjava;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程
 * @author Administrator
 *
 */
public class SimpleDaemons implements Runnable {

	@Override
	public void run() {

		try {
			while (true) {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		} catch (Exception e) {
			System.out.println("sleep() interrupted");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new SimpleDaemons());
			//这边要是没有设置成后台线程，那么将一直跑下去
			//而这边设为了后台线程，那么当main执行完时，这边的线程将不能逃避作为后台线程的命运
			//后台线程的命运：当所有的非后台线程结束时。程序也就终止了，同时会杀死进程中的所有后台线程
			//Q：这个在web中有什么意义呢？换句话说，有什么应用呢？
			daemon.setDaemon(true);//Must call before start()
			daemon.start();
		}
		System.out.println("All deamons started");
		TimeUnit.MILLISECONDS.sleep(175);
	}

}
