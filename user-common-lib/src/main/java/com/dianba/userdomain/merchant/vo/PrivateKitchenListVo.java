package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;

public class PrivateKitchenListVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8809729389112805066L;
	
	private Long id;
	private String title;
	private String address;
	private String position;
	private String city;
	private String province;
	private String pic;
	private Double distance;
	private Integer num;
	private Integer isBusiness;//是否营业 1 营业 0 停业
	private int isPassPlatformAduit;//是否通过平台会员审核 0为待审核，1为通过，2为不通过'
	private int isOpenMerchantMember;// 是否开启商家会员  0=不开启  1=开启
	private Double wellDiscount;//首页商家会员显示最优折扣
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
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
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getIsBusiness() {
		return isBusiness;
	}
	public void setIsBusiness(Integer isBusiness) {
		this.isBusiness = isBusiness;
	}
	public int getIsOpenMerchantMember() {
		return isOpenMerchantMember;
	}
	public void setIsOpenMerchantMember(int isOpenMerchantMember) {
		this.isOpenMerchantMember = isOpenMerchantMember;
	}
	public Double getWellDiscount() {
		return wellDiscount;
	}
	public void setWellDiscount(Double wellDiscount) {
		this.wellDiscount = wellDiscount;
	}
	public int getIsPassPlatformAduit() {
		return isPassPlatformAduit;
	}
	public void setIsPassPlatformAduit(int isPassPlatformAduit) {
		this.isPassPlatformAduit = isPassPlatformAduit;
	}

	
}
