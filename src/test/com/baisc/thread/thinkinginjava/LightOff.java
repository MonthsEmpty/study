package test.com.baisc.thread.thinkinginjava;

public class LightOff implements Runnable{

	protected int countDown = 10;//default
	private static int taskCount = 0;
	private final int id = taskCount++;
	
	public LightOff() {

	}
	
	public LightOff(int countDown){
		this.countDown = countDown;
	}
	
	public String status(){
		return "#" + id + "(" + 
				(countDown > 0 ? countDown : "LightOff!") + "). "; 
	}
	
	@Override
	public void run() {

		while (countDown-- > 0) {
			System.out.println(status());
			Thread.yield();
		}
	}

}
