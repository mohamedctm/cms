package com.project2.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project2.cms.dtos.NewMessageDto;
import com.project2.cms.model.Inbox;
import com.project2.cms.model.Message;
import com.project2.cms.model.Writer;
import com.project2.cms.services.InboxService;
import com.project2.cms.services.MessageService;
import com.project2.cms.services.WriterService;

/**
 * POST to /messages/new in the following format { 
 *  { 
 *      "senderId": Integer, 
 *      "messageText": String, 
 *      "messageStatus": String ("unread"), 
 *      "inboxId": Integer
 *  } 
 *  
 *  See NewMessageDto.java for details
 * }
 * 
 * @author johna
 *
 */


@RestController
@Controller
@RequestMapping("/messages")
public class MessageController {

  @Autowired
  MessageService messageService;
  @Autowired
  WriterService writerService;
  @Autowired
  InboxService inboxService;

  @PostMapping("/new")
  public Message addNewMessage(@RequestBody NewMessageDto dto) {

    // Get Writer who sent the message
    Writer mySender;
    Integer mySenderId = dto.getSenderId();
    mySender = writerService.getSenderOfMessage(mySenderId);

    // Get the Inbox it's going to
    Inbox inboxAddress;
    Integer myInboxId = dto.getInboxId();
    inboxAddress = inboxService.getInboxById(myInboxId);

    // Attempt to create new message or throw exception
    try {
      Message ourMessage =
          new Message(0, mySender, dto.getMessageText(), dto.getMessageStatus(), inboxAddress);
      return messageService.createMessage(ourMessage);
    } catch (Throwable e) {
      System.out.println("Failed to create new message : " + e);
      throw e;
    }
  }

}
