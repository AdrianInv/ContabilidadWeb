package com.integra.contabilidad.util;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.integra.contabilidad.controller.SeguridadController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FiltroCORS implements Filter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SeguridadController.class);

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	    HttpServletResponse response = (HttpServletResponse) res;
	    
	    HttpServletRequest request = (HttpServletRequest) req;
	    
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    
	    LOGGER.info("Starting a transaction for req : {}" + request.getHeaderNames() );
	    
	    
	    if (request.getMethod()!= "GET") {
	      chain.doFilter(req, res);
	    } else {
	    }
	  }

	 public void init(FilterConfig filterConfig) {}

	 public  void destroy() {}
}
