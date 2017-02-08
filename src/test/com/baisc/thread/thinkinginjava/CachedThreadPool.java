package test.com.baisc.thread.thinkinginjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newCachedThreadPool();
		ExecutorService executorService = Executors.newFixedThreadPool(15);
		for (int i = 0; i < 5; i++) {
			executorService.execute(new LightOff());
		}
		executorService.shutdown();
	}
}
