package com.dianba.userdomain.commons.vo;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.dianba.userdomain.util.ValidUtil;

/**
 * 开放接口返回数据结果
 * @author folo
 *
 */
public class Result {
	private int state;
	private String msg;
	private Map<String, Object> data;
	
	private Result (){
		this(State.Success.code, State.Success.message, null);
	}
	
	private Result (int state, String msg){
		this(state, msg, null);
	}
	
	private Result(int state, String msg, Map<String, Object> data){
		this.state = state;
		this.msg = msg;
		this.data = data;
	}
	
	public static Result OK(){
		return new Result(State.Success.code, State.Success.message, null);
	}
	
	public static Result ERROR(){
		return new Result(State.Error.code, State.Error.message, null);
	}
	
	public Result state(int code) {
		this.state = code;
		return this;
	}
	
	public Result msg(String msg) {
		this.msg = msg;
		return this;
	}
	
	public Result put(String name, Object value){
		if(null == data) data = new HashMap<>();
		data.put(name, value);
		return this;
	}
	
	@SuppressWarnings("unchecked")
    public <T> T get(String name){
        try {
            if(null == data) data = new HashMap<>();
            return (T) data.get(name);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
	
	public String toOldString(){
	    Map<Object, Object> ret = new HashMap<>();
	    
	    String state = "ok";
	    if(State.Error.equal(this.getState())) state = "fail";
	    
	    ret.put("state", state);
	    ret.put("reason", this.getMsg());
	    if(!ValidUtil.anyEmpty(data)) ret.putAll(data);
	    
        return JSON.toJSONString(ret);
    }
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public Result state(State state) {
		this.state = state.getCode();
		this.msg = state.getMessage();
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Result) return JSON.toJSONString(obj).equals(this.toString()) ? true : false;
		else return super.equals(obj);
	}

	/**
	 * <h1>接口状态<h1><p>success=1 成功</p><p>success=0 失败</p>
	 * 1xx 成功
	 * 2xx 失败
	 * 3xx 请求错误
	 * 4xx
	 * 5xx
	 * 6xx
	 * 7xx 已存在
	 * 8xx 未授权，未登录，未找到等
	 * 9xx 系统错误
	 * @author folo
	 *
	 */
	public static enum State{
		Success(100, "成功"),
		
		Error(200, "失败"),
		
		ParamError(300, "请求参数有误"),
		SignError(302, "签名错误"),
		TokenError(305, "token错误"),
		
		RemoteServerError(401, "远程服务器异常"),
		
		NoLogin(600, "未登录"),
		
		AlreadyFound(700, "已存在"),
		AlreadyUser(710, "用户已存在"),
		
		NotFound(801, "未找到"),
		NotUser(810, "用户未找到"),
		
		SysError(900, "系统错误");
		private int code;
		private String message;
		State(int code, String message){
			this.code = code;
			this.message = message;
		}
		
		public boolean equal(Integer code){
			if(null == code) return false;
			return this.code == code ? true : false;
		}
		
		public Result ret(){
			return new Result(code, message);
		}
		
		public Result ret(String msg){
			return new Result(code, msg);
		}
		
		public int getCode(){
			return code;
		}
		
		public String getMessage() {
			return message;
		}
	}
}
