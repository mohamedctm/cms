package com.project2.cms.repository;



import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project2.cms.model.Writer;


@Repository
public interface WriterRepository extends JpaRepository<Writer, Integer>{

//
//		  List<Writer> checkUsernamePassword(String username, String password);
//	
//	  List<Writer> findByUsernameAndPassword(String username, String password);
	
	  @Query(value = "select * from project2.writers where username = :username and password = :password",
		      nativeQuery = true)
		  List<Writer> checkUsernamePassword(String username, String password);
	  
	// FIND WRITER FROM ID IN POST TO /messages --> John A. (06/16/20)
	     @Query(value = "select * from project2.writers where writerid = :senderid", nativeQuery = true)
	     List<Writer> grabMessageSender(Integer senderid);
	  
	  



}