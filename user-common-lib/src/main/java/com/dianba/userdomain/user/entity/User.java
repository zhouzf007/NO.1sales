package com.dianba.userdomain.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dianba.userdomain.constant.Const;


public class User implements Serializable{
	private  static final long serialVersionUID = -491772060313608478L;
	private Long id;
	private String username;
	private String nickname;
	private String password;
	private String gender;
	private String mobile;
	private String photourl;
	private BigDecimal money;
	private Integer score;
	private String userType;
	private String sns;
	private String ip;
	private Integer loginTime;
	private Integer createTime;
	private String payPassword;
	private String openid;
	private String unionid;
	private String unionidRemark;
	private String mobileRemark;
	private String openidRemark;
	private Integer isDelete;
	private Integer firstOrderTime;
	private String isHavePassword;//虚拟字段是否拥有密码（Y=有，N等于没）

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhotourl() {
		return photourl;
	}
	
    public String getPhotourl_compres() {
        String photourl_ = ""; 
        
        /* 1.图片为null 给默认图片 */
        if(this.photourl == null || this.photourl.equals("")){
            if(this.gender.equals("F")) photourl_ = Const.DEFAULT_IMG_F;
            else photourl_ = Const.DEFAULT_IMG_M;
        }else{
            photourl_ = this.photourl;
        }
        
        /* 2.根据图片域名,使用该域的逻辑压缩 */
        if(photourl_.indexOf("http://oss.0085.com/") >= 0){ 
            photourl_ = photourl_+"@64w_64h_2e|64w_64h_4e";
        }else if(photourl_.indexOf("http://wx.qlogo.cn/") >= 0){
            photourl_ = photourl_.substring(0,photourl_.length()-1)+"64";
        }
        
        return photourl_;
    }
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getSns() {
		return sns;
	}
	public void setSns(String sns) {
		this.sns = sns;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Integer loginTime) {
		this.loginTime = loginTime;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public String getPayPassword() {
		return payPassword;
	}
	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getUnionidRemark() {
		return unionidRemark;
	}
	public void setUnionidRemark(String unionidRemark) {
		this.unionidRemark = unionidRemark;
	}
	public String getMobileRemark() {
		return mobileRemark;
	}
	public void setMobileRemark(String mobileRemark) {
		this.mobileRemark = mobileRemark;
	}
	public String getOpenidRemark() {
		return openidRemark;
	}
	public void setOpenidRemark(String openidRemark) {
		this.openidRemark = openidRemark;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getFirstOrderTime() {
		return firstOrderTime;
	}
	public void setFirstOrderTime(Integer firstOrderTime) {
		this.firstOrderTime = firstOrderTime;
	}
	public String getIsHavePassword() {
		return isHavePassword;
	}
	public void setIsHavePassword(String isHavePassword) {
		this.isHavePassword = isHavePassword;
	}
	
}