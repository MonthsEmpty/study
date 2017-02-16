package test.com.baisc.thread.thinkinginjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable{

	@Override
	public void run() {

		throw new RuntimeException();
	}
	
	public static void main(String[] args) {
//		ExecutorService executorService = Executors.newCachedThreadPool();
//		executorService.execute(new ExceptionThread());
		
		try {
			ExecutorService executorService = Executors.newCachedThreadPool();
			executorService.execute(new ExceptionThread());
		} catch (RuntimeException re) {
			System.out.println("Exception has been handled!");
		}
	}

}
