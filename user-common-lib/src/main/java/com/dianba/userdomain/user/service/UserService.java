package com.dianba.userdomain.user.service;

import java.util.List;
import java.util.Map;

import com.dianba.userdomain.user.entity.User;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface UserService {

	public List<User> getUserList();
	
	public PageList<User> getUserList( PageBounds pageBounds );
	
	public List<User> getUserPageList( User user );
	
	public PageList<User> getUserPageList(User user, PageBounds pageBounds );
	
	public User getUserByPrimaryKey(Long id);
	
	public void createUser(User user);
	
	public void updateUser(User user);
	
	public int updateUserSelective(User user);
	
	public void deleteUser(Long id);
	
	public void updateUserScore(Map<String,Object>map);
	
	public void userPhotoUrlUpdate(long userId ,String newPhotoUrl);
	
	public void usernickNameUpdate(long userId ,String nickName);
	
	public void userPasswordUpdate(long userId ,String oldPassword,String newPassword);
	
	public void updateUserMobile(long userId ,String mobile,String validCode);
	
	public Map<String, Object> getUserInfo(long userId);
	
	public Map<String, Object> getUserBaseInfo(long userId);
	
	public Map<String, Object> getUserMoney(long userId);
	
	public Map<String, Object> getUserMerchantMemberInfo(long userId);
	
	public Map<String, Object> getUserPlatfromMemberInfo(long userId,String merchantId);
	
	public List<Map<String, Object>> getUserMoneyDetail(long userId,PageBounds pageBounds);
	
	public Map<String, Object> getUserRechargeGradeInfo(long userId);
	
}