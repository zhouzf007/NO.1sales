package com.dianba.userdomain.constant;

/**
 * 获取商品方式
 * @author folo
 */
public enum SaleType {
    TAKEOUT(1, "takeOut", "外卖"),
    EATIN(2, "eatIn", "堂食"),
    MENTION(3, "mention", "自提");
    
    private int code;
    private String name;
    private String cnName;
    private SaleType(int code, String name, String cnName) {
       this.code = code;
       this.name = name;
       this.cnName = cnName;
    }
    
    public int getCode() {
        return code;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCnName() {
        return cnName;
    }
    
    public static SaleType get(int code){
        for (SaleType em : SaleType.values()) {
            if(em.getCode() == code) return em;
        }
        return null;
    }
    
    public static SaleType get(String name){
        for (SaleType em : SaleType.values()) {
            if(em.getName().equals(name)) return em;
        }
        return null;
    }
    
    public boolean equals(SaleType em){
        if(null == em) return false;
        return em.getCode() == this.getCode();
    }
    
    public boolean equals(Integer code){
        if(null == code) return false;
        return code == this.getCode();
    }
    
    public boolean equals(String name){
        if(null == name) return false;
        return name.equals(this.getName());
    }
}
