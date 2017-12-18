package com.ruszkowski89.RESTfulJerseyMessenger.service;

import com.ruszkowski89.RESTfulJerseyMessenger.database.DatabaseClass;
import com.ruszkowski89.RESTfulJerseyMessenger.model.Message;
import com.ruszkowski89.RESTfulJerseyMessenger.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

  private Map<String, Profile> profiles = DatabaseClass.getProfiles();

  public ProfileService(){      // placeholder users
    addProfile(new Profile(1, "kekoludek", "Michal", "Ruszkowski"));
    addProfile(new Profile(2, "Bob", "Andrzej", "Sikor"));
  }

  // replace it with JDBC later
  public List<Profile> getAllProfiles(){
    return new ArrayList<>(profiles.values());
  }

  public Profile getProfile(String profileName){
    return profiles.get(profileName);
  }

  public Profile addProfile(Profile profile){
    if (profiles.get(profile.getProfileName()) != null) {
      System.out.println("Profile with this name already exists");
      return null;
    }
    profile.setId(setNewProfileId());                 // change it after connecting DB, this is placeholder
    profiles.put(profile.getProfileName(), profile);
    return profile;
  }

  public Profile updateProfile(Profile profile){
    if (profile.getProfileName() == null || profile.getProfileName().trim().isEmpty())
       return null;
    profile.setId(setNewProfileId());
    profiles.put(profile.getProfileName(), profile);
    return profile;
  }

  public Profile removeProfile(String profileName){
    return profiles.remove(profileName);
  }

  public long setNewProfileId(){
    long highestProfileId = 0;
    for (Profile profile: profiles.values()){
      if (profile.getId() > highestProfileId){
        highestProfileId = profile.getId();
      }
    }

    return highestProfileId+1;
  }
}
