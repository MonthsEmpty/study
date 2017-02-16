package test.com.baisc.thread.thinkinginjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

	private IntGenerator generator;
	// final 需要初始化，所以在构造器中初始化之后就可以编译了。
	private final int id;

	public EvenChecker(IntGenerator g, int ident) {
		this.generator = g;
		id = ident;
	}

	/**
	 * 任务主要是检查IntGenerator的数字是否为偶数，是的话继续增加
	 * 否的话修改标志位，所有的EvenChecker都将退出任务
	 */
	@Override
	public void run() {

		while (!generator.isCanceled()) {
			int val = generator.next();
			if (val % 2 != 0) {
				System.out.println(val + " not even!");
				generator.cancel();// Cancels all EvenChecks
			}
		}
	}

	public static void test(IntGenerator gp, int count) {
		System.out.println("Press Control-C to exit");
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < count; i++) {
			executorService.execute(new EvenChecker(gp, i));
		}
		executorService.shutdown();
	}

	public static void test(IntGenerator gp) {
		test(gp, 10);
	}

}
