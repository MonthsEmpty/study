package test.com.baisc.thread.thinkinginjava;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用AtomicInteger
 * @author Administrator
 *
 */
public class AtomicityTest1 implements Runnable{

	private AtomicInteger i = new AtomicInteger(0);
	
	public int getValue(){
		return i.get();
	}
	
	private void evenIncrement(){
		i.addAndGet(2);
	}
	
	@Override
	public void run() {

		while(true){
			evenIncrement();
		}
	}
	
	public static void main(String[] args) {
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Aborting");
				System.exit(0);
			}
		}, 5000); // Terminate after 5 seconds
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		AtomicityTest1 at = new AtomicityTest1();
		executorService.execute(at);
		while(true){
			int val = at.getValue();
			if(val % 2 != 0){
				System.out.println(val);
				System.exit(0);
			}
		}
		
	}

}
