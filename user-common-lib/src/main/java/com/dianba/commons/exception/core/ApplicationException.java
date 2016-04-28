package com.dianba.commons.exception.core;

/**
 *
 * 自定义运行时异常
 * 
 * @author zhoucong
 * @date 2016年3月25日 下午3:27:57
 */
public interface ApplicationException {
	/**
	 * 获取全部错误的返回信息
	 *
	 * @return
	 * @author zhoucong
	 * @date 2016年3月25日 下午3:28:20
	 */
	ExceptionContent getContent();

	/**
	 * 获取[全局的]错误码
	 *
	 * @return
	 * @author zhoucong
	 * @date 2016年3月25日 下午3:28:52
	 */
	Integer getCode();

	/**
	 *
	 * 错误信息
	 * 
	 * @return
	 * @author zhoucong
	 * @date 2016年3月25日 下午3:29:01
	 */
	String getMsg();

	/**
	 *
	 * 获取附件
	 * 
	 * @return
	 * @author zhoucong
	 * @date 2016年3月25日 下午3:29:12
	 */
	Object getTag();
}
