package com.ruszkowski89.RESTfulJerseyMessenger.resources.beans;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;

public class MessageFilterBean {

  private @MatrixParam("userName") String userName;
  private @HeaderParam("lastName") String lastName;
  private @CookieParam("firstName") String firstName;

  // Getters and Setters
}
