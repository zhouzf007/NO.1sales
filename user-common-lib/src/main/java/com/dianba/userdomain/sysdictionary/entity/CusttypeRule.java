package com.dianba.userdomain.sysdictionary.entity;

import java.io.Serializable;

public class CusttypeRule implements Serializable{
	private  static final long serialVersionUID = 4410901798923904321L;
	private Integer id;
	private String typeName;
	private String typeDesc;
	private Integer amount;
	private String invalid;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeDesc() {
		return typeDesc;
	}
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getInvalid() {
		return invalid;
	}
	public void setInvalid(String invalid) {
		this.invalid = invalid;
	}
}