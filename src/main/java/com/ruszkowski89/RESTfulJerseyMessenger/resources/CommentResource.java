package com.ruszkowski89.RESTfulJerseyMessenger.resources;

import com.ruszkowski89.RESTfulJerseyMessenger.model.Comment;
import com.ruszkowski89.RESTfulJerseyMessenger.service.CommentService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {            // subclass of MessageResource

  private CommentService commentService = new CommentService();

  @GET
  public List<Comment> getAllComments(@PathParam("messageId") long messageId){
    return commentService.getAllComments(messageId);
  }

  @GET
  @Path("/{commentId}")
  public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
    return commentService.getComment(messageId, commentId);
  }

  @POST
  public Comment addComment(@PathParam("messageId") long messageId, Comment comment){
    return commentService.addComment(messageId, comment);
  }

  @PUT
  @Path("/{commentId}")
  public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId, Comment comment){
    comment.setCommentId(commentId);
    return commentService.updateComment(messageId, comment);
  }

  @DELETE
  @Path("/{commentId}")
  public Comment removeComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId){
    return commentService.removeComment(messageId, commentId);
  }

}
