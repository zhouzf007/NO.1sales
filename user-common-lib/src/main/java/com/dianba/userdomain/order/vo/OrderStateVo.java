package com.dianba.userdomain.order.vo;

import java.io.Serializable;

import com.dianba.userdomain.controller.open_api.util.ValidUtil;


public class OrderStateVo implements Serializable {
    private static final long serialVersionUID = -4264478369931063475L;

    private Long id;

    private Long orderId;

    private Integer dealTime;

    private String state;

    private String detail;

    private String realTime;

    private String deliveryTime;

    /** 扩展字段，从detail里面提前的手机号 */
    private String tel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getDealTime() {
        return dealTime;
    }

    public void setDealTime(Integer dealTime) {
        this.dealTime = dealTime;
    }

    public String getState() {
        return state;
    }

    public String getTel() {
        if (!ValidUtil.anyEmpty(detail)
                        && detail.indexOf("(") != -1) { 
            return detail.substring(detail.indexOf("(") + 1, detail.indexOf(")")); }
        return "";
    }

    public String getHtmlDetail() {
        if (!ValidUtil.anyEmpty(detail) && detail.indexOf("(") != -1) {
            String mobile = detail.substring(detail.indexOf("(") + 1, detail.indexOf(")"));
            String mobileHtml = "(<a href='tel:" + mobile + "'>" + mobile + "</a>)";
            return detail.replace("(" + mobile + ")", mobileHtml);
        }
        return detail;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getRealTime() {
        return realTime;
    }

    public void setRealTime(String realTime) {
        this.realTime = realTime;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

}
