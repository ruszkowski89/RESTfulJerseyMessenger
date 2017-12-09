package com.ruszkowski89.RESTfulJerseyMessenger.service;

import com.ruszkowski89.RESTfulJerseyMessenger.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
  // replace it with JDBC later
  public List<Message> getAllMessages(){
    Message m1 = new Message(1, "Michael R.", "What's up man");
    Message m2 = new Message(2, "Robert S.", "Hey ya");
    List<Message> list = new ArrayList<Message>();
    list.add(m1);
    list.add(m2);

    return list;
  }
}
