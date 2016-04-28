package com.dianba.userdomain.constant;

/**
 * 支付类型枚举类
 * @author folo
 */
public enum PayType {
    //银行卡
    unionpay(1001, "银联"), 
    
    //腾讯
    tenpay(2001, "财付通"), 
    weixinpay(2010, "微信支付"),
    wft_pay(2020, "威付通支付"),
    
    //阿里
    alipay(3001, "支付宝支付"),
    
    //1号平台
    balance(9001, "余额支付"),
    merchantpay(9010, "商家会员卡支付");

    private Integer code;
    private String cnName;

    private PayType(Integer code, String cnName) {
        this.code = code;
        this.cnName = cnName;
    }

    public Integer getCode() {
        return code;
    }
    
    public String getCnName() {
        return cnName;
    }
    
    public static PayType get(String name){
        for (PayType etype : PayType.values()) {
            if(etype.toString().equals(name)) return etype;
        }
        return null;
    }
    
    public boolean equals(PayType payType){
        if(null == payType) return false;
        for (PayType etype : PayType.values()) {
            if(etype.getCode().equals(payType.getCode())) return true;
        }
        return false;
    }
}
