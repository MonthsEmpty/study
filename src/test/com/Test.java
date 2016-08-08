package test.com;

import java.util.Calendar;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Calendar cl = Calendar.getInstance();
		cl.set(Calendar.HOUR_OF_DAY, 1);
		cl.set(Calendar.MINUTE, 0);
		cl.set(Calendar.SECOND, 0);
		Date dt = cl.getTime();
		System.out.println(dt);
	}

	public void print() {
		System.out.println();
	}

}
