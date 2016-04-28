package com.dianba.userdomain.util;

import com.dianba.userdomain.commons.vo.JsonResp;

/**
 * service层处理业务用于回滚并返回错误信息的自定义异常
 * @author folo
 */
public class ServiceErrorException extends RuntimeException {
    private static final long serialVersionUID = -5279878172894689398L;
    public JsonResp resp;
    
    public ServiceErrorException() {
    }
    
    public ServiceErrorException(JsonResp resp) {
        this.resp = resp;
    }
    
    public JsonResp getResp() {
        return resp;
    }
}
