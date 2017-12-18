package com.ruszkowski89.RESTfulJerseyMessenger.resources;

import com.ruszkowski89.RESTfulJerseyMessenger.model.Message;
import com.ruszkowski89.RESTfulJerseyMessenger.model.Profile;
import com.ruszkowski89.RESTfulJerseyMessenger.service.MessageService;
import com.ruszkowski89.RESTfulJerseyMessenger.service.ProfileService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

  private ProfileService profileService = new ProfileService();

  @GET
  public List<Profile> getAllProfiles(){
    return profileService.getAllProfiles();
  }

  @GET
  @Path("/{profileName}")
  public Profile getProfile(@PathParam("profileName") String profileName){
    return profileService.getProfile(profileName);
  }

  @POST
  public Profile addProfile(Profile profile){
    return profileService.addProfile(profile);
  }

  @PUT
  @Path("/{profileName}")
  public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile){
    profile.setProfileName(profileName);
    profile.setId(profile.getId());
    return profileService.updateProfile(profile);
  }

  @DELETE
  @Path("/{profileName}")
  public Profile removeProfile(@PathParam("profileName") String profileName){
    return profileService.removeProfile(profileName);
  }
}
