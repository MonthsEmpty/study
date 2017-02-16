package test.com.baisc.thread.thinkinginjava;

/**
 * 为了将EvenChecker与我们要试验的各种类型的生成器解耦，我们创建这个IntGenerator抽象类
 * 这样子只要给EvenChecker传递IntGenerator的实现类就行。
 * @author Administrator
 *
 */
public abstract class IntGenerator {

	private volatile boolean canceled = false;
	public abstract int next();
	//Allow this to be canceled
	public void cancel(){
		canceled = true;
	}
	
	public boolean isCanceled(){
		return canceled;
	}
	
}
