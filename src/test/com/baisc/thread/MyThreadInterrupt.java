package test.com.baisc.thread;

public class MyThreadInterrupt implements Runnable{

	@Override
	public void run() {

		System.out.println("1、进入run方法");
		try {
			Thread.sleep(10000);
			System.out.println("2、已经完成休眠");
		} catch (InterruptedException e) {
			System.out.println("3、休眠被终止");
			return;
		}
		System.out.println("4、run方法正常结束");
	}

}
