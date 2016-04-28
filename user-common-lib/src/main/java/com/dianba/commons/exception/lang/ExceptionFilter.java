package com.dianba.commons.exception.lang;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dianba.commons.exception.util.ThreadContent;

public class ExceptionFilter implements Filter {

	private String encoding = null;

	public void destroy() {
		encoding = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String encoding = getEncoding();
		if (encoding == null) {
			encoding = "utf-8";
		}
		try {
			ThreadContent.init((HttpServletRequest) request, (HttpServletResponse) response, encoding);
			chain.doFilter(request, response);
		} catch (Throwable e) {
			throw e;
		} finally {
			ThreadContent.freed();
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	private String getEncoding() {
		return this.encoding;
	}

}