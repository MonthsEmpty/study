package test.com.httpservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "FormServlet", urlPatterns = { "/formServlet" })
public class FormServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse response) throws ServletException, IOException {
		String servletName = getServletConfig().getServletName();
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head>" + "<body>Hello from " + servletName +"</body></html>");
	}

}
