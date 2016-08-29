package test.com.lts.tasktracker;

import test.com.lts.job.MyJobRunner;

import com.github.ltsopensource.tasktracker.TaskTracker;

public class TaskTrackerManager {

	public static void main(String[] args) {
		TaskTracker taskTracker = new TaskTracker();
		taskTracker.setJobRunnerClass(MyJobRunner.class);
		taskTracker.setRegistryAddress("zookeeper://127.0.0.1:2181");
		taskTracker.setNodeGroup("test_trade_TaskTracker");
		taskTracker.setClusterName("test_cluster");
		taskTracker.setWorkThreads(20);
		taskTracker.start();
	}
}
