package com.dianba.userdomain.constant;


public enum PayEnum {
	unionpay("unionpay", "银联"), tenpay("tenpay", "财付通"), 
	weixinpay("weixinpay", "微信支付"), balance("balance", "余额支付"), merchantpay("merchantpay", "商家会员卡支付"), 
	alipay("alipay", "支付宝支付");

	private String en;
	private String cn;

	private PayEnum(String en, String cn) {
		this.en = en;
		this.cn = cn;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}

	public static String getCn(String en) {
		PayEnum pay = valueOf(en);
		if(null != pay)
			return pay.getCn();
		return "";
	}

}
