package test.com.quarz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerTest {

	public static void main(String[] args) {
		// 通过schedulerFactory获取一个调度器
		SchedulerFactory schedulerfactory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = schedulerfactory.getScheduler();
			// 创建jobDetail实例，绑定Job实现类
			// 指明job的名称，所在组的名称，以及绑定job类
			JobDetail detail = JobBuilder.newJob(MyJob.class).withIdentity("job1", "jgroup1").build();
			// 定义调度触发规则

			// 使用simpleTrigger规则
			/*Trigger trigger = TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")
					.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(1).withRepeatCount(8)).startNow().build();*/
			
			//使用cornTrigger规则
			Trigger trigger=TriggerBuilder.newTrigger().withIdentity("simpleTrigger", "triggerGroup")  
		              .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? *"))  
		              .startNow().build(); 
			// 把作业和触发器注册到任务调度中
			scheduler.scheduleJob(detail, trigger);

			// 启动调度
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
