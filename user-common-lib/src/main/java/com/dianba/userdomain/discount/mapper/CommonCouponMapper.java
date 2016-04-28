package com.dianba.userdomain.discount.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dianba.userdomain.discount.entity.Coupon;
import com.dianba.userdomain.discount.entity.CouponDiscount;
import com.dianba.userdomain.discount.entity.CouponFission;
import com.dianba.userdomain.discount.entity.CouponGrant;
import com.dianba.userdomain.discount.entity.CouponUser;
import com.dianba.userdomain.discount.entity.CouponUserStatics;
import com.dianba.userdomain.merchant.entity.Category;
import com.dianba.userdomain.merchant.entity.Merchant;
import com.dianba.userdomain.sysdictionary.entity.SysText;
import com.dianba.web.repository.MyBatisRepository;



@MyBatisRepository
public interface CommonCouponMapper {

    // ########################## 商家相关 ##########################
    /**
     * 查找支持发放优惠券商家与优惠券相关简略信息
     * @param merchantId
     * @return
     */
    public Merchant findSupportCouponMerchant(@Param("merchantId") int merchantId);

    /**
     * 查找当前用户的优惠券id
     * @param tbNum 用户id%10的值
     * @param userId 用户id
     * @param status 优惠券状态 -1=未使用 1=已使用
     * @param usedTime 使用时间
     * @param sourceType 来源
     * @param sourceGroup 分类
     * @param amount 金额
     * @param startRow 开始行数
     * @param pageSize 每页条数
     * @return
     */
    public List<CouponUser> findUserCoupons(@Param("tbNum") int tbNum, @Param("userId") long userId, @Param("status") int status,
                    @Param("usedTime") Date usedTime, @Param("sourceType") Integer sourceType, @Param("sourceId") Integer sourceId,
                    @Param("sourceGroup") Integer sourceGroup, @Param("amount") Integer amount, @Param("actualMoney") Integer actualMoney,
                    @Param("startRow") int startRow, @Param("pageSize") int pageSize);
    
    /**
     * 查找优惠券详细
     * @param couponIds 优惠券id，多个以逗号隔开
     * @param useCondition 使用条件 单位:分
     * @param orderByField 排序字段，排序：desc
     * @return
     */
    public List<Coupon> findCoupons(@Param("couponIds") String couponIds, @Param("useCondition") Integer useCondition,
                    @Param("orderByField") String orderByField);
    
    
    /**
     * 查询商家优惠券折扣点
     * @param merchantId
     * @return
     */
    public CouponDiscount findCouponDiscount(@Param("merchantId") int merchantId);

    /**
     * 找到分类的名称
     * @param categoryIds
     * @return
     */
    public List<Category> findCategoryNames(@Param("categoryIds") String categoryIds);
    
    /**
     * 找到商家名称
     * @param merchantIds
     * @return
     */
    public List<Merchant> findMerchantNames(@Param("merchantIds") String merchantIds);
    
    public List<CouponUser> findUserCouponsBySns(@Param("tbNum") int tbNum, @Param("couponSns") String couponSns);

    /**
     * 查找用户的优惠券
     * @param userId
     * @param couponId
     * @param startRow
     * @param pageSize
     * @return
     */
    public CouponUser findCouponUser(@Param("tbNum") int tbNum, @Param("sn") String sn, @Param("userId") long userId);

    /**
     * 用户使用优惠券
     * @param usedTime 使用时间
     * @param usedAmount 使用金额
     * @param userId 用户id
     * @param couponId 优惠券id
     * @return
     */
    public int useCoupon(@Param("tbNum") int tbNum, @Param("usedTime") Date usedTime, @Param("usedAmount") int usedAmount,
                    @Param("userId") long userId, @Param("couponSn") String couponSn);

    /**
     * 查找用户优惠券统计
     * @param couponId
     * @param usedType
     * @param usedId
     * @param usedGroup
     * @return
     */
    public CouponUserStatics findCouponUserStatics(CouponUserStatics couponUserStatics);
    
    /**
     * 添加用户优惠券统计
     * @param couponUserStatics
     * @return
     */
    public int insertCouponUserStatics(CouponUserStatics couponUserStatics);
    
    /**
     * 更改优惠券统计
     * @param couponUserStatics
     * @return
     */
    public int updateCouponUserStatics(CouponUserStatics couponUserStatics);
    
    /**
     * 查询正在发放的商家券
     * @param grantTime
     * @param usedId 发放商家
     * @param fromType 发放:100=平台 200=商家
     * @param putCondition 限制领取条件是否足够
     * @param surplusCount 需要发放数量是否足够
     * @return
     */
    public CouponGrant findMerchantCouponsBeingIssued(@Param("grantTime") Date grantTime, @Param("usedId") long usedId,
                    @Param("fromType") int fromType, @Param("putCondition") int putCondition, @Param("surplusCount") Integer surplusCount);

    public CouponFission findCouponFissionByOrderId(Long id);
    
    /**
     * 查询正在发放的，支持某个分类,某个区域的 发券信息
     * @param grantTime 发放时间
     * @param gromGroup 发放分类,多个用逗号隔开
     * @param fromArea 发放区域,多个用逗号隔开
     * @param fromType 发放:100=平台 200=商家
     * @return
     */
    public List<CouponGrant> findCouponsBeingIssued(@Param("grantTime") Date grantTime, @Param("gromGroup") long fromGroup,
                    @Param("fromArea") long fromArea, @Param("fromType") int fromType);
    
    /**
     * 根据code获取对应的文本详细
     * @param code
     * @return
     */
    public List<SysText> findSysTexts(@Param("codeType") String codeType);

}
