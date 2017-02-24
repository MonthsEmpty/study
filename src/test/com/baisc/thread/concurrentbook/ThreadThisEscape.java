package test.com.baisc.thread.concurrentbook;

/**
 * 讲解this逃逸,这边是内部类的情况,ThreadThisEscape()构造函数还没有初始化完成，但已经被调用了
 * @author Administrator
 *
 */
public class ThreadThisEscape {

	private final int weight;
	
	public ThreadThisEscape() {
		
//		weight = 1;
		
		new Thread(new EscapeRunnable()).start();
		
		for(int i = 0;i<100000000;i++){
			Thread.yield();
		}
		weight = 1;
		
	}
	
	private class EscapeRunnable implements Runnable{
		
		@Override
		public void run() {

			System.out.println(ThreadThisEscape.this.weight);
			System.out.println(weight);
		}
	}
	
	public void doSomething(){
		
	}
	
	public static void main(String[] args) {
		new ThreadThisEscape();
	}

}
