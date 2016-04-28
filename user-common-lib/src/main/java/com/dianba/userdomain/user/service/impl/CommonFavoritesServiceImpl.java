package com.dianba.userdomain.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.constant.FavoritesType;
import com.dianba.userdomain.merchant.service.MerchantService;
import com.dianba.userdomain.merchant.vo.MerchantClassificationVo;
import com.dianba.userdomain.user.entity.Favorites;
import com.dianba.userdomain.user.mapper.CommonFavoritesMapper;
import com.dianba.userdomain.user.service.FavoritesService;
import com.dianba.userdomain.util.ListUtil;
import com.dianba.userdomain.util.StringUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonFavoritesServiceImpl implements FavoritesService { 

    @Autowired
	private CommonFavoritesMapper favoritesMapper;
    
    @Autowired
    private MerchantService merchantService;
	
	public List<Favorites> getFavoritesList(){
		return favoritesMapper.getFavoritesList();
	}
	
	public PageList<Favorites> getFavoritesList(PageBounds pageBounds){
		return favoritesMapper.getFavoritesList(pageBounds);
	}
	
	public List<Favorites> getFavoritesPageList(Favorites favorites){
		return favoritesMapper.getFavoritesPageList(favorites);
	}
	
	public PageList<Favorites> getFavoritesPageList(Favorites favorites, PageBounds pageBounds){
		return favoritesMapper.getFavoritesPageList(favorites,pageBounds);
	}
	
	public Favorites getFavoritesByPrimaryKey(Integer id){
		return favoritesMapper.getFavoritesByPrimaryKey(id);
	}
	
	public Integer createFavorites(Favorites favorites){
		favoritesMapper.createFavorites(favorites);
		return favorites.getId();
	}
	
	public void createFavoritesBitch(List<Favorites> favoritesList){
		for( Favorites favorites : favoritesList ) {
			favoritesMapper.createFavorites(favorites);
		}
	}
	
	public void updateFavorites(Favorites favorites){
		favoritesMapper.updateFavorites(favorites);
	}
	
	public void updateFavoritesBitch(List<Favorites> favoritesList){
	    for( Favorites favorites : favoritesList ) {
		    favoritesMapper.updateFavorites(favorites);
		}
	}
	
	public void updateFavoritesSelective(Favorites favorites){
	    favoritesMapper.updateFavoritesSelective(favorites);
	}
	
	public void updateFavoritesSelectiveBitch(List<Favorites> favoritesList){
	    for( Favorites favorites : favoritesList ) {
		    favoritesMapper.updateFavoritesSelective(favorites);
		}
	}
	
	public void deleteFavorites(Integer id){
		favoritesMapper.deleteFavorites(id);
	}
	
	public void deleteFavoritesBitch(List<Integer> idList){
		for( Integer id : idList ) {
			favoritesMapper.deleteFavorites(id);
		}
	}

	public Favorites getUserFavorites(Map<String, Object> map) {
		try{
			return favoritesMapper.getUserFavorites(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 
	 * <p>Title: doDeleteFavorites</p> 
	 * <p>Description: 取消收藏</p> 
	 *
	 * 创建人：
	 * 创建时间： 2016年1月9日 上午10:20:35
	 * 
	 * @param md 
	 * @see com.dianba.web.service.FavoritesService#doDeleteFavorites(java.util.Map)
	 */
	@Override
	public void doDeleteFavorites(Map<String, Object> md) {
		favoritesMapper.doDeleteFavorites(md);
	}

	
	@Override
	public List<Map<String, Object>> getMyFollow(long userId, Map<String, Object> paraMap) {
		PageBounds pageBounds=(PageBounds)paraMap.get("pageBounds");
		List<MerchantClassificationVo> list = merchantService.getUserFavourite(paraMap, pageBounds);
		List<Map<String, Object>> listMap = new ArrayList<>();
		if (ListUtil.isNotNullOrEmpty(list)) {// 判断数据是否为空
			for (MerchantClassificationVo mcf : list) {
				Favorites fats = new Favorites();
				fats.setUserid((int)userId);
				fats.setItemId(StringUtil.parseLongInt(mcf.getMerchantId()));
				fats.setType(String.valueOf(FavoritesType.MERCHANT.getId()));
				List<Favorites> favorites = getFavoritesPageList(fats);// 根据2个id获取出是否已经收藏过
				mcf.setId(favorites.get(0).getId());
				Map<String, Object> merchantMap = new HashMap<>();
				merchantMap.put("costDelivery", mcf.getCostDelivery());
				merchantMap.put("currentMonthSaleTotal", mcf.getCurrentMonthSaleTotal());
				merchantMap.put("deliveryBegin", mcf.getDeliveryBegin());
				merchantMap.put("distance", mcf.getDistance());
				merchantMap.put("groupName", mcf.getGroupName());
				merchantMap.put("isBusiness", mcf.getIsBusiness());
				merchantMap.put("logoUrl", mcf.getLogoUrl());
				merchantMap.put("merchantId", mcf.getMerchantId());
				merchantMap.put("merchantSource", mcf.getMerchantSource());
				merchantMap.put("orderTime", mcf.getOrderTime());
				merchantMap.put("score", mcf.getScore() >= 5 ? 5 : mcf.getScore());
				merchantMap.put("title", mcf.getTitle());
				merchantMap.put("id", mcf.getId());
				merchantMap.put("preferentialField1", "");// 首单立减
				merchantMap.put("preferentialField12", "");// 满20元立减5元
				listMap.add(merchantMap);
			}
		}
		return listMap;
	}

}