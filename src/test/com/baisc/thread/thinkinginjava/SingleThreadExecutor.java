package test.com.baisc.thread.thinkinginjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new LightOff());
		}
		executorService.shutdown();
	}
}
