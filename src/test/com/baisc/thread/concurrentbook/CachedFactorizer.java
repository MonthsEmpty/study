package test.com.baisc.thread.concurrentbook;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.http.annotation.GuardedBy;

public class CachedFactorizer implements Servlet{

	@GuardedBy("this") private BigInteger lastNumber;
	@GuardedBy("this") private BigInteger[] lastFactors;
	@GuardedBy("this") private long hits;
	@GuardedBy("this") private long cacheHits;
	
	public synchronized long getHits(){
		return hits;
	}
	
	public synchronized double getCacheHitRatio(){
		return cacheHits / hits;
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		BigInteger i = extractFromRequest(request);
		BigInteger[] factors = null;
		synchronized (this) {
			++hits;
			if(i.equals(lastNumber)){
				++cacheHits;
				factors = lastFactors.clone();
			}
			
		}
		if(factors == null){
			factors = factors[i];
			synchronized (this) {
				lastNumber = i;
				lastFactors = factors.clone();
			}
			
		}
		
	}
	
	public BigInteger extractFromRequest(ServletRequest request){
		return null;
	}

}
