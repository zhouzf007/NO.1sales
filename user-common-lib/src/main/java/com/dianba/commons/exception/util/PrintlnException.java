/**
 * 
 */
package com.dianba.commons.exception.util;

/**
 *
 *
 * @author zhoucong
 * @date 2016年3月30日 下午4:00:52
 */
public class PrintlnException {
	public static final void println(Throwable e) {
		e.printStackTrace();
	}
}
