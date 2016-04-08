package com.lxy.code;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 *字符编码过滤器 
 */
public class CharacterEncodingFilter implements Filter{

	protected String encoding = null;
	protected FilterConfig filterConfig = null;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		//getInitParameter能够访问部署描述符文件（web.xml）中分配的过滤器初始化参数。
		this.encoding = filterConfig.getInitParameter("encoding");
		
	}


	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if(encoding != null){
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html"+encoding);
		}
		chain.doFilter(request, response);
		
	}

	public void destroy() {
		this.encoding = null;
		this.filterConfig = null;		
	}
}
