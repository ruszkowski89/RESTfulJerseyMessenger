package com.ruszkowski89.RESTfulJerseyMessenger.model;

import java.util.Date;

public class Comment {

  private long commentId;
  private String commentContent;
  private Date created;
  private String author;

  public Comment(){
  }

  public Comment(long commentId, String commentContent, String author) {
    this.commentId = commentId;
    this.commentContent = commentContent;
    this.created = new Date();
    this.author = author;
  }

  public long getCommentId() {
    return commentId;
  }

  public void setCommentId(long commentId) {
    this.commentId = commentId;
  }

  public String getCommentContent() {
    return commentContent;
  }

  public void setCommentContent(String commentContent) {
    this.commentContent = commentContent;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
