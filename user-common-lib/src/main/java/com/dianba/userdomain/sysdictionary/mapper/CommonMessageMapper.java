package com.dianba.userdomain.sysdictionary.mapper;

import java.util.List;

import com.dianba.userdomain.sysdictionary.entity.Message;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonMessageMapper {

	public List<Message> getMessageList();

	public PageList<Message> getMessageList( PageBounds pageBounds );
	
	public List<Message> getMessagePageList( Message message );
	
	public PageList<Message> getMessagePageList(Message message, PageBounds pageBounds );
	
	public Message getMessageByPrimaryKey(Long id);
	
	public void createMessage(Message message);
	
	public void updateMessage(Message message);
	
	public void updateMessageSelective(Message message);
	
	public void deleteMessage(Long id);
}