package com.ruszkowski89.RESTfulJerseyMessenger.service;


import com.ruszkowski89.RESTfulJerseyMessenger.database.DatabaseClass;
import com.ruszkowski89.RESTfulJerseyMessenger.model.Comment;
import com.ruszkowski89.RESTfulJerseyMessenger.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {

  private Map<Long, Message> messages = DatabaseClass.getMessages();

  public CommentService(){
  }

  public List<Comment> getAllComments(long messageId){
    Map<Long, Comment> comments = messages.get(messageId).getComments();
    return new ArrayList<Comment>(comments.values());
  }

  public Comment getComment(long messageId, long commentId){
    Map<Long, Comment> comments = messages.get(messageId).getComments();
    return comments.get(commentId);
  }

  public Comment addComment(long messageId, Comment comment){
    Map<Long, Comment> comments = messages.get(messageId).getComments();
    comment.setCommentId(comments.size()+1);
    comments.put(comment.getCommentId(), comment);
    return comment;
  }

  public Comment updateComment(long messageId, Comment comment){
    Map<Long, Comment> comments = messages.get(messageId).getComments();
    if (comment.getCommentId() <= 0)
      return null;
    return comments.put(comment.getCommentId(), comment);
  }

  public Comment removeComment(long messageId, long commentId){
    Map<Long, Comment> comments = messages.get(messageId).getComments();
    return comments.remove(commentId);
  }
}
