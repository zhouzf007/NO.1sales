package com.dianba.userdomain.discount.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dianba.userdomain.discount.entity.TomPlatformDiscount;
import com.dianba.userdomain.discount.mapper.CommonTomPlatformDiscountMapper;
import com.dianba.userdomain.discount.service.TomPlatformDiscountService;

@Service
@Transactional 
public class CommonTomPlatformDiscountServiceImpl implements TomPlatformDiscountService { 

    @Autowired
	private CommonTomPlatformDiscountMapper tomPlatformDiscountMapper;
	
	public List<TomPlatformDiscount> getTomPlatformDiscountList(){
		return tomPlatformDiscountMapper.getTomPlatformDiscountList();
	}
	
	public PageList<TomPlatformDiscount> getTomPlatformDiscountList(PageBounds pageBounds){
		return tomPlatformDiscountMapper.getTomPlatformDiscountList(pageBounds);
	}
	
	public List<TomPlatformDiscount> getTomPlatformDiscountPageList(TomPlatformDiscount tomPlatformDiscount){
		return tomPlatformDiscountMapper.getTomPlatformDiscountPageList(tomPlatformDiscount);
	}
	
	public PageList<TomPlatformDiscount> getTomPlatformDiscountPageList(TomPlatformDiscount tomPlatformDiscount, PageBounds pageBounds){
		return tomPlatformDiscountMapper.getTomPlatformDiscountPageList(tomPlatformDiscount,pageBounds);
	}
	
	public TomPlatformDiscount getTomPlatformDiscountByPrimaryKey(Integer id){
		return tomPlatformDiscountMapper.getTomPlatformDiscountByPrimaryKey(id);
	}
	
	public void createTomPlatformDiscount(TomPlatformDiscount tomPlatformDiscount){
		tomPlatformDiscountMapper.createTomPlatformDiscount(tomPlatformDiscount);
	}
	
	public void createTomPlatformDiscountBitch(List<TomPlatformDiscount> tomPlatformDiscountList){
		for( TomPlatformDiscount tomPlatformDiscount : tomPlatformDiscountList ) {
			tomPlatformDiscountMapper.createTomPlatformDiscount(tomPlatformDiscount);
		}
	}
	
	public void updateTomPlatformDiscount(TomPlatformDiscount tomPlatformDiscount){
		tomPlatformDiscountMapper.updateTomPlatformDiscount(tomPlatformDiscount);
	}
	
	public void updateTomPlatformDiscountBitch(List<TomPlatformDiscount> tomPlatformDiscountList){
	    for( TomPlatformDiscount tomPlatformDiscount : tomPlatformDiscountList ) {
		    tomPlatformDiscountMapper.updateTomPlatformDiscount(tomPlatformDiscount);
		}
	}
	
	public void updateTomPlatformDiscountSelective(TomPlatformDiscount tomPlatformDiscount){
	    tomPlatformDiscountMapper.updateTomPlatformDiscountSelective(tomPlatformDiscount);
	}
	
	public void updateTomPlatformDiscountSelectiveBitch(List<TomPlatformDiscount> tomPlatformDiscountList){
	    for( TomPlatformDiscount tomPlatformDiscount : tomPlatformDiscountList ) {
		    tomPlatformDiscountMapper.updateTomPlatformDiscountSelective(tomPlatformDiscount);
		}
	}
	
	public void deleteTomPlatformDiscount(Integer id){
		tomPlatformDiscountMapper.deleteTomPlatformDiscount(id);
	}
	
	public void deleteTomPlatformDiscountBitch(List<Integer> idList){
		for( Integer id : idList ) {
			tomPlatformDiscountMapper.deleteTomPlatformDiscount(id);
		}
	}

}