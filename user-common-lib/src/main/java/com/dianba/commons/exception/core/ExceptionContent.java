package com.dianba.commons.exception.core;

/**
 * 异常容器
 *
 * @author zhoucong
 * @date 2016年3月25日 下午3:15:46
 */
public class ExceptionContent extends ResponseContent {

	public ExceptionContent() {
		super();
		super.code = AssertCore.G1000.getCode();
		super.msg = AssertCore.G1000.getMsg();
	}

	public static ExceptionContent init(ApplicationException applicationException) {
		ExceptionContent content = new ExceptionContent();
		// content.setGcode(applicationException.getGcode());
		content.setCode(applicationException.getCode());
		content.setMsg(applicationException.getMsg());
		content.addResponse("codeProperties", applicationException.getTag());
		return content;
	}
}
