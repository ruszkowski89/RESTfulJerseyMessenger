package com.ruszkowski89.RESTfulJerseyMessenger.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class Message {
  private long id;
  private String author;
  private Date date;
  private String message;
  private Map<Long, Comment> comments = new HashMap<Long, Comment>();

  public Message(){
  }

  public Message(long id, String author, String message) {
    this.id = id;
    this.author = author;
    this.date = new Date();
    this.message = message;
  }

  @XmlTransient
  public Map<Long, Comment> getComments() {
    return comments;
  }

  public void setComments(Map<Long, Comment> comments) {
    this.comments = comments;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
