package test.com.baisc.thread.thinkinginjava;

import java.io.PrintStream;

public class Test {

	public static void main(String[] args) {
		int a = 10;
		int b =20;
		method(a,b);
		System.out.println("a=" + a);
		System.out.println("b=" + b);
	}
	
	public static void method(int a,int b){
		System.out.println("a=100,b=200");
		System.exit(0);
	}
	
	public static void method1(int a,int b){
		PrintStream ps = new PrintStream(System.out){
			public void println(String x) {
				if(x != null && ("a=10".equals(x) || "b=20".equals(x))){
					String[] xs = x.split("=");
					int temp = Integer.valueOf(xs[1]);
					temp = temp * 10;
					super.println(xs[0] + "=" + temp);
				}else{
					super.println(x);
				}
			}
		};
		System.setOut(ps);
	}
}
