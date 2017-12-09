package com.ruszkowski89.RESTfulJerseyMessenger.resources;

import com.ruszkowski89.RESTfulJerseyMessenger.model.Message;
import com.ruszkowski89.RESTfulJerseyMessenger.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

@Path("/messages")
public class MessageResource {

  MessageService messageService = new MessageService();

  @GET
  @Produces(MediaType.APPLICATION_XML)
  public List<Message> getMessage(){
    return messageService.getAllMessages();
  }
}
