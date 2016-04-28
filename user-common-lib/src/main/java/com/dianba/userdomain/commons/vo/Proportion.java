package com.dianba.userdomain.commons.vo;

import java.io.Serializable;

public class Proportion implements Serializable{
	private static final long serialVersionUID = 6227160587498730997L;
	public Integer scanPayId;
	public Integer discount;
	private Integer begin;
	private Integer end;
	/**
	 * 最大金额 100=1元
	 */
	private Integer maxMoney;
	/**
	 * 最小金额 100=1元
	 */
	private Integer minMoney;
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public Integer getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(Integer maxMoney) {
		this.maxMoney = maxMoney;
	}
	public Integer getMinMoney() {
		return minMoney;
	}
	public void setMinMoney(Integer minMoney) {
		this.minMoney = minMoney;
	}
	
}
