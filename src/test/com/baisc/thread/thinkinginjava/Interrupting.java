package test.com.baisc.thread.thinkinginjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Interrupting {

	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	static void test(Runnable r) throws Exception{
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Interrupting " + r.getClass());
		f.cancel(true);
		System.out.println("Interrupt sent to " + r.getClass().getName() );
	}
	
	public static void main(String[] args) throws Exception {
		test(new SleepBolcked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Aborting with System.exit(0) ");
		System.exit(0);
	}
}
