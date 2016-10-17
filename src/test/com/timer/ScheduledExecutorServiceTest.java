package test.com.timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 参考文献：http://blog.csdn.net/tsyj810883979/article/details/8481621
 * 
 * @author Administrator
 *
 */
public class ScheduledExecutorServiceTest {

	private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	private static DateFormat format = new SimpleDateFormat("hhmmss");

	public static void main(String[] args) {
		ScheduledExecutorServiceTest test = new ScheduledExecutorServiceTest();
		test.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				System.out.println("启动时间 :" + format.format(new Date()));
			}
		}, 5 * 1000, 2 * 1000, TimeUnit.MILLISECONDS);
	}

	/**
	 * scheduleAtFixedRate(Runnable command, long initialDelay,long period,
	 * TimeUnit unit)延迟initialDelay，周期是period,执行任务command,时间刻度是unit
	 * 
	 * @param command
	 * @param initialDelay
	 * @param period
	 * @param unit
	 */
	public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
		System.out.println("此刻是 :" + format.format(new Date()));
		executor.scheduleAtFixedRate(command, initialDelay, period, unit);
	}

}
