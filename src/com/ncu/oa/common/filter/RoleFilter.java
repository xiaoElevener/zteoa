package com.ncu.oa.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class RoleFilter implements Filter {

	public FilterConfig config;

	public void destroy() {
		this.config = null;
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) req;
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(
				(HttpServletResponse) resp);
		
		String start_actions=config.getInitParameter("start_actions");
		String end_actions=config.getInitParameter("end_actions");
		
		
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

}
