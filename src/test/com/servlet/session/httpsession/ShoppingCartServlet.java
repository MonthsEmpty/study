package test.com.servlet.session.httpsession;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="ShoppingCartServlet",urlPatterns = {"/products","/viewProductDetails","/addToCart","/viewCart"})
public class ShoppingCartServlet extends HttpServlet{

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
	
	private void sendProductList(HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>Products</title>" + 
					"</head><body><h2>Products</h2>"
				);
		writer.println("<ul>");
		for(Product product : products){
			writer.println("<li>" + product.getName() + "("
					+ currenceFormat.format(product.getPrice())
					+ ") (" + "<a href='viewProductDetails?id="
					+ product.getId() + "'>Detailes</a>"
					);
		}
		writer.println("</ul>");
		writer.println("<a href='viewCart'>View Cart</a>");
		writer.println("</body></html>");
	}
	
	private Product getProduct(int productId){
		for(Product product:products){
			if(product.getId() == productId){
				return product;
			}
		}
		return null;
	}
	
	private void sendProductDetailes(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		int productId = 0;
		try {
			productId = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
		}
		Product product = getProduct(productId);
		
		if(product != null){
			writer.println("<html><head>"
					+ "<body><h2>Product Detailes</h2>"
					+ "<form method='post' action='addToCart'>");
			writer.println("<input type='hidden' name='id'>" + "value='"
					+ productId + "'/>"
					);
			writer.println("<table>");
			writer.println("<tr><td>Name:</td><td>"
					+ product.getName() + "</td></tr>"
					);
			writer.println("<tr><td>Description:</td><td>"
					+ product.getDescription() + "</td></tr>"
					);
			writer.println("<tr>" + "<tr>"
					+ "<td><input name='quantity'/></td>"
					+ "<td><input type='submit' value='Buy'/>"
					+ "</td>"
					+ "</tr>"
					);
			writer.println("<tr><td colspan='2'>"
					+ "<a href='products'>Product List</a>"
					+ "</td></tr>"
					);
			writer.println("</table>");
			writer.println("</form></body>");
		}else {
			writer.println("No product found");
		}
	}
	
	private void showCart(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>Shopping Cart</title>"
				+ "</head>"
				);
		writer.println("<body><a href='products'>"
				+ "Product List</a>"
				);
		HttpSession session = request.getSession();
		List<ShoppingItem> cart = (List<ShoppingItem>) session.getAttribute(CART_ATTRIBUTE);
		if(cart != null){
			writer.println("<table>");
			writer.println("<tr><td style='width:150px'>Quantity"
					+ "</td>"
					+ "<td style='width:150px'>Product</td>"
					+ "<td style='width:150px'>Price</td>"
					+ "<td>Amount</td></tr>"
					);
			double total = 0.0;
			for(ShoppingItem shoppingItem : cart){
				Product product = shoppingItem.getProduct();
				int quantity = shoppingItem.getQuantity();
				if(quantity != 0){
					float price = product.getPrice();
					writer.println("<tr>");
					writer.println("<td>" + quantity + "</td>");
					writer.println("<td>" + product.getName() + "</td>");
					writer.println("<td>" + currenceFormat.format(price) + "</td>");
					double subtotal = price * quantity;
					writer.println("<td>"
							+ currenceFormat.format(total)
							+ "</td></tr>"
							);
					writer.println("</>");
				}
			}
		}
	}
}
