/**
 * 
 */
package com.dianba.commons.exception.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dianba.commons.exception.core.ResponseContent;

/**
 *
 *
 * @author zhoucong
 * @date 2016年3月26日 下午12:34:13
 */
public class ThreadContent {
	private static final ThreadLocal<ResponseContent> RESPONSE_CONTENTS = new ThreadLocal<>();
	private static final ThreadLocal<HttpServletRequest> HTTP_SERVLET_REQUESTS = new ThreadLocal<>();
	private static final ThreadLocal<HttpServletResponse> HTTP_SERVLET_RESPONSES = new ThreadLocal<>();
	private static final Log LOG = LogFactory.getLog(ThreadContent.class);

	public static HttpServletRequest getHttpServletRequest() {
		return HTTP_SERVLET_REQUESTS.get();
	}

	public static HttpServletResponse getHttpServletResponse() {
		return HTTP_SERVLET_RESPONSES.get();
	}

	public static ResponseContent getResponseContent() {
		return RESPONSE_CONTENTS.get();
	}

	public static void setHttpServletRequest(HttpServletRequest request) {
		HTTP_SERVLET_REQUESTS.set(request);
	}

	public static void setHttpServletResponse(HttpServletResponse response) {
		HTTP_SERVLET_RESPONSES.set(response);
	}

	public static void setResponseContent(ResponseContent content) {
		RESPONSE_CONTENTS.set(content);
	}

	public static ResponseContent setResponse(HashMap<String, Object> map) {
		ResponseContent content = RESPONSE_CONTENTS.get();
		content.addAllResponse(map);
		return content;
	}

	public static void freed() {
		RESPONSE_CONTENTS.remove();
		HTTP_SERVLET_RESPONSES.remove();
		HTTP_SERVLET_REQUESTS.remove();
	}

	public static void init(HttpServletRequest request, HttpServletResponse response, String encoding)
			throws UnsupportedEncodingException {
		setHttpServletRequest(request);
		setHttpServletResponse(response);
		request.setCharacterEncoding(encoding);// 在请求里设置上指定的编码
		response.setContentType("application/json; charset=" + encoding);
		response.setCharacterEncoding(encoding);
		ResponseContent content = new ResponseContent();
		setResponseContent(content);
	}

	public static void println(Object obj) throws IOException {
		HttpServletResponse response = HTTP_SERVLET_RESPONSES.get();
		if (response == null) {
			LOG.info("HttpServletResponse is null ");
			return;
		}
		response.getWriter().println(obj);
		response.getWriter().flush();
	}
}
