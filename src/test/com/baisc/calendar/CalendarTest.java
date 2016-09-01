package test.com.baisc.calendar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

	public static void main(String[] args) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-01 00:00:00");
		System.out.println(format.format(new Date()));
		System.out.println(format1.format(new Date()));
	}
}
