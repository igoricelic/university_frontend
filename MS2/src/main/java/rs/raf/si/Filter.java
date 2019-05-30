package rs.raf.si;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class Filter implements javax.servlet.Filter {

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
		
		System.out.println(httpRequest.getRequestURI());
		chain.doFilter(request, response);
		
	}

}
