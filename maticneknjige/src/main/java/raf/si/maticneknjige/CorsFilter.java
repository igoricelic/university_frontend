package raf.si.maticneknjige;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CorsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		httpResponse.addHeader("Access-Control-Allow-Origin", "*");
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET,PUT,PATCH,DELETE,POST,OPTIONS");
		httpResponse.addHeader("Access-Control-Max-Age", "3600");
		httpResponse.addHeader("Access-Control-Allow-Headers",
				"Origin, x-requested-with, X-AUTH-TOKEN, REFRESH-TOKEN, Content-Type, Accept");

		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}

}
