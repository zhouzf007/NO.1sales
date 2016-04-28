package com.dianba.userdomain.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.order.entity.Recharge;
import com.dianba.userdomain.order.mapper.CommonRechargeMapper;
import com.dianba.userdomain.order.service.RechargeService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonRechargeServiceImpl implements RechargeService { 

    @Autowired
	private CommonRechargeMapper rechargeMapper;
	
	public List<Recharge> getRechargeList(){
		return rechargeMapper.getRechargeList();
	}
	
	public PageList<Recharge> getRechargeList(PageBounds pageBounds){
		return rechargeMapper.getRechargeList(pageBounds);
	}
	
	public List<Recharge> getRechargePageList(Recharge recharge){
		return rechargeMapper.getRechargePageList(recharge);
	}
	
	public PageList<Recharge> getRechargePageList(Recharge recharge, PageBounds pageBounds){
		return rechargeMapper.getRechargePageList(recharge,pageBounds);
	}
	
	public Recharge getRechargeByPrimaryKey(Long id){
		return rechargeMapper.getRechargeByPrimaryKey(id);
	}
	
	public void createRecharge(Recharge recharge){
		rechargeMapper.createRecharge(recharge);
	}
	
	public void createRechargeBitch(List<Recharge> rechargeList){
		for( Recharge recharge : rechargeList ) {
			rechargeMapper.createRecharge(recharge);
		}
	}
	
	public void updateRecharge(Recharge recharge){
		rechargeMapper.updateRecharge(recharge);
	}
	
	public void updateRechargeBitch(List<Recharge> rechargeList){
	    for( Recharge recharge : rechargeList ) {
		    rechargeMapper.updateRecharge(recharge);
		}
	}
	
	public void updateRechargeSelective(Recharge recharge){
	    rechargeMapper.updateRechargeSelective(recharge);
	}
	
	public void updateRechargeSelectiveBitch(List<Recharge> rechargeList){
	    for( Recharge recharge : rechargeList ) {
		    rechargeMapper.updateRechargeSelective(recharge);
		}
	}
	
	public void deleteRecharge(Long id){
		rechargeMapper.deleteRecharge(id);
	}
	
	public void deleteRechargeBitch(List<Long> idList){
		for( Long id : idList ) {
			rechargeMapper.deleteRecharge(id);
		}
	}

	@Override
	public Long createNewRecharge(Recharge recharge) {
		try{
			rechargeMapper.createNewRecharge(recharge);
			return recharge.getId();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}