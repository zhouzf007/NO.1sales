package com.dianba.userdomain.constant;

/**
 * 短信验证码类型
 * @author folo
 *
 */
public enum SmsValidType {
	normal(1000, ""),//其他未知的地方使用的类型
	register(1001, "注册"), 
	reset_password(1002, "找回密码"),
    login(2001, "登录"),
    bind(2002, "绑定手机"),
    fission(3001, "活动");
	
	private int code;
	private String msg;
	SmsValidType(int code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public boolean equal(int code){
		return code == this.code;
	}
	
	public String getMsg(){
		return msg;
	}
	
	public static SmsValidType getByCode(int code){
		for (SmsValidType validType : SmsValidType.values()) {
			if(code == validType.code) return validType;
		}
		return null;
	}
	
	public static SmsValidType getByName(String name){
		for (SmsValidType validType : SmsValidType.values()) {
			if(validType.toString().equals(name)) return validType;
		}
		return null;
	}
}
