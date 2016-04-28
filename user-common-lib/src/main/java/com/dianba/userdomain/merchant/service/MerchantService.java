package com.dianba.userdomain.merchant.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.dianba.userdomain.merchant.entity.Merchant;
import com.dianba.userdomain.merchant.vo.MerchantClassificationVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface MerchantService {
	public List<Merchant> getMerchantList();

	public PageList<Merchant> getMerchantList(PageBounds pageBounds);

	public List<Merchant> getMerchantPageList(Merchant merchant);

	public PageList<Merchant> getMerchantPageList(Merchant merchant, PageBounds pageBounds);

	public Merchant getMerchantByPrimaryKey(Long id);

	public void createMerchant(Merchant merchant);

	public void updateMerchant(Merchant merchant);

	public void updateMerchantSelective(Merchant merchant);

	public void deleteMerchant(Long id);

	public String getMerchantTitle(Long id);

	public int deliverable(long merchantId, BigDecimal latitude, BigDecimal longitude);
	
	public Map<String, Object> getUserMerchantMember(String merchantId, String userId);
	
	public Map<String, Object> getMerchantMemberInfo(String merchantId, long userId);
	
	/**
	 * 
	 * 我的收藏列表添加分页
	 * <br>
	 * 创建人： 
	 * 创建时间：  2016年1月12日 上午9:47:07 <br>
	 *
	 * @param map
	 * @param pageBounds
	 * @return
	 */
	public List<MerchantClassificationVo> getUserFavourite(Map<String, Object> map, PageBounds pageBounds);
	
	
	
}