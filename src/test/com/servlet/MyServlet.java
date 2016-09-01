package test.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


//Servlet类的名称要以Servlet作为后缀
@WebServlet(name = "MyServlet", urlPatterns = { "/my" })//url模式必须是以"/"开头
public class MyServlet implements Servlet {

	private transient ServletConfig servletConfig;
	
	public void destroy() {

	}

	public ServletConfig getServletConfig() {
		return null;
	}

	public String getServletInfo() {
		return "My Servlet";
	}

	public void init(ServletConfig servletConfig) throws ServletException {

		this.servletConfig = servletConfig;
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String admin = servletConfig.getInitParameter("admin");
		String servletName = servletConfig.getServletName();
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head>" + "<body>Hello from " + servletName + admin + servletConfig+ "</body></html>");
	}

}
