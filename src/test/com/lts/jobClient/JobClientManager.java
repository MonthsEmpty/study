package test.com.lts.jobClient;

import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.jobclient.JobClient;
import com.github.ltsopensource.jobclient.RetryJobClient;
import com.github.ltsopensource.jobclient.domain.Response;

public class JobClientManager {

	public static void main(String[] args) {
		JobClient jobClient = new RetryJobClient();
		jobClient.setNodeGroup("test_jobClient");
		jobClient.setClusterName("test_cluster");
		jobClient.setRegistryAddress("zookeeper://10.99.9.111:2181");
		jobClient.start();

		// 提交任务
		Job job = new Job();
		job.setTaskId("3213213123");
		job.setParam("shopId", "11111");
		job.setTaskTrackerNodeGroup("test_trade_TaskTracker");
		// job.setCronExpression("0 0/1 * * * ?");  // 支持 cronExpression表达式
		// job.setTriggerTime(new Date()); // 支持指定时间执行
		Response response = jobClient.submitJob(job);
	}
}
