package com.ruszkowski89.RESTfulJerseyMessenger.resources;

import com.ruszkowski89.RESTfulJerseyMessenger.model.Message;
import com.ruszkowski89.RESTfulJerseyMessenger.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

  private MessageService messageService = new MessageService();

  @GET
  public List<Message> getAllMessages(@QueryParam("year") int year,
                                      @QueryParam("start") int start,
                                      @QueryParam("size") int size){
    if (year > 0)
      return messageService.getAllMessagesFromYear(year);
    if (start >= 0 || size > 0)
      return messageService.getAllMessagesPaginated(start, size);
    return messageService.getAllMessages();
  }

  @POST
  public Message addMessage(Message message){
    return messageService.addMessage(message);
  }

  @DELETE
  @Path("/{messageId}")
  public Message deleteMessage(@PathParam("messageId") long id){
    return messageService.removeMessage(id);
  }

  @PUT
  @Path("/{messageId}")
  public Message updateMessage(@PathParam("messageId") long id, Message message){
    message.setId(id);
    return messageService.updateMessage(message);
  }

  @GET
  @Path("/{messageId}")
  public Message getMessage(@PathParam("messageId") long messageId){
    return messageService.getMessage(messageId);
  }

  @Path("/{messageId}/comments")
  public CommentResource getCommentResource(){
    return new CommentResource();
  }

}
