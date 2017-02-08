package test.com.baisc.thread;

public class RunnableTest1 implements Runnable{

	@Override
	public void run() {
		for(int i = 0;i<10;i++){
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread thread = new Thread(new RunnableTest1());
		thread.start();
	}

}
