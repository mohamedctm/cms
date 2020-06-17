package com.project2.cms.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.cms.repository.PostsRepository;


// Its good practice to make Interfaces for your services, but not strictly necessary. Just less
// modular
@Service
public class PostsService {

  @Autowired
  PostsRepository postRepository;



//  public Boolean checkCredentials(String username, String password) {
//    // we just check if this username and password exist in the db
//    return postRepository.checkUsernamePassword(username, password).size() > 0;
//  }


}

