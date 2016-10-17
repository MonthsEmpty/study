package test.com.timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {

	private static DateFormat format = new SimpleDateFormat("hhmmss");
	
	private Timer timer = new Timer();
	
	public static void main(String[] args) {
		
		TimerTest test = new TimerTest();
		TimerTask task = new TimerTaskTest();
		/*test.schedule(task, 3*1000);
		System.out.println("");
		//指定执行时间
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 9);
		calendar.set(Calendar.MINUTE, 27);
		calendar.set(Calendar.SECOND, 00);
		Date date = calendar.getTime();
		test.schedule(task, date);*/
		//延迟5秒后每隔2秒执行一次
		test.schedule(task, 5*1000, 2*1000);
		
	}
	
	/**
	 * java.util.Timer.schedule(TimerTask task, long delay) ：延迟delay毫秒后执行task任务。
	 * @param paramTimerTask
	 * @param paramLong
	 */
	public void schedule(TimerTask paramTimerTask, long paramLong){
		System.out.println("启动时间 :" + format.format(new Date()));
		timer.schedule(paramTimerTask, paramLong);
	}
	
	/**
	 * java.util.Timer.schedule(TimerTask paramTimerTask, Date paramDate):指定时间paramDate执行任务paramTimerTask
	 * 启动的时间大于指定时间时就会立刻执行，比如指定9点执行，我10点才启动这时候就会立刻执行任务。
	 * @param paramTimerTask
	 * @param paramDate
	 */
	public void schedule(TimerTask paramTimerTask, Date paramDate){
		System.out.println("启动时间 :" + format.format(new Date()));
		timer.schedule(paramTimerTask, paramDate);
	}
	
	/**
	 * 
	 * @param task
	 * @param delay
	 * @param period
	 */
	public void schedule(TimerTask task,long delay,long period){
		System.out.println("启动时间 :" + format.format(new Date()));
		timer.schedule(task, delay, period);
	}
	
}
