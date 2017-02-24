package test.com.baisc.thread.myttest;

public class Count implements Runnable{

	@Override
	public void run() {

		int a = 10;
		for(int i = 0 ; i < 100 ; i++){
			System.out.println(a++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
