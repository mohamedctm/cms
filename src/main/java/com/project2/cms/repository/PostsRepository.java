package com.project2.cms.repository;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project2.cms.model.Posts;


@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer>{

	
	  @Query(value = "select * from project2.posts where author = :author",
		      nativeQuery = true)
		  List<Posts> postsByAuthor(Integer author );
	  
	  
}
	  
	  
	  


