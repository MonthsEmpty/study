package test.com.baisc.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.github.ltsopensource.queue.SuspendJobQueue;

public class CalendarTest {

	public static void main(String[] args) {
		/*DateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-01 00:00:00");
		System.out.println(format.format(new Date()));
		System.out.println(format1.format(new Date()));*/
//		getYesterday();
		getDateOfMonths();
	}
	
	public static void getYesterday(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(calendar.getTime());
	}
	
	/**
	 * 查看某月多少天
	 */
	public static void getDaysOfMonths(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * 
	 */
	public static void getDateOfMonths(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
	}
}
