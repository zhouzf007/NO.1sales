package com.dianba.userdomain.discount.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.discount.entity.TomMerchantMemberDiscount;
import com.dianba.userdomain.discount.mapper.CommonTomMerchantMemberDiscountMapper;
import com.dianba.userdomain.discount.service.TomMerchantMemberDiscountService;
import com.dianba.userdomain.util.ListUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonTomMerchantMemberDiscountServiceImpl implements TomMerchantMemberDiscountService { 

    @Autowired
	private CommonTomMerchantMemberDiscountMapper tomMerchantMemberDiscountMapper;
	
	public List<TomMerchantMemberDiscount> getTomMerchantMemberDiscountList(){
		return tomMerchantMemberDiscountMapper.getTomMerchantMemberDiscountList();
	}
	
	public PageList<TomMerchantMemberDiscount> getTomMerchantMemberDiscountList(PageBounds pageBounds){
		return tomMerchantMemberDiscountMapper.getTomMerchantMemberDiscountList(pageBounds);
	}
	
	public List<TomMerchantMemberDiscount> getTomMerchantMemberDiscountPageList(TomMerchantMemberDiscount tomMerchantMemberDiscount){
		return tomMerchantMemberDiscountMapper.getTomMerchantMemberDiscountPageList(tomMerchantMemberDiscount);
	}
	
	public PageList<TomMerchantMemberDiscount> getTomMerchantMemberDiscountPageList(TomMerchantMemberDiscount tomMerchantMemberDiscount, PageBounds pageBounds){
		return tomMerchantMemberDiscountMapper.getTomMerchantMemberDiscountPageList(tomMerchantMemberDiscount,pageBounds);
	}
	
	public TomMerchantMemberDiscount getTomMerchantMemberDiscountByPrimaryKey(Integer id){
		return tomMerchantMemberDiscountMapper.getTomMerchantMemberDiscountByPrimaryKey(id);
	}
	
	public void createTomMerchantMemberDiscount(TomMerchantMemberDiscount tomMerchantMemberDiscount){
		tomMerchantMemberDiscountMapper.createTomMerchantMemberDiscount(tomMerchantMemberDiscount);
	}
	
	public void createTomMerchantMemberDiscountBitch(List<TomMerchantMemberDiscount> tomMerchantMemberDiscountList){
		for( TomMerchantMemberDiscount tomMerchantMemberDiscount : tomMerchantMemberDiscountList ) {
			tomMerchantMemberDiscountMapper.createTomMerchantMemberDiscount(tomMerchantMemberDiscount);
		}
	}
	
	public void updateTomMerchantMemberDiscount(TomMerchantMemberDiscount tomMerchantMemberDiscount){
		tomMerchantMemberDiscountMapper.updateTomMerchantMemberDiscount(tomMerchantMemberDiscount);
	}
	
	public void updateTomMerchantMemberDiscountBitch(List<TomMerchantMemberDiscount> tomMerchantMemberDiscountList){
	    for( TomMerchantMemberDiscount tomMerchantMemberDiscount : tomMerchantMemberDiscountList ) {
		    tomMerchantMemberDiscountMapper.updateTomMerchantMemberDiscount(tomMerchantMemberDiscount);
		}
	}
	
	public void updateTomMerchantMemberDiscountSelective(TomMerchantMemberDiscount tomMerchantMemberDiscount){
	    tomMerchantMemberDiscountMapper.updateTomMerchantMemberDiscountSelective(tomMerchantMemberDiscount);
	}
	
	public void updateTomMerchantMemberDiscountSelectiveBitch(List<TomMerchantMemberDiscount> tomMerchantMemberDiscountList){
	    for( TomMerchantMemberDiscount tomMerchantMemberDiscount : tomMerchantMemberDiscountList ) {
		    tomMerchantMemberDiscountMapper.updateTomMerchantMemberDiscountSelective(tomMerchantMemberDiscount);
		}
	}
	
	public void deleteTomMerchantMemberDiscount(Integer id){
		tomMerchantMemberDiscountMapper.deleteTomMerchantMemberDiscount(id);
	}
	
	public void deleteTomMerchantMemberDiscountBitch(List<Integer> idList){
		for( Integer id : idList ) {
			tomMerchantMemberDiscountMapper.deleteTomMerchantMemberDiscount(id);
		}
	}
	/**
	 * 商家会员折扣减去金额
	 * 
	 */
	public BigDecimal getMerchantSubtractMoney(Long merchantId, BigDecimal money){
		TomMerchantMemberDiscount tomMerchantMemberDiscount = new TomMerchantMemberDiscount();
		tomMerchantMemberDiscount.setMerchantId(merchantId.intValue());
		List<TomMerchantMemberDiscount> tmmdList = tomMerchantMemberDiscountMapper.getTomMerchantMemberDiscountPageList(tomMerchantMemberDiscount);
		BigDecimal bdcm = new BigDecimal("100");
		if(ListUtil.isNotNullOrEmpty(tmmdList)){
			tomMerchantMemberDiscount = tmmdList.get(0);
			BigDecimal merchantDiscount = new BigDecimal(tomMerchantMemberDiscount.getMerchantDiscount()).divide(bdcm)
			.setScale(2, BigDecimal.ROUND_HALF_UP); //转换为元
			BigDecimal subtractMoney = money.subtract(money.multiply(merchantDiscount)).setScale(2, BigDecimal.ROUND_HALF_UP);
			return subtractMoney;
		}
		return new BigDecimal(0);
	}
	/**
	 * 商家是否设置了会员折扣  0=不是  1=是
	 * 
	 */
	public TomMerchantMemberDiscount isMerchantSetDiscount(Long merchantId){
		TomMerchantMemberDiscount tomMerchantMemberDiscount = new TomMerchantMemberDiscount();
		tomMerchantMemberDiscount.setMerchantId(merchantId.intValue());
		List<TomMerchantMemberDiscount> tmmdList = tomMerchantMemberDiscountMapper.getTomMerchantMemberDiscountPageList(tomMerchantMemberDiscount);
		if(ListUtil.isNotNullOrEmpty(tmmdList)){
			tomMerchantMemberDiscount = tmmdList.get(0);
			return tomMerchantMemberDiscount;
		}
		return null;
	}

}