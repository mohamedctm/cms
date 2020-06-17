package com.project2.cms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "project2", name = "messages")
public class Message {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @JoinColumn(name = "sender")
  @ManyToOne(fetch = FetchType.EAGER)
  private Writer sender;
  @Column(name = "message_text")
  private String messageText;
  @Column(name = "message_status")
  private String messageStatus;
  @JoinColumn(name = "inbox")
  @ManyToOne(fetch = FetchType.EAGER)
  private Inbox inbox;
  
  // No arguments constructor
  public Message() {
    
  }
  
  // Constructor using fields
  public Message(Integer id, Writer sender, String messageText, String messageStatus, Inbox inbox) {
    super();
    this.id = id;
    this.sender = sender;
    this.messageText = messageText;
    this.messageStatus = messageStatus;
    this.inbox = inbox;
  }
  
  // Getters and Setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Writer getSender() {
    return sender;
  }

  public void setSender(Writer sender) {
    this.sender = sender;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public String getMessageStatus() {
    return messageStatus;
  }

  public void setMessageStatus(String messageStatus) {
    this.messageStatus = messageStatus;
  }

  public Inbox getInbox() {
    return inbox;
  }

  public void setInbox(Inbox inbox) {
    this.inbox = inbox;
  }
  
  // To string
  @Override
  public String toString() {
    return "Message [id=" + id + ", sender=" + sender + ", messageText=" + messageText
        + ", messageStatus=" + messageStatus + ", inbox=" + inbox + "]";
  }
  
  
}
