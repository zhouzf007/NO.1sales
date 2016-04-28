package com.dianba.userdomain.statistics.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.discount.entity.TomPlatformDiscount;
import com.dianba.userdomain.discount.service.TomPlatformDiscountService;
import com.dianba.userdomain.statistics.entity.TumUserStatistics;
import com.dianba.userdomain.statistics.service.TsmGradeService;
import com.dianba.userdomain.statistics.service.TumUserStatisticsService;
import com.dianba.userdomain.user.entity.TsmGrade;
import com.dianba.userdomain.user.mapper.CommonTsmGradeMapper;
import com.dianba.userdomain.util.ListUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonTsmGradeServiceImpl implements TsmGradeService { 

    @Autowired
	private CommonTsmGradeMapper tsmGradeMapper;
    
    @Autowired
    private TumUserStatisticsService tumUserStatisticsService;
    
    @Autowired
    private TomPlatformDiscountService tomPlatformDiscountService;
	
	public List<TsmGrade> getTsmGradeList(){
		return tsmGradeMapper.getTsmGradeList();
	}
	
	public PageList<TsmGrade> getTsmGradeList(PageBounds pageBounds){
		return tsmGradeMapper.getTsmGradeList(pageBounds);
	}
	
	public List<TsmGrade> getTsmGradePageList(TsmGrade tsmGrade){
		return tsmGradeMapper.getTsmGradePageList(tsmGrade);
	}
	
	public PageList<TsmGrade> getTsmGradePageList(TsmGrade tsmGrade, PageBounds pageBounds){
		return tsmGradeMapper.getTsmGradePageList(tsmGrade,pageBounds);
	}
	
	public TsmGrade getTsmGradeByPrimaryKey(Long id){
		return tsmGradeMapper.getTsmGradeByPrimaryKey(id);
	}
	
	public TsmGrade getTsmGradeByGrade(Long grade){
		return tsmGradeMapper.getTsmGradeByGrade(grade);
	}
	
	public void createTsmGrade(TsmGrade tsmGrade){
		tsmGradeMapper.createTsmGrade(tsmGrade);
	}
	
	public void createTsmGradeBitch(List<TsmGrade> tsmGradeList){
		for( TsmGrade tsmGrade : tsmGradeList ) {
			tsmGradeMapper.createTsmGrade(tsmGrade);
		}
	}
	
	public void updateTsmGrade(TsmGrade tsmGrade){
		tsmGradeMapper.updateTsmGrade(tsmGrade);
	}
	
	public void updateTsmGradeBitch(List<TsmGrade> tsmGradeList){
	    for( TsmGrade tsmGrade : tsmGradeList ) {
		    tsmGradeMapper.updateTsmGrade(tsmGrade);
		}
	}
	
	public void updateTsmGradeSelective(TsmGrade tsmGrade){
	    tsmGradeMapper.updateTsmGradeSelective(tsmGrade);
	}
	
	public void updateTsmGradeSelectiveBitch(List<TsmGrade> tsmGradeList){
	    for( TsmGrade tsmGrade : tsmGradeList ) {
		    tsmGradeMapper.updateTsmGradeSelective(tsmGrade);
		}
	}
	
	public void deleteTsmGrade(Long id){
		tsmGradeMapper.deleteTsmGrade(id);
	}
	
	public void deleteTsmGradeBitch(List<Long> idList){
		for( Long id : idList ) {
			tsmGradeMapper.deleteTsmGrade(id);
		}
	}

	@Override
	public TsmGrade getUserGrade(Long userId) {
		TumUserStatistics tum = tumUserStatisticsService.getTumUserStatisticsByUserId(userId);
		if(tum == null){
			TumUserStatistics tum2 = new TumUserStatistics();
			tum2.setUserId(userId);
			tum2.setTotalMoney(0);
			tum2.setTotalOrder(0);
			tum2.setTotalRecharge(0);
			tumUserStatisticsService.createTumUserStatistics(tum2);
			tum = tumUserStatisticsService.getTumUserStatisticsByUserId(userId);
		}
		List<TsmGrade> tsmGrades = this.tsmGradeMapper.getTsmGradeList();
		Collections.sort(tsmGrades, new Comparator<TsmGrade>() {

			@Override
			public int compare(TsmGrade t1, TsmGrade t2) {

				return t2.getTotalRecharge() - t1.getTotalRecharge();
			}

		});
		if (tum != null && tum.getTotalRecharge() >= 0) {
			BigDecimal bdcm = new BigDecimal("100");
			BigDecimal tumTotalRecharge = new BigDecimal(tum.getTotalRecharge()).divide(bdcm)
					.setScale(2, BigDecimal.ROUND_HALF_UP); //转换为元
			for (TsmGrade usergrade : tsmGrades) {
				BigDecimal tsmTotalRecharge = new BigDecimal(usergrade.getTotalRecharge());
				if (tsmTotalRecharge.compareTo(tumTotalRecharge)!=1) {
					return usergrade;
				}
			}
		}
		return new TsmGrade();
	}

	@Override
	public BigDecimal getmemberSubtractMoney(Long userId, BigDecimal money) {
		TumUserStatistics tum = tumUserStatisticsService.getTumUserStatisticsByUserId(userId);
		if(tum == null){
			TumUserStatistics tum2 = new TumUserStatistics();
			tum2.setUserId(userId);
			tum2.setTotalMoney(0);
			tum2.setTotalOrder(0);
			tum2.setTotalRecharge(0);
			tumUserStatisticsService.createTumUserStatistics(tum2);
			tum = tumUserStatisticsService.getTumUserStatisticsByUserId(userId);
		}
		List<TsmGrade> tsmGrades = this.tsmGradeMapper.getTsmGradeList();
		Collections.sort(tsmGrades, new Comparator<TsmGrade>() {

			@Override
			public int compare(TsmGrade t1, TsmGrade t2) {

				return t2.getTotalRecharge() - t1.getTotalRecharge();
			}

		});
		if (tum != null && tum.getTotalRecharge() > 0) {
			
			BigDecimal bdcm = new BigDecimal("100");
			BigDecimal tumTotalRecharge = new BigDecimal(tum.getTotalRecharge()).divide(bdcm)
					.setScale(2, BigDecimal.ROUND_HALF_UP); //转换为元
			for (TsmGrade usergrade : tsmGrades) { 
				BigDecimal tsmTotalRecharge = new BigDecimal(usergrade.getTotalRecharge());
				if (tsmTotalRecharge.compareTo(tumTotalRecharge)!=1) {
					Double maxDiscount = usergrade.getMaxDiscount().doubleValue();
					BigDecimal bd = new BigDecimal(usergrade.getDiscount()).divide(bdcm) //折扣转换为小数
							.setScale(2, BigDecimal.ROUND_HALF_UP);
					BigDecimal bd2 = new BigDecimal(maxDiscount).setScale(2, BigDecimal.ROUND_HALF_UP);
					BigDecimal subtractMoney = money.subtract(money.multiply(bd))
							.setScale(2, BigDecimal.ROUND_HALF_UP);
					if(subtractMoney.compareTo(bd2)==1){
						subtractMoney = bd2;
					}
					return subtractMoney;
				}
			}
		}else{
			return new BigDecimal(0);
		}
		return new BigDecimal(0);
	}

	@Override
	public TsmGrade getUserGradeBytotalRecharge(BigDecimal money) {
		List<TsmGrade> tsmGrades = this.tsmGradeMapper.getTsmGradeList();
		Collections.sort(tsmGrades, new Comparator<TsmGrade>() {

			@Override
			public int compare(TsmGrade t1, TsmGrade t2) {

				return t2.getTotalRecharge() - t1.getTotalRecharge();
			}

		});
		
		if (money != null && money.compareTo(new BigDecimal(0)) != -1) {
			for (TsmGrade usergrade : tsmGrades) {
				BigDecimal tsmTotalRecharge = new BigDecimal(usergrade.getTotalRecharge());
				if (tsmTotalRecharge.compareTo(money)!=1) {
					return usergrade;
				}
			}
		}
		return null;
	}
	/**
	 * 平台会员减去金额 saleType '0为外卖，1为堂食，2为自提',
	 * @param userId
	 * @param merchantId
	 * @param money
	 * @param saleType
	 * @return
	 */
	@Override
	public BigDecimal getPlatformSubtractMoney(Long userId, Long merchantId, BigDecimal money, String saleType) {
		TumUserStatistics tum = tumUserStatisticsService.getTumUserStatisticsByUserId(userId);
		if(tum == null){
			TumUserStatistics tum2 = new TumUserStatistics();
			tum2.setUserId(userId);
			tum2.setTotalMoney(0);
			tum2.setTotalOrder(0);
			tum2.setTotalRecharge(0);
			tumUserStatisticsService.createTumUserStatistics(tum2);
			tum = tumUserStatisticsService.getTumUserStatisticsByUserId(userId);
		}
		List<TsmGrade> tsmGrades = this.tsmGradeMapper.getTsmGradeList();
		Collections.sort(tsmGrades, new Comparator<TsmGrade>() {

			@Override
			public int compare(TsmGrade t1, TsmGrade t2) {

				return t2.getTotalRecharge() - t1.getTotalRecharge();
			}

		});
		if (tum != null && tum.getTotalRecharge() >= 0) {
			BigDecimal bdcm = new BigDecimal("100");
			BigDecimal tumTotalRecharge = new BigDecimal(tum.getTotalRecharge()).divide(bdcm)
					.setScale(2, BigDecimal.ROUND_HALF_UP); //转换为元
			for (TsmGrade usergrade : tsmGrades) {
				BigDecimal tsmTotalRecharge = new BigDecimal(usergrade.getTotalRecharge());
				if (tsmTotalRecharge.compareTo(tumTotalRecharge)!=1) {
					TomPlatformDiscount tomPlatformDiscount = new TomPlatformDiscount();
					tomPlatformDiscount.setMerchantId(merchantId.intValue());
					List<TomPlatformDiscount> tpfdList = tomPlatformDiscountService.getTomPlatformDiscountPageList(tomPlatformDiscount);
					if(ListUtil.isNotNullOrEmpty(tpfdList)){
						for(TomPlatformDiscount tpd:tpfdList){
							TsmGrade tsmg = tsmGradeMapper.getTsmGradeByPrimaryKey(tpd.getTsmGradeId().longValue());
							if(saleType.equals(tpd.getDiscountType())&&usergrade.getGrade().equals(tsmg.getGrade())){
								BigDecimal discount = tpd.getDiscountValue().divide(bdcm)
										.setScale(2, BigDecimal.ROUND_HALF_UP); //转换为元
								//BigDecimal discountMoney = money.divide(discount).setScale(2, BigDecimal.ROUND_HALF_UP);
								BigDecimal subtractMoney = money.subtract(money.multiply(discount)).setScale(2, BigDecimal.ROUND_HALF_UP);
								return subtractMoney;
							}
						}
						
					}
						
				}
			}
		}else{
			return new BigDecimal(0);
		}
		return new BigDecimal(0);
	}
	
	/**
	 * 平台会员折扣 
	 * @param userId
	 * @param merchantId
	 * @param money
	 * @param saleType
	 * @return
	 */
	@Override
	public BigDecimal getPlatformDiscount(Long userId, Long merchantId, String saleType) {
		TumUserStatistics tum = tumUserStatisticsService.getTumUserStatisticsByUserId(userId);
		if(tum == null){
			TumUserStatistics tum2 = new TumUserStatistics();
			tum2.setUserId(userId);
			tum2.setTotalMoney(0);
			tum2.setTotalOrder(0);
			tum2.setTotalRecharge(0);
			tumUserStatisticsService.createTumUserStatistics(tum2);
			tum = tumUserStatisticsService.getTumUserStatisticsByUserId(userId);
		}
		List<TsmGrade> tsmGrades = this.tsmGradeMapper.getTsmGradeList();
		Collections.sort(tsmGrades, new Comparator<TsmGrade>() {

			@Override
			public int compare(TsmGrade t1, TsmGrade t2) {

				return t2.getTotalRecharge() - t1.getTotalRecharge();
			}

		});
		if (tum != null && tum.getTotalRecharge() >= 0) {
			BigDecimal bdcm = new BigDecimal("100");
			BigDecimal tumTotalRecharge = new BigDecimal(tum.getTotalRecharge()).divide(bdcm)
					.setScale(2, BigDecimal.ROUND_HALF_UP); //转换为元
			for (TsmGrade usergrade : tsmGrades) {
				BigDecimal tsmTotalRecharge = new BigDecimal(usergrade.getTotalRecharge());
				if (tsmTotalRecharge.compareTo(tumTotalRecharge)!=1) {
					TomPlatformDiscount tomPlatformDiscount = new TomPlatformDiscount();
					tomPlatformDiscount.setMerchantId(merchantId.intValue());
					List<TomPlatformDiscount> tpfdList = tomPlatformDiscountService.getTomPlatformDiscountPageList(tomPlatformDiscount);
					if(ListUtil.isNotNullOrEmpty(tpfdList)){
						for(TomPlatformDiscount tpd:tpfdList){
							TsmGrade tsmg = tsmGradeMapper.getTsmGradeByPrimaryKey(tpd.getTsmGradeId().longValue());
							if(saleType.equals(tpd.getDiscountType())&&usergrade.getGrade().equals(tsmg.getGrade())){
								BigDecimal discount = tpd.getDiscountValue().divide(bdcm);
										//.setScale(2, BigDecimal.ROUND_HALF_UP); //转换为元
								
								
								return discount;
							}
						}
						
					}
				}
			}
		}else{
			return new BigDecimal(0);
		}
		return new BigDecimal(0);
	}
	@Override
	public BigDecimal getNextGradePlatformDiscount(Long grade, Long merchantId) {
		TsmGrade userNextGrade = tsmGradeMapper.getTsmGradeByGrade(grade);
		BigDecimal bdcm = new BigDecimal("10");
		if(userNextGrade != null){
			TomPlatformDiscount tomPlatformDiscount = new TomPlatformDiscount();
			tomPlatformDiscount.setMerchantId(merchantId.intValue());
			tomPlatformDiscount.setDiscountType("0");
			List<TomPlatformDiscount> tpfdList = tomPlatformDiscountService.getTomPlatformDiscountPageList(tomPlatformDiscount);
			if(ListUtil.isNotNullOrEmpty(tpfdList)){
				for(TomPlatformDiscount tpd:tpfdList){
					TsmGrade tsmg = tsmGradeMapper.getTsmGradeByPrimaryKey(tpd.getTsmGradeId().longValue());
					if(userNextGrade.getGrade().equals(tsmg.getGrade())){
						BigDecimal discount = tpd.getDiscountValue().divide(bdcm).setScale(2, BigDecimal.ROUND_HALF_UP);;
						return discount;
					}
				}
				
			}
		}
			
		return new BigDecimal(0);
	}
}