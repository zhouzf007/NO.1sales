package com.dianba.userdomain.user.mapper;

import java.util.List;
import java.util.Map;

import com.dianba.userdomain.user.entity.Favorites;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonFavoritesMapper {

	public List<Favorites> getFavoritesList();

	public PageList<Favorites> getFavoritesList( PageBounds pageBounds );
	
	public List<Favorites> getFavoritesPageList( Favorites favorites );
	
	public PageList<Favorites> getFavoritesPageList(Favorites favorites, PageBounds pageBounds );
	
	public Favorites getFavoritesByPrimaryKey(Integer id);
	
	public Integer createFavorites(Favorites favorites);
	
	public void updateFavorites(Favorites favorites);
	
	public void updateFavoritesSelective(Favorites favorites);
	
	public void deleteFavorites(Integer id);
	
	public Favorites getUserFavorites(Map<String,Object>map);
	
	/**
	 * 
	 * 取消收藏
	 * <br>
	 * 创建人： 
	 * 创建时间：  2016年1月8日 下午7:21:13 <br>
	 *
	 * @param map
	 * @return
	 */
	public void doDeleteFavorites(Map<String, Object> md);
}