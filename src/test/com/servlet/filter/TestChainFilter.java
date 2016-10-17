package test.com.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestChainFilter implements Filter{

	@Override
	public void init(FilterConfig paramFilterConfig) throws ServletException {
		System.out.println("TestChainFilter init");
	}

	@Override
	public void doFilter(ServletRequest paramServletRequest, ServletResponse paramServletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		System.out.println("TestChainFilter");
		filterChain.doFilter(paramServletRequest, paramServletResponse);
	}

	@Override
	public void destroy() {
		
	}

}
