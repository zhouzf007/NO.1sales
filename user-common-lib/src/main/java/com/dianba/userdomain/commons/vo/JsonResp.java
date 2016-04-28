package com.dianba.userdomain.commons.vo;

import com.alibaba.fastjson.JSON;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * api接口返回数据载体
 * @author 何伟成 
 */
public class JsonResp {

	private int code;

	private String msg;
	
	private String msgDetail;

	private Object response;
	
	private String token;
	
	private Integer pageNo;
	
	private Integer pageSize;
	
	private Integer pageCount;
	
	private Integer rowCount;
	
	private Integer totalCount;
	
	public JsonResp(){
		
	}
	
	public JsonResp(String toke){
		
	}
	
	public JsonResp(int code,String msg,String msgDetail,String token,Object response){
		this.code = code;
		this.msg = msg;
		this.response = response;
		this.token = token;
		this.msgDetail = msgDetail;
		if(response != null && response instanceof PageList<?>){
			PageList<?> pgList = (PageList<?>)response;
			this.pageNo = pgList.getPaginator().getPage();
			this.pageSize = pgList.getPaginator().getLimit();
			this.pageCount = pgList.getPaginator().getTotalPages();
			this.rowCount = pgList.size();
			this.totalCount = pgList.getPaginator().getTotalCount();
		}
	}

	
	public JsonResp setJsonResp(int code,String msg,String msgDetail){
		this.code = code;
		this.msg = msg;
		this.msgDetail = msgDetail;
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode( int code ) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg( String msg ) {
		this.msg = msg;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse( Object response ) {
		this.response = response;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo( Integer pageNo ) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize( Integer pageSize ) {
		this.pageSize = pageSize;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount( Integer pageCount ) {
		this.pageCount = pageCount;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount( Integer rowCount ) {
		this.rowCount = rowCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount( Integer totalCount ) {
		this.totalCount = totalCount;
	}

	public String getMsgDetail() {
		return msgDetail;
	}

	public void setMsgDetail( String msgDetail ) {
		this.msgDetail = msgDetail;
	}
	
	public JsonResp msgDetail(String msgDetail){
	    this.msgDetail = msgDetail;
	    return this;
	}
	
	@Override
	public String toString() {
	    return JSON.toJSONString(this);
	}
}
