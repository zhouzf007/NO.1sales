package com.dianba.userdomain.order.mapper;

import java.util.List;
import java.util.Map;

import com.dianba.userdomain.merchant.vo.MerchantCommentVo;
import com.dianba.userdomain.order.entity.OrderComment;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonOrderCommentMapper {

public List<OrderComment> getOrderCommentList();
	
	public PageList<OrderComment> getOrderCommentList(PageBounds pageBounds);
	
	public List<OrderComment> getOrderCommentPageList(OrderComment orderComment);
	
	public PageList<OrderComment> getOrderCommentPageList(OrderComment orderComment, PageBounds pageBounds);
	
	public OrderComment getOrderCommentByPrimaryKey(Long id);
	
	public void createOrderComment(OrderComment orderComment);
	
	public void deleteCommentByOrderId(Long orderId,Long targetId);
	
	public void createOrderCommentBitch(List<OrderComment> orderCommentList);
	
	public void updateOrderComment(OrderComment orderComment);
	
	public void updateOrderCommentBitch(List<OrderComment> orderCommentList);
	
	public void updateOrderCommentSelective(OrderComment orderComment);
	
	public void updateOrderCommentSelectiveBitch(List<OrderComment> orderCommentList);
	
	public void deleteOrderComment(Long id);
	
	public List<MerchantCommentVo>getOrderCommentListByMerchantId(Long id);
	
	public void deleteOrderCommentBitch(List<Long> idList);
	
	public String queryCommentScore(Long id);
	
	public List<OrderComment>getOrderCommentListByOrderId(Long id,PageBounds pageBounds);
	
	public Double getMerchantGrade(Long id);
	
	public Double getMerchantServeGrade(Long id);
	
	public List<MerchantCommentVo>getOrderCommentHaveContentListByMerchantId(Long id,PageBounds pageBounds);

	public Integer getMerchantCommentAmountAll(Long id);
	
	public Integer getMerchantCommentAmountHaveComment(Long id);
	
	public List<OrderComment> judgeHaveComment(Map<String,Object>map);
	
	public OrderComment judgeHaveDefaultComment(Map<String,Object>map);
	
	public void updateOrderCommentContent (Map<String,Object>map);
	
	public PageList<MerchantCommentVo> getOrderCommentListPageByMerchantId(Long id,PageBounds pageBounds);
	
	public Double getMerchantAvgGrade(Long id);
	
	public Map<String,Object> merchantScore(Long id);
	
	/**
	 * 
	 * 获取快递员的评分及评价内容<br>
	 * <br>
	 * 创建人：  <br>
	 * 创建时间：  2016年1月4日 下午3:18:19 <br>
	 *
	 * @param id
	 * @return
	 */
	public List<OrderComment> courierScore(Long id);

	public Integer getOrderCommentCountByMerchantId(Long merchantId);
	
	public MerchantCommentVo getOrderCommentFirstByMerchantId(Long merchantId);

	
	/**
	 * 
	 * 根据id获取评价对象<br>
	 * <br>
	 * 创建人： 陈健文 <br>
	 * 创建时间：  2015年12月28日 下午4:31:53 <br>
	 *
	 * @param id
	 * @return
	 */
	public Integer getcommentTarget(Long id);
	
	public PageList<MerchantCommentVo> getPrivateKitchenOrderCommentListByMerchantId (Long merchantId,PageBounds pageBounds);

}