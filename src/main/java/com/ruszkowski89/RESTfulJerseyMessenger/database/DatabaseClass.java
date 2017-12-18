package com.ruszkowski89.RESTfulJerseyMessenger.database;

import com.ruszkowski89.RESTfulJerseyMessenger.model.Message;
import com.ruszkowski89.RESTfulJerseyMessenger.model.Profile;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {  // replace with JDBC later

  private static Map<Long, Message> messages = new HashMap<>();
  private static Map<String , Profile> profiles = new HashMap<>();

  public static Map<Long, Message> getMessages() {
    return messages;
  }

  public static Map<String, Profile> getProfiles() {
    return profiles;
  }
}
