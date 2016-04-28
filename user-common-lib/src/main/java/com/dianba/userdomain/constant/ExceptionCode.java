package com.dianba.userdomain.constant;

import com.dianba.userdomain.commons.vo.JsonResp;

/**
 * 异常错误码枚举 
 */
public enum ExceptionCode {

	SUCCESSFUL( 0, "成功" ), 
	FAIL( 100, "失败" ), 
	SESSION_ERROR( -1, "会话验证失败" ), 
	PARAM_ERROR( -2, "参数错误" ), 
	PARAM_DATA_ERROR( -3,"参数数据解析错误" ), 
	PARAM_NULL_ERROR( -4, "参数数据为空或者错误数据" ), 
	DATA_NULL_ERROR( -5, "未查询到数据" ),
	CUST_ERROR( -6, "自定义异常");

	private int codeNo;
	private String codeName;
	private String msgDetail;

	private ExceptionCode(int codeNo, String codeName) {
		this.codeNo = codeNo;
		this.codeName = codeName;
	}

	public int getCodeNo() {
		return codeNo;
	}

	public String getCodeName() {
		return codeName;
	}
	
	public ExceptionCode msg(String msg){
	    this.msgDetail = msg;
	    return this;
	}
	
	public JsonResp error(){
	    return new JsonResp(codeNo, codeName, null, null, null).msgDetail(msgDetail);
	}
	
	/**
	 * @return 返回该编码的json返回值对象
	 */
	public JsonResp resp(Object response){
	    return new JsonResp(codeNo, codeName, null, null, response);
	}
	
	public JsonResp resp(String msgDetail){
        return new JsonResp(codeNo, codeName, null, null, null).msgDetail(msgDetail);
    }
}
