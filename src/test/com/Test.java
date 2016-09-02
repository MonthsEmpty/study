package test.com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		DateFormat startFormat = new SimpleDateFormat("yyyy-MM-01 00:00:00");
		DateFormat endFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		String startTime = "";
		String endTime = "";
		Calendar calendar = Calendar.getInstance();
		if(calendar.get(calendar.DAY_OF_MONTH) == 1){
			endTime = endFormat.format(calendar.getTime());
			calendar.add(Calendar.MONTH, -1);
			startTime = startFormat.format(calendar.getTime());
		}else{
			startTime = startFormat.format(new Date());
			endTime = endFormat.format(new Date());
		}
		System.out.println("startTime:" + startTime);
		System.out.println("endTime:" + endTime);
	}

	public void print() {

	}

}
