package com.dianba.userdomain.discount.mapper;

import java.util.List;

import com.dianba.userdomain.discount.entity.TomMerchantMemberDiscount;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonTomMerchantMemberDiscountMapper {

	public List<TomMerchantMemberDiscount> getTomMerchantMemberDiscountList();

	public PageList<TomMerchantMemberDiscount> getTomMerchantMemberDiscountList( PageBounds pageBounds );
	
	public List<TomMerchantMemberDiscount> getTomMerchantMemberDiscountPageList( TomMerchantMemberDiscount tomMerchantMemberDiscount );
	
	public PageList<TomMerchantMemberDiscount> getTomMerchantMemberDiscountPageList(TomMerchantMemberDiscount tomMerchantMemberDiscount, PageBounds pageBounds );
	
	public TomMerchantMemberDiscount getTomMerchantMemberDiscountByPrimaryKey(Integer id);
	
	public void createTomMerchantMemberDiscount(TomMerchantMemberDiscount tomMerchantMemberDiscount);
	
	public void updateTomMerchantMemberDiscount(TomMerchantMemberDiscount tomMerchantMemberDiscount);
	
	public void updateTomMerchantMemberDiscountSelective(TomMerchantMemberDiscount tomMerchantMemberDiscount);
	
	public void deleteTomMerchantMemberDiscount(Integer id);
}