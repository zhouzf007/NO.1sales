package com.dianba.userdomain.merchant.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.merchant.entity.MerchantInfo;
import com.dianba.userdomain.merchant.mapper.CommonMerchantInfoMapper;
import com.dianba.userdomain.merchant.service.MerchantInfoService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonMerchantInfoServiceImpl implements MerchantInfoService { 

    @Autowired
	private CommonMerchantInfoMapper merchantInfoMapper;
    
    
	
	public List<MerchantInfo> getMerchantInfoList(){
		return merchantInfoMapper.getMerchantInfoList();
	}
	
	public PageList<MerchantInfo> getMerchantInfoList(PageBounds pageBounds){
		return merchantInfoMapper.getMerchantInfoList(pageBounds);
	}
	
	public List<MerchantInfo> getMerchantInfoPageList(MerchantInfo merchantInfo){
		return merchantInfoMapper.getMerchantInfoPageList(merchantInfo);
	}
	
	public PageList<MerchantInfo> getMerchantInfoPageList(MerchantInfo merchantInfo, PageBounds pageBounds){
		return merchantInfoMapper.getMerchantInfoPageList(merchantInfo,pageBounds);
	}
	
	public MerchantInfo getMerchantInfoByPrimaryKey(Integer id){
		return merchantInfoMapper.getMerchantInfoByPrimaryKey(id);
	}
	
	public void createMerchantInfo(MerchantInfo merchantInfo){
		merchantInfoMapper.createMerchantInfo(merchantInfo);
	}
	
	public void createMerchantInfoBitch(List<MerchantInfo> merchantInfoList){
		for( MerchantInfo merchantInfo : merchantInfoList ) {
			merchantInfoMapper.createMerchantInfo(merchantInfo);
		}
	}
	
	public void updateMerchantInfo(MerchantInfo merchantInfo){
		merchantInfoMapper.updateMerchantInfo(merchantInfo);
	}
	
	public void updateMerchantInfoBitch(List<MerchantInfo> merchantInfoList){
	    for( MerchantInfo merchantInfo : merchantInfoList ) {
		    merchantInfoMapper.updateMerchantInfo(merchantInfo);
		}
	}
	
	public void updateMerchantInfoSelective(MerchantInfo merchantInfo){
	    merchantInfoMapper.updateMerchantInfoSelective(merchantInfo);
	}
	
	public void updateMerchantInfoSelectiveBitch(List<MerchantInfo> merchantInfoList){
	    for( MerchantInfo merchantInfo : merchantInfoList ) {
		    merchantInfoMapper.updateMerchantInfoSelective(merchantInfo);
		}
	}

	public void deleteMerchantInfo(Integer id){
		merchantInfoMapper.deleteMerchantInfo(id);
	}
	
	public void deleteMerchantInfoBitch(List<Integer> idList){
		for( Integer id : idList ) {
			merchantInfoMapper.deleteMerchantInfo(id);
		}
	}
	
	public MerchantInfo getMerchantInfoByMerchantId(Integer merchantId){
		return merchantInfoMapper.getMerchantInfoByMerchantId(merchantId);
	}
	
	public Double getCostLunchBox(Integer id) {
		return merchantInfoMapper.getCostLunchBox(id);
	}
	
	public List<MerchantInfo> MerchantInfoList(Integer id) {
		return merchantInfoMapper.MerchantInfoList(id);
	}
	
	@Override
	public Integer getMerchantSource(Integer id) {
		return merchantInfoMapper.getMerchantSource(id);
	}
	
	public Integer getDineInDiscount(Integer merchantId) {
		return merchantInfoMapper.getDineInDiscount(merchantId);
	}
	
	public Map<String,Object> getDineInDiscountMoney(Integer merchantId,
			BigDecimal money) {
				Integer DineInDiscount = getDineInDiscount(merchantId);
				BigDecimal discountMoney = money.subtract(money.multiply((new BigDecimal(DineInDiscount).multiply(new BigDecimal(0.01)))).setScale(2, BigDecimal.ROUND_HALF_UP));
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("DineInDiscount", DineInDiscount);
				map.put("discountMoney", discountMoney.doubleValue());
		return map;
	}

	@Override
	public Integer findRechargeMerchantId() {
	    return merchantInfoMapper.findRechargeMerchantId();
	}
}