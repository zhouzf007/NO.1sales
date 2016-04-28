package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;

public class PrivateKitchenDetailVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1960144610855490360L;
	
	private Long merchantId;
	private String photoUrl;
	private String name;
	private String intro;
	private Double score;
	private String title;
	private String address;
	private String city;
	private String province;
	private Integer num;
	private String notice;
	private String gender;
	private String coverPic;

    private String couponMsg;//优惠券折扣信息
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCoverPic() {
		return coverPic;
	}
	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}
    public String getCouponMsg() {
        return couponMsg;
    }

    public void setCouponMsg(String couponMsg) {
        this.couponMsg = couponMsg;
    }
}
