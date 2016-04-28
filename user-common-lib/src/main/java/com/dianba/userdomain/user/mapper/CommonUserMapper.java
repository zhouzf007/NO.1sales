package com.dianba.userdomain.user.mapper;

import java.util.List;
import java.util.Map;

import com.dianba.userdomain.user.entity.User;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonUserMapper {

	public List<User> getUserList();
	
	public PageList<User> getUserList( PageBounds pageBounds );
	
	public List<User> getUserPageList( User user );
	
	public PageList<User> getUserPageList(User user, PageBounds pageBounds );
	
	public User getUserByPrimaryKey(Long id);
	
	public Integer hasUserById(Long id);
	
	public void createUser(User user);
	
	public void updateUser(User user);
	
	public int updateUserSelective(User user);
	
	public void deleteUser(Long id);
	
	public void updateUserScore(Map<String,Object>map);
}