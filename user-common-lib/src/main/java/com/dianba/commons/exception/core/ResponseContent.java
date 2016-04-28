/**
 * 
 */
package com.dianba.commons.exception.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果
 *
 * @author zhoucong
 * @date 2016年3月25日 下午3:14:30
 */
public class ResponseContent {
	protected Integer code = AssertCore.G0000.getCode();
	protected String msg = AssertCore.G0000.getMsg();
	protected Map<String, Object> response = new HashMap<>();

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getResponse() {
		return response;
	}

	public void addResponseBody(Object obj) {
		this.response.put("body", obj);
	}

	public void addResponse(String key, Object obj) {
		this.response.put(key, obj);
	}

	public void addAllResponse(Map<String, Object> map) {
		this.response.putAll(map);
	}

}
