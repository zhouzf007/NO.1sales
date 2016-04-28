package com.dianba.userdomain.discount.service;

import java.math.BigDecimal;
import java.util.List;

import com.dianba.userdomain.discount.entity.TomMerchantMemberDiscount;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface TomMerchantMemberDiscountService {

	public List<TomMerchantMemberDiscount> getTomMerchantMemberDiscountList();
	
	public PageList<TomMerchantMemberDiscount> getTomMerchantMemberDiscountList(PageBounds pageBounds);
	
	public List<TomMerchantMemberDiscount> getTomMerchantMemberDiscountPageList(TomMerchantMemberDiscount tomMerchantMemberDiscount);
	
	public PageList<TomMerchantMemberDiscount> getTomMerchantMemberDiscountPageList(TomMerchantMemberDiscount tomMerchantMemberDiscount, PageBounds pageBounds);
	
	public TomMerchantMemberDiscount getTomMerchantMemberDiscountByPrimaryKey(Integer id);
	
	public void createTomMerchantMemberDiscount(TomMerchantMemberDiscount tomMerchantMemberDiscount);
	
	public void createTomMerchantMemberDiscountBitch(List<TomMerchantMemberDiscount> tomMerchantMemberDiscountList);
	
	public void updateTomMerchantMemberDiscount(TomMerchantMemberDiscount tomMerchantMemberDiscount);
	
	public void updateTomMerchantMemberDiscountBitch(List<TomMerchantMemberDiscount> tomMerchantMemberDiscountList);
	
	public void updateTomMerchantMemberDiscountSelective(TomMerchantMemberDiscount tomMerchantMemberDiscount);
	
	public void updateTomMerchantMemberDiscountSelectiveBitch(List<TomMerchantMemberDiscount> tomMerchantMemberDiscountList);
	
	public void deleteTomMerchantMemberDiscount(Integer id);
	
	public void deleteTomMerchantMemberDiscountBitch(List<Integer> idList);
	
	public BigDecimal getMerchantSubtractMoney(Long merchantId, BigDecimal money);
	
	public TomMerchantMemberDiscount isMerchantSetDiscount(Long merchantId);

}