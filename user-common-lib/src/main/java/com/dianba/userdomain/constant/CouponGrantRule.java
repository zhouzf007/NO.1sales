package com.dianba.userdomain.constant;

/**
 * 优惠券发放规则
 * @author folo
 */
public enum CouponGrantRule {
    ALL(1, "全体"),
    EACH(2, "互发"),
    ASSIGN(3, "指定");
    
    private int code;
    private String cnName;
    private CouponGrantRule(int code, String cnName) {
       this.code = code;
       this.cnName = cnName;
    }
    
    public static CouponGrantRule get(int code){
        for (CouponGrantRule grantRule : CouponGrantRule.values()) {
            if(grantRule.getCode() == code) return grantRule;
        }
        return null;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getCnName() {
        return cnName;
    }
    
    public boolean equals(CouponGrantRule equalRule){
        if(null == equalRule) return false;
        return equalRule.getCode() == this.getCode();
    }
    
    public boolean equals(Integer code){
        if(null == code) return false;
        return code == this.getCode();
    }
}
