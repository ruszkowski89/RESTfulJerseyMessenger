package com.ruszkowski89.RESTfulJerseyMessenger.service;

import com.ruszkowski89.RESTfulJerseyMessenger.database.DatabaseClass;
import com.ruszkowski89.RESTfulJerseyMessenger.model.Message;
import com.ruszkowski89.RESTfulJerseyMessenger.model.Profile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {

  private Map<Long, Message> messages = DatabaseClass.getMessages();
  private Map<String , Profile> profiles = DatabaseClass.getProfiles();

  public MessageService(){    // placeholder messages
    messages.put(1L, new Message(1, "Michal R.", "What's up"));
    messages.put(2L, new Message(2, "Michal B.", "Yo man"));
  }

  // replace it with JDBC later
  public List<Message> getAllMessages(){
    return new ArrayList<>(messages.values());
  }

  public Message getMessage(long id){
    return messages.get(id);
  }

  public Message addMessage(Message message){
    message.setId(setNewMessageId());
    messages.put(message.getId(), message);
    return message;
  }

  public Message updateMessage(Message message){
    if (message.getId() <= 0)
      return null;
    message.setId(setNewMessageId());
    messages.put(message.getId(), message);
    return message;
  }

  public Message removeMessage(long id){
    return messages.remove(id);
  }

  public long setNewMessageId(){
    long highestMessageId = 0;
    for (Profile profile: profiles.values()){
      if (profile.getId() > highestMessageId){
        highestMessageId = profile.getId();
      }
    }

    return highestMessageId+1;
  }

  public List<Message> getAllMessagesFromYear(int year){
    List<Message> messagesForYear = new ArrayList<>();
    Calendar calendar = Calendar.getInstance();
    for (Message message: messages.values()){
      calendar.setTime(message.getDate());
      if(calendar.get(Calendar.YEAR) == year){
        messagesForYear.add(message);
      }
    }
    return messagesForYear;
  }

  public List<Message> getAllMessagesPaginated(int start, int size){
    ArrayList<Message> list = new ArrayList<Message>(messages.values());
    if (start + size > list.size())
      return new ArrayList<Message>();
    return list.subList(start, start + size);
  }
}
