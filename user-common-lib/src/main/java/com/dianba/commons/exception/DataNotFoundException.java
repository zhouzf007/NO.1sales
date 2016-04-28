package com.dianba.commons.exception;

import org.springframework.util.StringUtils;

import com.dianba.commons.exception.core.AbstractApplicationRuntimeException;
import com.dianba.commons.exception.core.AssertCore;

public class DataNotFoundException extends AbstractApplicationRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8167430259032934913L;

	public DataNotFoundException(String msg) {
		super(AssertCore.G4001.getCode(), StringUtils.isEmpty(msg) ? AssertCore.G4001.getMsg() : msg);
	}

}
