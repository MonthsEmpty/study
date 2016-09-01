package test.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyTestServlet implements Servlet{

	private static ServletConfig servletConfig;
	
	public void destroy() {
		
	}

	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	public String getServletInfo() {
		return null;
	}

	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig = servletConfig;
	}

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		String initParamter = this.servletConfig.getInitParameter("ininName");
		PrintWriter writer = response.getWriter();
		writer.print(initParamter);
	}

}
