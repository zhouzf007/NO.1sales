package com.dianba.commons.exception.core;

import org.springframework.util.StringUtils;

/**
 * 抽象的应用程序运行时异常
 *
 * @author zhoucong
 * @date 2016年3月25日 下午3:27:32
 */
public abstract class AbstractApplicationRuntimeException extends RuntimeException implements ApplicationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4762773641307470201L;
	protected Integer code;
	protected String msg;
	protected Object tag;

	public AbstractApplicationRuntimeException(AssertCore coreEnum, String msg) {
		this(coreEnum.getCode(),  StringUtils.isEmpty(msg)? coreEnum.getMsg() : msg, null);
	}

	protected AbstractApplicationRuntimeException(Integer code, String msg) {
		this(code, msg, null);
	}

	protected AbstractApplicationRuntimeException(Integer code, String msg, Object tag) {
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
