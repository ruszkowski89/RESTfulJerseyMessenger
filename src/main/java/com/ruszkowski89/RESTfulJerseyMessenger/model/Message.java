package com.ruszkowski89.RESTfulJerseyMessenger.model;

import java.util.Date;

public class Message {
  private long id;
  private String author;
  private Date date;
  private String message;

  public Message(long id, String author, String message) {
    this.id = id;
    this.author = author;
    this.date = new Date();
    this.message = message;
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
