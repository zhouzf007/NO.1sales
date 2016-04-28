/**
 * 
 */
package com.dianba.commons.exception;

import org.springframework.util.StringUtils;

import com.dianba.commons.exception.core.AbstractApplicationException;
import com.dianba.commons.exception.core.AssertCore;

/**
 * 枚举状态码的异常容器
 *
 * @author zhoucong
 * @date 2016年3月25日 下午3:32:43
 */
public class EnumerationCheckException extends AbstractApplicationException {

	/**
	 *
	 *
	 * @author zhoucong
	 * @date 2016年3月25日 下午3:33:28
	 */
	private static final long serialVersionUID = -8947382885698480563L;

	/**
	 *
	 *
	 * @param coreEnum
	 * @param msg
	 * @author zhoucong
	 * @date 2016年3月25日 下午3:33:07
	 */
	public EnumerationCheckException(AssertCore coreEnum) {
		this(coreEnum, null, null);
	}

	/**
	 *
	 *
	 * @param coreEnum
	 * @param msg
	 * @param tag
	 * @author zhoucong
	 * @date 2016年3月25日 下午6:04:34
	 */
	public EnumerationCheckException(AssertCore coreEnum, String msg, Object tag) {
		super(coreEnum.getCode(), StringUtils.isEmpty(msg) ? coreEnum.getMsg() : msg, tag);
	}

}
