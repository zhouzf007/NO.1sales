
package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dianba.userdomain.util.ConverDataUtil;
import com.dianba.userdomain.util.ValidUtil;

public class MerchantClassificationVo implements Serializable {
	private static final long serialVersionUID = -9117290600325293303L;

	private Long merchantId;
	private Long favoritesId;
	private String title;
	private Double longitude;
	private Double latitude;
	private int isBusiness;// 是否营业 1 营业 0 停业
	private Double deliveryBegin; // 起送金额
	private Integer currentMonthSaleTotal;// 销售量统计
	private Double distance;// 用户与商铺之间的距离
	private Double score;// 平均评论分数
	private String logoUrl;// 商家头像
	private String groupName;// 分类
	private Integer orderTime;// 配送时间
	private Double costDelivery;// 配送费
	private int merchantSource;// 商家来源 = 0:默认商家/1:乡村基商家/2:私厨
	private Integer id; // 收藏id
	private String couponMsg;//商家优惠券折扣信息

    private Integer takeout;// 商家外卖折扣 换算百分比单位：(扣点/100)%

    private String merchantDiscount;//平台设置优惠券展示金额
    private int isPassPlatformAduit;// 是否通过平台会员审核 0为待审核，1为通过，2为不通过'
	private int isOpenMerchantMember;// 是否开启商家会员  0=不开启  1=开启
	private Double wellDiscount;//首页商家会员显示最优折扣
	
	public int getMerchantSource() {
		return merchantSource;
	}
	public Long getFavoritesId() {
		return favoritesId;
	}

	public void setFavoritesId(Long favoritesId) {
		this.favoritesId = favoritesId;
	}

	public void setMerchantSource(int merchantSource) {
		this.merchantSource = merchantSource;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public int getIsBusiness() {
		return isBusiness;
	}

	public void setIsBusiness(int isBusiness) {
		this.isBusiness = isBusiness;
	}

	public Double getDeliveryBegin() {
		return deliveryBegin;
	}

	public void setDeliveryBegin(Double deliveryBegin) {
		this.deliveryBegin = deliveryBegin;
	}

	public Integer getCurrentMonthSaleTotal() {
		return currentMonthSaleTotal;
	}

	public void setCurrentMonthSaleTotal(Integer currentMonthSaleTotal) {
		this.currentMonthSaleTotal = currentMonthSaleTotal;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Integer orderTime) {
		this.orderTime = orderTime;
	}

	public Double getCostDelivery() {
		return costDelivery;
	}

	public void setCostDelivery(Double costDelivery) {
		this.costDelivery = costDelivery;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public String getCouponMsg() {
        if (ValidUtil.anyEmpty(merchantDiscount, takeout)) return "";
        try {
            String[] merchantDiscounts = merchantDiscount.split(",");
            StringBuilder sb = new StringBuilder();
            for (String discountStr : merchantDiscounts) {
                Integer discount = ConverDataUtil.toInt(discountStr);
                BigDecimal btakeout = new BigDecimal(takeout).divide(new BigDecimal(10000));
                if (null == discount) continue;
                sb.append(",").append("满").append(discount).append("抵")
                                .append(new BigDecimal(discount).multiply(btakeout).stripTrailingZeros().toPlainString());
            }
            return sb.length() > 0 ? sb.toString().substring(1) : "";
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public void setCouponMsg(String couponMsg) {
        this.couponMsg = couponMsg;
    }
	
	public Integer getTakeout() {
        return takeout;
    }

    public void setTakeout(Integer takeout) {
        this.takeout = takeout;
    }

    public String getMerchantDiscount() {
        return merchantDiscount;
    }

    public void setMerchantDiscount(String merchantDiscount) {
        this.merchantDiscount = merchantDiscount;
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
