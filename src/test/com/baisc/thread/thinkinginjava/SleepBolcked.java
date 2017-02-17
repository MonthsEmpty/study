package test.com.baisc.thread.thinkinginjava;

import java.util.concurrent.TimeUnit;

public class SleepBolcked implements Runnable{

	@Override
	public void run() {

		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exiting SleepBlocked.run()");
	}

}
