package test.com.baisc.thread.thinkinginjava;

import java.util.Random;

public class Count {

	private int count = 0;
	private Random rand = new Random(47);

	public synchronized int increment() {
		int temp = count;
		// Random类产生的随机数是伪随机数，rand.nextBoolean()执行后就是true然后false再然后true，是固定的
		// 第一开始不一样是由种子(seed)决定的，也就是上面的47。
		if (rand.nextBoolean()) { // Yield half the time
			Thread.yield();
		}
		return (count = ++temp);
	}

	public synchronized int value() {
		return count;
	}
	
	public static void main(String[] args) {
		Count count = new Count();
		System.out.println(count.rand.nextBoolean());
		System.out.println(count.rand.nextBoolean());
		System.out.println(count.rand.nextBoolean());
		System.out.println(count.rand.nextBoolean());
		
	}
}
