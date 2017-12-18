package com.ruszkowski89.RESTfulJerseyMessenger.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.awt.*;

@Path("/injectDemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

  @GET
  @Path("annotations")
  public String getParamsUsingAnnotations(@MatrixParam("userName") String userName,
                                          @HeaderParam("lastName") String lastName,
                                          @CookieParam("firstName") String firstName){
    return "hi " + userName + " header Value is " + lastName + " cookie param: " + firstName;
  }

  /*@GET
  @Path("context")
  public String getAbsolutePathParameter(@Context UriInfo uriInfo){
    return "URI is: " + uriInfo.getAbsolutePath()Path().toString();
  }*/

  @GET
  @Path("context")
  public String getHTTPHeaders(@Context HttpHeaders httpHeaders){
    return httpHeaders.getCookies().toString();
  }
}
