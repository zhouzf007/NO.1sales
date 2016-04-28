package com.dianba.userdomain.sysdictionary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.sysdictionary.entity.Message;
import com.dianba.userdomain.sysdictionary.mapper.CommonMessageMapper;
import com.dianba.userdomain.sysdictionary.service.MessageService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonMessageServiceImpl implements MessageService { 

    @Autowired
	private CommonMessageMapper messageMapper;
	
	public List<Message> getMessageList(){
		return messageMapper.getMessageList();
	}
	
	public PageList<Message> getMessageList(PageBounds pageBounds){
		return messageMapper.getMessageList(pageBounds);
	}
	
	public List<Message> getMessagePageList(Message message){
		return messageMapper.getMessagePageList(message);
	}
	
	public PageList<Message> getMessagePageList(Message message, PageBounds pageBounds){
		return messageMapper.getMessagePageList(message,pageBounds);
	}
	
	public Message getMessageByPrimaryKey(Long id){
		return messageMapper.getMessageByPrimaryKey(id);
	}
	
	public void createMessage(Message message){
		messageMapper.createMessage(message);
	}
	
	public void createMessageBitch(List<Message> messageList){
		for( Message message : messageList ) {
			messageMapper.createMessage(message);
		}
	}
	
	public void updateMessage(Message message){
		messageMapper.updateMessage(message);
	}
	
	public void updateMessageBitch(List<Message> messageList){
	    for( Message message : messageList ) {
		    messageMapper.updateMessage(message);
		}
	}
	
	public void updateMessageSelective(Message message){
	    messageMapper.updateMessageSelective(message);
	}
	
	public void updateMessageSelectiveBitch(List<Message> messageList){
	    for( Message message : messageList ) {
		    messageMapper.updateMessageSelective(message);
		}
	}
	
	public void deleteMessage(Long id){
		messageMapper.deleteMessage(id);
	}
	
	public void deleteMessageBitch(List<Long> idList){
		for( Long id : idList ) {
			messageMapper.deleteMessage(id);
		}
	}

}