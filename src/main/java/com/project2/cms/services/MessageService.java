package com.project2.cms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project2.cms.model.Message;
import com.project2.cms.repository.MessageRepository;

@Service
public class MessageService {

  @Autowired
  MessageRepository messageRepository;
  
  public Message createMessage(Message message) {
    message.setId(0);
    return messageRepository.save(message);
  }
  
}
