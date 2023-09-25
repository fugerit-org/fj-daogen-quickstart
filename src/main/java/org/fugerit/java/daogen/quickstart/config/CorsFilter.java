package org.fugerit.java.daogen.quickstart.config;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	@Override
	public void destroy() {
		// no need to do anything at destroy
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		if ( res instanceof HttpServletResponse response ) {
			response.setHeader( "Access-Control-Allow-Origin" , "*" );
			response.setHeader( "Access-Control-Allow-Headers" , "*" );
		}
		chain.doFilter( req, res );
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// no need to do anything at init
	}
	
}
