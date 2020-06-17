package com.project2.cms.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(schema = "project2", name = "inboxes")
public class Inbox {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @JoinColumn(name = "owner")
  @OneToOne(fetch = FetchType.EAGER)
  private Writer owner;
  
  @OneToMany(mappedBy = "inbox", cascade = CascadeType.MERGE)
  @JsonIgnoreProperties({"inbox"})
  private List<Message> messages;

  // No arguments constructor
  public Inbox() {
    
  }
  
  // Constructor using fields
  public Inbox(Integer id, Writer owner, List<Message> messages) {
    super();
    this.id = id;
    this.owner = owner;
    this.messages = messages;
  }
  
  // Getters and setters
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Writer getOwner() {
    return owner;
  }

  public void setOwner(Writer owner) {
    this.owner = owner;
  }
  
  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }
  
  // To string
  @Override
  public String toString() {
    return "Inbox [id=" + id + ", owner=" + owner + ", messages=" + messages + "]";
  }


}
