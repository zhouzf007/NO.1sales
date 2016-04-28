package com.dianba.userdomain.merchant.mapper;
import java.util.List;
import java.util.Map;

import com.dianba.userdomain.merchant.entity.Merchant;
import com.dianba.userdomain.merchant.vo.MerchantClassificationVo;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


@MyBatisRepository
public interface CommonMerchantMapper {

	public List<Merchant> getMerchantList();

	public PageList<Merchant> getMerchantList(PageBounds pageBounds);
	
	public List<Merchant> getMerchantPageList(Merchant merchant);

	public PageList<Merchant> getMerchantPageList(Merchant merchant,
			PageBounds pageBounds);
	
	public Merchant getMerchantByPrimaryKey(Long id);
	
	public void createMerchant(Merchant merchant);
	
	public void updateMerchant(Merchant merchant);
	
	public void updateMerchantSelective(Merchant merchant);
	
	public void deleteMerchant(Long id);
	
	public String getMerchantTitle(Long id);

	public List<MerchantClassificationVo> getUserFavourite(Map<String, Object> map);
	
	/**
	 * 
	 * 获取收藏列表添加分页
	 * <br>
	 * 创建人： 
	 * 创建时间：  2016年1月12日 上午9:48:52 <br>
	 *
	 * @param map
	 * @param pageBounds
	 * @return
	 */
	public List<MerchantClassificationVo> getUserFavourite(Map<String, Object> map, PageBounds pageBounds);
}