package com.dianba.userdomain.sysdictionary.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统文本信息存储通用类
 * @author folo
 *
 */
public class SysText implements Serializable{
	private static final long serialVersionUID = 6189973071291650385L;
	/** 主键 自增 */
	private Integer id;
	
	/** 文本key */
	private Long code;
	
	/** 类型 */
	private String codeType;
	
	/** 文本信息名称 */
	private String codeName;
	
	/** 文本信息内容 */
	private String codeValue;
	
	/** 创建时间 */
	private Date createdTime;
	
	/** 创建者 */
	private Long caretedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	
	public String getCodeType() {
		return codeType;
	}
	
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Long getCaretedBy() {
		return caretedBy;
	}

	public void setCaretedBy(Long caretedBy) {
		this.caretedBy = caretedBy;
	}
	
}
