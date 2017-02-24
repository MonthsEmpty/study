package test.com.baisc.thread.concurrentbook;

public class LoggingWidget extends Widget{

	@Override
	public synchronized void doSomething() {
		System.out.println(toString() + ": calling doSomething");
		super.doSomething();
	}
}
