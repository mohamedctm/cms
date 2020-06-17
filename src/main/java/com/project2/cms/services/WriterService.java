package com.project2.cms.services;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project2.cms.model.Writer;
import com.project2.cms.repository.WriterRepository;


// Its good practice to make Interfaces for your services, but not strictly necessary. Just less
// modular
@Service
public class WriterService {

  @Autowired
  WriterRepository writerRepository;



  public Boolean checkCredentials(String username, String password) {
    // we just check if this username and password exist in the db
    return writerRepository.checkUsernamePassword(username, password).size() > 0;
  }
  
  // Get writer from integer sent with a message
  public Writer getSenderOfMessage(Integer senderid) {
    Optional<Writer> ourWriter = writerRepository.findById(senderid);
    Writer finalWriter = ourWriter.get();
    return finalWriter;

  }


}

