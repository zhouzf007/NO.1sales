package com.dianba.userdomain.constant;

public enum CouponType {
    /**
     * 平台类型
     */
    PLATFORM(100, "平台"), /**
                          * 商家类型
                          */
    MERCHANT(200, "商家");

    private Integer code;

    private String name;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private CouponType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 根据code获取枚举类型
     * 
     * @param code
     * @return
     */
    public static CouponType getCategory(Integer code) {
        for (CouponType status : CouponType.values()) {
            if (status.getCode() == code) { return status; }
        }
        return null;
    }

    public boolean equals(Integer code) {
        return code.equals(this.getCode());
    }
    
    public boolean equals(CouponType type) {
        for (CouponType status : CouponType.values()) {
            if (status.getCode() == type.code) { return true; }
        }
        return false;
    }
}
