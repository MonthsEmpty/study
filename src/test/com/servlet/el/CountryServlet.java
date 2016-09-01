package test.com.servlet.el;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/CountryServlet"})
public class CountryServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String,String> countries = new HashMap<String, String>();
		countries.put("ca", "canada1");
		countries.put("us", "United States1");
		request.setAttribute("countries", countries);
		request.setAttribute("hello", "helloworld");
		RequestDispatcher rd = request.getRequestDispatcher("/countries.jsp");
		rd.forward(request, response);
	}
	
}
