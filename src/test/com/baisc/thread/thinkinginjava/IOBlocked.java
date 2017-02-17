package test.com.baisc.thread.thinkinginjava;

import java.io.IOException;
import java.io.InputStream;

public class IOBlocked implements Runnable{

	private InputStream is;
	
	public IOBlocked(InputStream is) {
		this.is = is;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Waiting for read():");
			is.read();
		} catch (IOException e) {
			if(Thread.currentThread().isInterrupted()){
				System.out.println("Interupted form blocked I/O");
			}else{
				throw new RuntimeException(e);
			}
		}
		System.out.println("Exiting IOBlocked I/O");
	}

}
