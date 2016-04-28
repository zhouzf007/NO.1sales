package com.dianba.commons.exception.core;

/**
 * 抽象的检查性异常
 *
 * @author zhoucong
 * @date 2016年3月25日 下午3:31:35
 */
public abstract class AbstractApplicationException extends Exception implements ApplicationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4762773641307470201L;
	protected Integer code;
	protected String msg;
	protected Object tag;

	public AbstractApplicationException(Integer code, String msg) {
		this(code, msg, null);
	}

	public AbstractApplicationException(Integer code, String msg, Object tag) {
		super();
		this.code = code;
		this.tag = tag;
		this.msg = msg;
	}

	@Override
	public ExceptionContent getContent() {
		return ExceptionContent.init(this);
	}

	@Override
	public Integer getCode() {
		return this.code;
	}

	@Override
	public String getMsg() {
		return this.msg;
	}

	@Override
	public Object getTag() {
		return this.tag;
	}

}
