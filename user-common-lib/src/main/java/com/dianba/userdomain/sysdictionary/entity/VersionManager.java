package com.dianba.userdomain.sysdictionary.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class VersionManager implements Serializable{
	private  static final long serialVersionUID = -832714903159961417L;
	private BigDecimal id;
	private BigDecimal currentVersion;
	private BigDecimal minVersion;
	private String message;
	private String downloadUrl;
	private Date time;
	private Integer type;
	private String forceupdate;

	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getCurrentVersion() {
		return currentVersion;
	}
	public void setCurrentVersion(BigDecimal currentVersion) {
		this.currentVersion = currentVersion;
	}
	public BigDecimal getMinVersion() {
		return minVersion;
	}
	public void setMinVersion(BigDecimal minVersion) {
		this.minVersion = minVersion;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getForceupdate() {
		return forceupdate;
	}
	public void setForceupdate(String forceupdate) {
		this.forceupdate = forceupdate;
	}
}