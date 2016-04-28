package com.dianba.userdomain.sysdictionary.entity;

import java.io.Serializable;

public class SystemConfig implements Serializable{
	private  static final long serialVersionUID = -5256994465154332222L;
	private Integer id;
	private String code;
	private String value;
	private String remark;
	private String configType;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getConfigType() {
		return configType;
	}
	public void setConfigType(String configType) {
		this.configType = configType;
	}
}