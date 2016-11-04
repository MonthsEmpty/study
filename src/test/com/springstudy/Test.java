package test.com.springstudy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
		Perform perform = (Perform) ctx.getBean("perform");
		perform.perform();
	}
}
