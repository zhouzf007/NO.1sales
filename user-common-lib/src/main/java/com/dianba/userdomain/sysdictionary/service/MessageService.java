package com.dianba.userdomain.sysdictionary.service;

import java.util.List;

import com.dianba.userdomain.sysdictionary.entity.Message;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface MessageService {

	public List<Message> getMessageList();
	
	public PageList<Message> getMessageList(PageBounds pageBounds);
	
	public List<Message> getMessagePageList(Message message);
	
	public PageList<Message> getMessagePageList(Message message, PageBounds pageBounds);
	
	public Message getMessageByPrimaryKey(Long id);
	
	public void createMessage(Message message);
	
	public void createMessageBitch(List<Message> messageList);
	
	public void updateMessage(Message message);
	
	public void updateMessageBitch(List<Message> messageList);
	
	public void updateMessageSelective(Message message);
	
	public void updateMessageSelectiveBitch(List<Message> messageList);
	
	public void deleteMessage(Long id);
	
	public void deleteMessageBitch(List<Long> idList);

}