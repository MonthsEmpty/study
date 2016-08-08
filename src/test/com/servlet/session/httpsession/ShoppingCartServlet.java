package test.com.servlet.session.httpsession;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ShoppingCartServlet",urlPatterns = {"/products","/viewProductDetails","/addToCart","/viewCart"})
public class ShoppingCartServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String CART_ATTRIBUTE = "cart";
	
	private List<Product> products = new ArrayList<Product>();
	private NumberFormat currenceFormat = NumberFormat .getCurrencyInstance(Locale.US);
	
	@Override
	public void init() throws ServletException {
		products.add(new Product(1, "Bravo 32' HDTV", "Low-cost HDTV from renowed TV manufacturer", 159.95F));
		products.add(new Product(2, "Bravo BluRay Player", "High qunlity stylish BluRay player", 99.95F));
		products.add(new Product(3, "Bravo Stereo System", "5 speaker hifi system with ipod player", 129.95F));
		products.add(new Product(4, "Bravo ipod player", "An ipod plug-in that can play multiple formats", 39.95F));
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.endsWith("/products")){
			
		}else if(uri.endsWith("/viewProductDetails")){
			
		}else if(uri.endsWith("/viewCart")){
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = 0;
		int quantity = 0;
		productId = Integer.parseInt(request.getParameter("id"));
		quantity = Integer.parseInt(request.getParameter("quantity"));
		
	}
	
	private Product getProduct(int productId){
		for(Product product:products){
			if(product.getId() == productId){
				return product;
			}
		}
		return null;
	}
}
