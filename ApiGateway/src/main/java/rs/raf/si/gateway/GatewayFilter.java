package rs.raf.si.gateway;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class GatewayFilter implements Filter {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		httpResponse.addHeader("Access-Control-Allow-Origin", "*");
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET,PUT,PATCH,DELETE,POST,OPTIONS");
		httpResponse.addHeader("Access-Control-Max-Age", "3600");
		httpResponse.addHeader("Access-Control-Allow-Headers",
				"Origin, x-requested-with, X-AUTH-TOKEN, Content-Type, Accept");

		System.out.println(">>> "+httpRequest.getRequestURL());
		System.out.println(httpRequest.getMethod());
		String redirectUrl = "http://127.0.0.1:2221/sum";
		httpResponse.setHeader("Location", redirectUrl);
		httpResponse.setStatus(307);
		HttpPost httpPost = new HttpPost();
		
		
		/*
		if(httpRequest.getRequestURI().contains("/ms2/")) {
			//System.out.println("Redirektujem...");
			//RequestDispatcher dispatcher = httpRequest.getRequestDispatcher(redirectUrl);
			//System.out.println(dispatcher == null);
			//dispatcher.forward(request, response);
			//httpResponse.setStatus(302);
			//httpResponse.setHeader("Location", redirectUrl);
			//dispatcher.in
			//httpResponse.sendRedirect(redirectUrl);
			//httpResponse.setStatus(307); //this makes the redirection keep your requesting method as is.
			//httpResponse.addHeader("Location", redirectUrl);
		} else {
			chain.doFilter(request, response);
		}
		*/
		
	}

}
