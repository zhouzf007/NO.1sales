package com.dianba.userdomain.user.service;

import java.util.List;
import java.util.Map;

import com.dianba.userdomain.user.entity.Favorites;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface FavoritesService {

	public List<Favorites> getFavoritesList();
	
	public PageList<Favorites> getFavoritesList(PageBounds pageBounds);
	
	public List<Favorites> getFavoritesPageList(Favorites favorites);
	
	public PageList<Favorites> getFavoritesPageList(Favorites favorites, PageBounds pageBounds);
	
	public Favorites getFavoritesByPrimaryKey(Integer id);
	
	public Integer createFavorites(Favorites favorites);
	
	public void createFavoritesBitch(List<Favorites> favoritesList);
	
	public void updateFavorites(Favorites favorites);
	
	public void updateFavoritesBitch(List<Favorites> favoritesList);
	
	public void updateFavoritesSelective(Favorites favorites);
	
	public void updateFavoritesSelectiveBitch(List<Favorites> favoritesList);
	
	public void deleteFavorites(Integer id);
	
	public void deleteFavoritesBitch(List<Integer> idList);
	
	public Favorites getUserFavorites(Map<String,Object>map);
	
	/**
	 * 
	 * 取消收藏
	 * <br>
	 * 创建人： 
	 * 创建时间：  2016年1月9日 上午10:19:59 <br>
	 *
	 * @param md
	 */
	public void doDeleteFavorites(Map<String, Object> md);
	
	public List<Map<String, Object>> getMyFollow(long userId,Map<String,Object> paraMap);
	

}