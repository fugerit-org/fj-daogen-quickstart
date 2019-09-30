package org.fugerit.java.daogen.quickstart.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		if ( res instanceof HttpServletResponse ) {
			HttpServletResponse response = (HttpServletResponse) res;
			response.setHeader( "Access-Control-Allow-Origin" , "*" );
			response.setHeader( "Access-Control-Allow-Headers" , "*" );
		}
		chain.doFilter( req, res );
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}
	
}
