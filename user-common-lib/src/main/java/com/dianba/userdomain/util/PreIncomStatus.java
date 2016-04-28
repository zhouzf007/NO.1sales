package com.dianba.userdomain.util;

/**
 * 预收入
 * @author folo
 */
public enum PreIncomStatus {
    N(0, "N", "非预收入"),
    Y(1, "Y", "预收入");
    
    private int code;
    private String name;
    private String cnName;
    private PreIncomStatus(int code, String name, String cnName) {
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
    
    public static PreIncomStatus get(int code){
        for (PreIncomStatus em : PreIncomStatus.values()) {
            if(em.getCode() == code) return em;
        }
        return null;
    }
    
    public static PreIncomStatus get(String name){
        for (PreIncomStatus em : PreIncomStatus.values()) {
            if(em.getName().equals(name)) return em;
        }
        return null;
    }
    
    public boolean equals(PreIncomStatus em){
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
