package com.dianba.userdomain.constant;

/**
 * 优惠券发放条件类型
 * @author folo
 */
public enum PutConditionType {
    FIXED(1, "固定金额"),
    DISCOUNT(2, "扣点模式");
    
    private int code;
    private String cnName;
    private PutConditionType(int code, String cnName) {
        this.code = code;
        this.cnName = cnName;
    }
    
    public static PutConditionType get(int code){
        for (PutConditionType putType : PutConditionType.values()) {
            if(putType.getCode() == code) return putType;
        }
        return null;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getCnName() {
        return cnName;
    }
    
    public boolean equals(PutConditionType equalType){
        if(null == equalType) return false;
        return equalType.getCode() == this.getCode();
    }
    
    public boolean equals(Integer code){
        if(null == code) return false;
        return code == this.getCode();
    }
}
