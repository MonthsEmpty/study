package test.com.lts.job;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;

public class MyJobRunner implements JobRunner{

	public Result run(JobContext jobContext) throws Throwable {
		try {
            // TODO 业务逻辑
            // 会发送到 LTS (JobTracker上)
            jobContext.getBizLogger().info("测试，业务日志啊啊啊啊啊");

        } catch (Exception e) {
            return new Result(Action.EXECUTE_FAILED, e.getMessage());
        }
        return new Result(Action.EXECUTE_SUCCESS, "执行成功了，哈哈");
	}

}
