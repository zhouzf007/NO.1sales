package com.dianba.userdomain.commons.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * $.ajax后需要接受的JSON
 * 
 * @author
 * 
 */
public class AjaxJson {

	private boolean success = true; // 是否成功
	private String msg = "操作成功"; // 提示信息
	private Object obj = null; // 结果集
	private Map<String, AjaxJson> arrayAjaxJson; // 多结果集的JSON信息
	private String sql; // 参数补全后的sql
	private String type;
	private Integer affectedRows; // 受影响的行数
	private Map<String, Object> attributes;
	private String sessionkey = null;
	private String state="success";//sessionkey状态
	private String stateCode = "00";//状态码  00正常 01异常

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public AjaxJson() {
		super();
		arrayAjaxJson = new HashMap<String, AjaxJson>();
	}

	public Map<String, AjaxJson> getArrayAjaxJson() {
		return arrayAjaxJson;
	}

	public void setArrayAjaxJson(Map<String, AjaxJson> arrayAjaxJson) {
		this.arrayAjaxJson = arrayAjaxJson;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getAffectedRows() {
		return affectedRows;
	}

	public void setAffectedRows(Integer affectedRows) {
		this.affectedRows = affectedRows;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public String getSessionkey() {
		return sessionkey;
	}

	public void setSessionkey(String sessionkey) {
		this.sessionkey = sessionkey;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
