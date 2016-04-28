package com.dianba.userdomain.sysdictionary.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.discount.entity.TomMerchantMemberInfo;
import com.dianba.userdomain.discount.mapper.CommonTomMerchantMemberInfoMapper;
import com.dianba.userdomain.order.entity.Flow;
import com.dianba.userdomain.order.mapper.CommonFlowMapper;
import com.dianba.userdomain.sysdictionary.service.FlowService;
import com.dianba.userdomain.user.entity.User;
import com.dianba.userdomain.user.mapper.CommonUserMapper;
import com.dianba.userdomain.util.DateUtils;
import com.dianba.userdomain.util.ListUtil;
import com.dianba.userdomain.util.StringUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonFlowServiceImpl implements FlowService { 

    @Autowired
	private CommonFlowMapper flowMapper;
    @Autowired
    private CommonUserMapper userMapper;
    @Autowired
    private CommonTomMerchantMemberInfoMapper tomMerchantMemberInfoMapper;
	
	public List<Flow> getFlowList(){
		return flowMapper.getFlowList();
	}
	
	public PageList<Flow> getFlowList(PageBounds pageBounds){
		return flowMapper.getFlowList(pageBounds);
	}
	
	public List<Flow> getFlowPageList(Flow flow){
		return flowMapper.getFlowPageList(flow);
	}
	
	public PageList<Flow> getFlowPageList(Flow flow, PageBounds pageBounds){
		return flowMapper.getFlowPageList(flow,pageBounds);
	}
	
	public Flow getFlowByPrimaryKey(Long id){
		return flowMapper.getFlowByPrimaryKey(id);
	}
	
	public void createFlow(Flow flow){
		flowMapper.createFlow(flow);
	}
	
	public void createFlowBitch(List<Flow> flowList){
		for( Flow flow : flowList ) {
			flowMapper.createFlow(flow);
		}
	}
	
	public void updateFlow(Flow flow){
		flowMapper.updateFlow(flow);
	}
	
	public void updateFlowBitch(List<Flow> flowList){
	    for( Flow flow : flowList ) {
		    flowMapper.updateFlow(flow);
		}
	}
	
	public void updateFlowSelective(Flow flow){
	    flowMapper.updateFlowSelective(flow);
	}
	
	public void updateFlowSelectiveBitch(List<Flow> flowList){
	    for( Flow flow : flowList ) {
		    flowMapper.updateFlowSelective(flow);
		}
	}
	
	public void deleteFlow(Long id){
		flowMapper.deleteFlow(id);
	}
	
	public void deleteFlowBitch(List<Long> idList){
		for( Long id : idList ) {
			flowMapper.deleteFlow(id);
		}
	}

	public void rechargeFlowCreate(Long userid, BigDecimal money, Long detailId) {
		User user = userMapper.getUserByPrimaryKey(userid);
		BigDecimal preMoney=user.getMoney();
		BigDecimal postMoney=preMoney.add(money).setScale(2, BigDecimal.ROUND_HALF_UP);
		user.setMoney(postMoney);
		userMapper.updateUserSelective(user);
		
		Flow flow=new Flow();
		flow.setDetailId(detailId);
		flow.setAction("recharge");
		flow.setUserId(user.getId());
		flow.setType("income");
		flow.setDetail("[平台会员充值]：￥" + money);
		flow.setPreMoney(preMoney);
		flow.setMoney(money);
		flow.setPostMoney(postMoney);
		flow.setCreateTime(DateUtils.getSeconds());
		flowMapper.createFlow(flow);
		
	}
	/**
	 * 商家会员充值
	 * @param userid
	 * @param money
	 * @param detailId
	 */
	public void merchantRechargeFlowCreate(Long userid ,Long merchantId ,BigDecimal money, Long detailId) {
		//更新user表
		User user = userMapper.getUserByPrimaryKey(userid);
		BigDecimal preMoney=user.getMoney();
		BigDecimal postMoney=preMoney.subtract(money).setScale(2, BigDecimal.ROUND_HALF_UP);
		user.setMoney(postMoney);
		userMapper.updateUserSelective(user);
		//平台会员支付记录流水
		Flow flow=new Flow();
		flow.setMerchantId(merchantId);
		flow.setDetailId(detailId);
		flow.setAction("buy");
		flow.setUserId(user.getId());
		flow.setType("pay");
		flow.setDetail("[平台会员支付]：￥" + money);
		flow.setPreMoney(preMoney);
		flow.setMoney(money);
		flow.setPostMoney(postMoney);
		flow.setCreateTime(DateUtils.getSeconds());
		flowMapper.createFlow(flow);
		
		//更新用户商家会员账号(tom_merchant_member_info)
		TomMerchantMemberInfo tomMerchantMemberInfo = new TomMerchantMemberInfo();
		tomMerchantMemberInfo.setUserId(StringUtil.parseInt(userid.toString()));
		tomMerchantMemberInfo.setMerchantId(StringUtil.parseInt(merchantId.toString()));
		List<TomMerchantMemberInfo> tmmiList = tomMerchantMemberInfoMapper.getTomMerchantMemberInfoPageList(tomMerchantMemberInfo);
		BigDecimal merchantPreMoney = new BigDecimal(0);
		BigDecimal merchantPostMoney = new BigDecimal(0);
		if(ListUtil.isNotNullOrEmpty(tmmiList)){ //如果已经是会员
			tomMerchantMemberInfo = tmmiList.get(0);
			merchantPreMoney = new BigDecimal(tomMerchantMemberInfo.getMoney()).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
			merchantPostMoney = merchantPreMoney.add(money).setScale(2, BigDecimal.ROUND_HALF_UP);
			Double rechargeMoney = merchantPostMoney.doubleValue()*100;
			tomMerchantMemberInfo.setMoney(rechargeMoney.intValue());
			tomMerchantMemberInfoMapper.updateTomMerchantMemberInfoSelective(tomMerchantMemberInfo);
			
		}else{  //不是会员
			merchantPostMoney = merchantPreMoney.add(money).setScale(2, BigDecimal.ROUND_HALF_UP);
			Double rechargeMoney = merchantPostMoney.doubleValue()*100;
			tomMerchantMemberInfo.setMoney(rechargeMoney.intValue());
			tomMerchantMemberInfo.setCreateTime(DateUtils.getDate());
			tomMerchantMemberInfoMapper.createTomMerchantMemberInfo(tomMerchantMemberInfo);
		}
		
		
		//商家会员充值记录流水
		Flow flow2=new Flow();
		flow2.setMerchantId(merchantId);
		flow2.setDetailId(detailId);
		flow2.setAction("merchantRecharge");
		flow2.setUserId(user.getId());
		flow2.setType("income");
		flow2.setDetail("[商家会员充值]：￥" + money);
		flow2.setPreMoney(merchantPreMoney);
		flow2.setMoney(money);
		flow2.setPostMoney(merchantPostMoney);
		flow2.setCreateTime(DateUtils.getSeconds());
		flowMapper.createFlow(flow2);
		
	}
	
	@Override
	public void merchantOrderIncome(Long userId, BigDecimal money, Long detailId) {
		User user = userMapper.getUserByPrimaryKey(userId);
		Double preMoney = user.getMoney().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		Double postMoney = (preMoney*100+money.doubleValue()*100)/100;
		user.setMoney(new BigDecimal(postMoney).setScale(2, BigDecimal.ROUND_HALF_UP));
		userMapper.updateUserSelective(user);
		
		Flow flow = new Flow();
		flow.setDetailId(detailId);
		flow.setAction("orderIncome");
		flow.setUserId(userId);
		flow.setType("income");
		flow.setDetail("[商家订单收入]：￥" + money);
		flow.setPreMoney(new BigDecimal(preMoney).setScale(2, BigDecimal.ROUND_HALF_UP));
		flow.setMoney(money);
		flow.setPostMoney(new BigDecimal(postMoney).setScale(2, BigDecimal.ROUND_HALF_UP));
		flow.setCreateTime(DateUtils.getSeconds());
		createFlow(flow);
		
	}

	@Override
	public PageList<Flow> getFlowPageListByUserId(Long userId,
			PageBounds pageBounds) {
		return flowMapper.getFlowPageListByUserId(userId, pageBounds);
	}

}