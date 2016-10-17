package test.com.timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class TimerTaskTest extends TimerTask{

	@Override
	public void run() {

		DateFormat format = new SimpleDateFormat("hhmmss");
		System.out.println("此刻是 :" + format.format(new Date()));
	}

	
}
