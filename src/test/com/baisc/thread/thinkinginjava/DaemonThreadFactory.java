package test.com.baisc.thread.thinkinginjava;

import java.util.concurrent.ThreadFactory;

/**
 * 编写定制化的ThreadFactory可以定制由Executor创建的线程的属性(后台、优先级、名称)
 * @author Administrator
 *
 */
public class DaemonThreadFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable paramRunnable) {
		Thread t = new Thread(paramRunnable);
		t.setDaemon(true);
		return t;
	}

}
