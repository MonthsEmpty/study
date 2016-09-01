package test.com.servlet.listener.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener,ServletContextListener{

	public void sessionCreated(HttpSessionEvent paramHttpSessionEvent) {

		HttpSession session = paramHttpSessionEvent.getSession();
		ServletContext servletContext = session.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
		int userCount = userCounter.incrementAndGet();
		System.out.println("userCount incremented to :" + userCount);
	}

	public void sessionDestroyed(HttpSessionEvent paramHttpSessionEvent) {

		HttpSession session = paramHttpSessionEvent.getSession();
		ServletContext servletContext = session.getServletContext();
		AtomicInteger userCounter = (AtomicInteger) servletContext.getAttribute("userCounter");
		int userCount = userCounter.decrementAndGet();
		System.out.println("userCount decremented to :" + userCount);
	}

	public void contextInitialized(ServletContextEvent paramServletContextEvent) {
		System.out.println("start");
		ServletContext servletContext = paramServletContextEvent.getServletContext();
		servletContext.setAttribute("userCounter", new AtomicInteger());
		
	}

	public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
		// TODO Auto-generated method stub
		
	}

}
