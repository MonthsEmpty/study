package test.com.Model2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.com.Model2.form.ProductForm;

public class ControllerServlet extends HttpServlet{

	private static final long serialVersionUID = -6652438260736183902L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
	private void process(HttpServletRequest request,HttpServletResponse response){
		String uri = request.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		if("product_input".equals(action)){
			
		}else if("product_save".equals(action)){
			ProductForm productForm = new ProductForm();
			productForm.setName(request.getParameter("name"));
			productForm.setDescription(request.getParameter("description"));
			try {
				productForm.setPrice(Float.parseFloat(request.getParameter("price")));
			} catch (NumberFormatException e) {
			}
			
		}
	}
}
