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

@WebServlet(urlPatterns = {"/employee"})
public class EmployeeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Address address = new Address();
		address.setStreetName("Rue D'Anjou");
		address.setStreetNumber("5090B");
		address.setCity("Brossard");
		address.setState("Quebec");
		address.setZipCode("A1A B2B");
		address.setCountry("Canada");
		
		Employee employee = new Employee();
		employee.setId(1099);		
		employee.setName("Charles Unjeye");
		employee.setAddress(address);
		
		request.setAttribute("employee", employee);
		Map<String,String> capitals = new HashMap<String, String>();
		capitals.put("china", "beijing");
		capitals.put("Austria", "Vienna");
		capitals.put("Australia", "Canberra");
		capitals.put("Canada", "Ottawa");
		request.setAttribute("capitals", capitals);
		
		request.setAttribute("aaa", "aaa");
		
		RequestDispatcher rd = request.getRequestDispatcher("/employee.jsp");
		rd.forward(request, response);
	}
}
