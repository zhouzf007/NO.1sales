package com.dianba.commons.exception;

import org.springframework.util.StringUtils;

import com.dianba.commons.exception.core.AbstractApplicationRuntimeException;
import com.dianba.commons.exception.core.AssertCore;

public class APIIllegalArgumentException extends AbstractApplicationRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6111831866235627234L;

	public APIIllegalArgumentException(String msg) {
		super(AssertCore.G4004.getCode(), StringUtils.isEmpty(msg) ? AssertCore.G4004.getMsg() : msg);
	}
}
