package com.dianba.userdomain.constant;

import com.dianba.userdomain.commons.vo.Result;

/**
 * 服务层处理后返回异常以及异常内的信息{@link ExceptionCode}
 * @author folo
 */
public class SVCException extends RuntimeException{
    private static final long serialVersionUID = -7289641184663750891L;
    
    private Result ret;
    
    public SVCException(Result ret) {
        this.ret = ret;
    }
    
    public Result getRet() {
        return ret;
    }
    
    public static SVCException error(Result ret){
        return new SVCException(ret);
    }
}
