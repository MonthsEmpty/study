package test.com.servlet.session.httpsession;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServlet;

public class ShoppingCartServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String CART_ATTRIBUTE = "cart";
	
	private List<Product> products = new ArrayList<Product>();
	private NumberFormat currenceFormat = NumberFormat .getCurrencyInstance(Locale.US);
	
	
}
