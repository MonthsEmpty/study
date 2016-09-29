package test.com.servlet.httpclinet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DoPostTestServlet", urlPatterns = { "/doPostTestServlet" })
public class DoPostTestServlet extends HttpServlet{

	private static final long serialVersionUID = -5598953288975704984L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("aaa");
		System.out.println("aaa is :" + str);
		InputStream is = request.getInputStream();
		InputStreamReader reader = new InputStreamReader(is);
		char[] c = new char[1024]; 
		reader.read(c);
		System.out.println();
		System.out.println(new String(c));
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);;
	}
}
