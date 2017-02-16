package test.com.baisc.thread.thinkinginjava;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttempLocking {

	private ReentrantLock lock = new ReentrantLock();
	public void untimed(){
		boolean captured = lock.tryLock();
		try {
			System.out.println("tryLock(): " + captured);
		} finally{
			if(captured){
				lock.unlock();
			}
		}
	}
	
	public void timed(){
		boolean captured = false;
		try {
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		try {
			System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
		} finally{
			if(captured){
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		final AttempLocking attempLocking = new AttempLocking();
		attempLocking.untimed(); // True -- lock is available
		attempLocking.timed();	// True -- lock is available
		// Now create a separate task to grab the lock
		new Thread(){
			{
				setDaemon(true);
			}
			@Override
			public void run() {
				attempLocking.lock.lock();
				System.out.println("acquired");
			}
		}.start();
		Thread.yield();
		attempLocking.untimed();
		attempLocking.timed();
	}
	
}
