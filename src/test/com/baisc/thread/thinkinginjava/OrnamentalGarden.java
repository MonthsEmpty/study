package test.com.baisc.thread.thinkinginjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 这个例子其实就是表现了synchronized同步效果
 * 其次是展现了一个终止任务的方法
 * @author Administrator
 *
 */
public class OrnamentalGarden {

	public static void main(String[] args) throws Exception {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i = 0;i<5;i++){
			executorService.execute(new Entrance(i));
		}
		TimeUnit.SECONDS.sleep(3);
		Entrance.cancel();
		executorService.shutdown();
		//awaitTermination方法等待每个任务结束，如果所有的任务在超时时间到达之前全部结束，
		//则返回true，否则返回false
		if(!executorService.awaitTermination(250, TimeUnit.MILLISECONDS)){
			System.out.println("Some tasks were not terminated!");
		}
		System.out.println("Total:" + Entrance.getTotalCount());
		System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
	}
}
