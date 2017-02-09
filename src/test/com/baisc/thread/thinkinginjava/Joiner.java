package test.com.baisc.thread.thinkinginjava;

public class Joiner extends Thread{

	private Sleeper sleeper;
	
	public Joiner(String name,Sleeper sleeper) {
		super(name);
		this.sleeper = sleeper;
		start();
	}
	
	@Override
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
			e.printStackTrace();
		}
		System.out.println(getName() + " join completed");
	}
}
