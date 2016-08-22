package test.com.servlet.session.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/cookieClass"})
public class CookieClassServlet extends HttpServlet{

	private static final long serialVersionUID = 1924196159884108L;

	private String[] methods = {
			"clone","getComment","getDomain",
			"getMaxAge","getName","getPath",
			"getSecure","getValue","getVersion",
			"isHttpOnly","setMaxAge","setPath",
			"setSecure","setValue","setVersion"
	};
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie maxRecordsCookie = null;
		if(cookies != null){
			for(Cookie cookie : cookies){
				if("maxRecords".equals(cookie.getName())){
					maxRecordsCookie = cookie;
					break;
				}
			}
		}
		int maxRecords = 5;
		if(maxRecordsCookie != null){
			try {
				maxRecords = Integer.parseInt(maxRecordsCookie.getValue());
			} catch (Exception e) {
			}
		}
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head>" + "<title>Cookie Class</title>"
					+"</head><body>"
				+ PreferenceServlet.MENU
				+ "<div>Here are some of the methods in " + "javax.servlet.http.Cookie"
				);
		writer.print("<ul>");
		for(int i = 0;i<maxRecords;i++){
			writer.print("<li>" + methods[i] + "</li>");
		}
		writer.print("</ul>");
		writer.print("</div></body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
}
