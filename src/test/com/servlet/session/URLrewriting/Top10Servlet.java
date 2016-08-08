package test.com.servlet.session.URLrewriting;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Top10Servlet", urlPatterns = {"/top10"})
public class Top10Servlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<String> londonAttractions;
	private List<String> parisAttactions;
	
	@Override
	public void init() throws ServletException {
		londonAttractions = new ArrayList<String>(10);
		londonAttractions.add("Buckingham Palace");
		londonAttractions.add("London Eye");
		londonAttractions.add("British Museum");
		londonAttractions.add("National Gallery");
		londonAttractions.add("Big Ben");
		londonAttractions.add("Tower of London");
		londonAttractions.add("Natural History Museum");
		londonAttractions.add("Canary Wharf");
		londonAttractions.add("2012 Olymoic Park");
		londonAttractions.add("St Paul's Cathedral");
		
		parisAttactions = new ArrayList<String>();
		parisAttactions.add("Eiffel Tower");
		parisAttactions.add("Notre Dame");
		parisAttactions.add("The Louvre");
		parisAttactions.add("Champs Elysees");
		parisAttactions.add("Arc de Triomphe");
		parisAttactions.add("Sainte Chapelle Church");
		parisAttactions.add("Les Inva");
		parisAttactions.add("Musee d'Orsay");
		parisAttactions.add("Montmarte");
		parisAttactions.add("Sacre Couer Basilica");
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String city = request.getParameter("city");
		if(city != null && ("london".equals(city) || "paris".equals(city))){
			showAttractions(request, response, city);
		}else{
			showMainPage(request, response);
		}
	}
	
	private void showMainPage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head>");
		writer.print("<title>Top 10 Tourist Attractions</title>" + "</head><body>" + 
		"Please select a city: " + 
		"</br><a href = '?city=london'>London</a>" +
		"</br><a href = '?city=paris'>Paris</a>" +
		"</body></html>");
	}
	
	private void showAttractions(HttpServletRequest request,HttpServletResponse response,String city) throws IOException{
		
		int page = 1;
		String pageParameter = request.getParameter("page");
		if(pageParameter != null){
			page = Integer.parseInt(pageParameter);
			if(page >2){
				page = 1;
			}
		}
		List<String> attractions = null;
		if("london".equals(city)){
			attractions = londonAttractions;
		}else if("paris".equals(city)){
			attractions = parisAttactions;
		}
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<html><head>" + "<title>Top 10 Tourist Attractions</title> "+ "</head><body>");
		writer.print("<a href='top10'>Select City</a> ");
		writer.print("<hr>Page " + page + "</hr>");
		
		int start = page * 5 - 5 ;
		for(int i = start;i < start +5; i++ ){
			writer.println(attractions.get(i) + "</br>");
		}
		writer.println("<hr style='color:blue'/>" + "<a href='?city=" + city + "&page=1'>Page 1</a>");
		writer.println("&nbsp; <a href='?city=" + city + "&page=2'>Page 2</a>");
		writer.println("</body></html>");
	}
}
