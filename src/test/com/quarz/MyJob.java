package test.com.quarz;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		/*try {
			
		} catch (NullPointerException e) {
			System.out.println(e);
		} */
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar calendar = Calendar.getInstance();
		Date d = calendar.getTime();
		System.out.println(df.format(d));
		TestMethod.test();
		System.out.println("能不能走到这呢");
	}

}
