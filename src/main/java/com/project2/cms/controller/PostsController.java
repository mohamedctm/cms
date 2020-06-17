package com.project2.cms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project2.cms.model.Posts;
import com.project2.cms.repository.PostsRepository;
import com.project2.cms.services.PostsService;
import com.project2.cms.exception.ResourceNotFoundException;

@RestController
@Controller
@RequestMapping("/")
public class PostsController {
	
	@Autowired
	  PostsService postService;
    @Autowired
    private PostsRepository postRepository;

    @GetMapping("/posts")
    public List<Posts> getAllPosts(HttpSession session) {
    	if (session.getAttribute("isLoggedIn") != null
    	        && (Boolean) session.getAttribute("isLoggedIn")) {
    		if((Integer)session.getAttribute("writerpermission") != 2) {
    			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    			}
        return postRepository.findAll();
    	}else{
    	      throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }
    
    @GetMapping("/posts/author/{id}")
    public Object allPostsByAuthor(@PathVariable(value = "id") Integer authorId,HttpSession session) {
    	if (session.getAttribute("isLoggedIn") != null
    	        && (Boolean) session.getAttribute("isLoggedIn")) {
 
      List<Posts> store = postRepository.postsByAuthor(authorId);
      
      return store;
    	}
	      throw new ResponseStatusException(HttpStatus.FORBIDDEN);

    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Posts> getPostById(@PathVariable(value = "id") Integer postId,HttpSession session)
        throws ResourceNotFoundException {
    	if (session.getAttribute("isLoggedIn") != null
    	        && (Boolean) session.getAttribute("isLoggedIn")) {
    		Posts post = postRepository.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    	       Integer key = post.getAuthor(); 
    	       if((Integer)session.getAttribute("writerpermission") == 2
       				||
       				(Integer)session.getAttribute("writerid") == key) {
    	    	   return ResponseEntity.ok().body(post);  
    	       }
    		
    	       throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    	}else{
  	      throw new ResponseStatusException(HttpStatus.FORBIDDEN);
      }
    }
    
    ///leave for later <when created author is the current id>
    @PostMapping("/posts")
    public Posts createPost(@Validated @RequestBody Posts post, HttpSession session) {
    	if (session.getAttribute("isLoggedIn") != null
    	        && (Boolean) session.getAttribute("isLoggedIn")) {		
        return postRepository.save(post);
    	}else{
    	      throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }
    
    //update posts (admin: && the posts for his own)

    @PutMapping("/posts/{id}")
    public ResponseEntity<Posts> updatePost(@PathVariable(value = "id") Integer postId,
         @Validated @RequestBody Posts postDetails,  HttpSession session) throws ResourceNotFoundException {
    	if (session.getAttribute("isLoggedIn") != null
    	        && (Boolean) session.getAttribute("isLoggedIn")) {
    		
Posts post = postRepository.findById(postId)
    			        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
Integer key = post.getAuthor(); 
if((Integer)session.getAttribute("writerpermission") == 2
		||
		(Integer)session.getAttribute("writerid") == key) {
	
			if(postDetails.getPostTitle().toString().trim() != "" && !(postDetails.getPostTitle().toString().trim().isEmpty())) { 
				
			
    			    	   post.setPostTitle(postDetails.getPostTitle());}
    			       //data      
    			       if(postDetails.getPostDescription().toString().trim() != "" && !(postDetails.getPostDescription().toString().trim().isEmpty())) { 
    			    	   post.setPostDescription(postDetails.getPostDescription());}
    			       //data
    			       if(postDetails.getPostText().toString().trim() != "" && !(postDetails.getPostText().toString().trim().isEmpty())) { 
    			    	   post.setPostText(postDetails.getPostText());}
    			       //data
    			       if(postDetails.getPostType().toString().trim() != "" && !(postDetails.getPostType().toString().trim().isEmpty())) { 
    			    	   post.setPostType(postDetails.getPostType());}
    			       //data
    			       if(postDetails.getPostField().toString().trim() != "" && !(postDetails.getPostField().toString().trim().isEmpty())) { 
    			    	   post.setPostField(postDetails.getPostField());}
    			       //data
    			       if(postDetails.getKeyWords().toString().trim() != "" && !(postDetails.getKeyWords().toString().trim().isEmpty())) { 
    			    	   post.setKeyWords(postDetails.getKeyWords());}
    			       
    			       final Posts updatedPost = postRepository.save(post);
    			        return ResponseEntity.ok(updatedPost); 
					}
					throw new ResponseStatusException(HttpStatus.FORBIDDEN);
    	}else{
  	      throw new ResponseStatusException(HttpStatus.FORBIDDEN);
      }
    }
    
    //publish
    @PutMapping("/publish/{id}")
    public ResponseEntity<Posts> publishPost(@PathVariable(value = "id") Integer postId
    		,HttpSession session) throws ResourceNotFoundException {
    	if ((session.getAttribute("isLoggedIn") != null
    	        && (Boolean) session.getAttribute("isLoggedIn"))
    	        && (Integer)session.getAttribute("writerpermission") == 2) {
    		
    					Posts post = postRepository.findById(postId)
    			        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
					  //data
    					java.util.Date myDate = new Date();
    					java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

    			    	   post.setResolver((Integer)session.getAttribute("writerid"));
    			    	   post.setPublished(1);
    			    	   post.setDatePublished(sqlDate);

    			       //ends	       
    			       final Posts updatedPost = postRepository.save(post);
    			        return ResponseEntity.ok(updatedPost);    			 	
    	}else{
  	      throw new ResponseStatusException(HttpStatus.FORBIDDEN);
      }
    }
    
    //UNPUBLISH
    @PutMapping("/unpublish/{id}")
    public ResponseEntity<Posts> unpublishPost(@PathVariable(value = "id") Integer postId
    		,HttpSession session) throws ResourceNotFoundException {
    	if ((session.getAttribute("isLoggedIn") != null
    	        && (Boolean) session.getAttribute("isLoggedIn"))
    	        && (Integer)session.getAttribute("writerpermission") == 2) {
    		
    					Posts post = postRepository.findById(postId)
    			        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
					  //data
						java.util.Date myDate = new Date();
    					java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

    			    	   post.setResolver((Integer)session.getAttribute("writerid"));
    			    	   post.setPublished(0);
    			    	   post.setDatePublished(sqlDate);
    			       //ends	       
    			       final Posts updatedPost = postRepository.save(post);
    			        return ResponseEntity.ok(updatedPost);    			 	
    	}else{
  	      throw new ResponseStatusException(HttpStatus.FORBIDDEN);
      }
    }
    //change status
    @PutMapping("/status/{status}/{id}")
    public ResponseEntity<Posts> statusPost(@PathVariable(value = "id") Integer postId
    		,@PathVariable(value = "status") String status
    		,HttpSession session) throws ResourceNotFoundException {
    	if ((session.getAttribute("isLoggedIn") != null
    	        && (Boolean) session.getAttribute("isLoggedIn"))
    	        && (Integer)session.getAttribute("writerpermission") == 2) {
    		
    					Posts post = postRepository.findById(postId)
    			        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
					  //data
    			    	   post.setResolver((Integer)session.getAttribute("writerid"));
    			    	   post.setStatus(status);
    			       //ends	       
    			       final Posts updatedPost = postRepository.save(post);
    			        return ResponseEntity.ok(updatedPost);    			 	
    	}else{
  	      throw new ResponseStatusException(HttpStatus.FORBIDDEN);
      }
    }

    @DeleteMapping("/posts/{id}")
    public Map<String, Boolean> deletePost(@PathVariable(value = "id") Integer postId, HttpSession session)
         throws ResourceNotFoundException {
    	if (session.getAttribute("isLoggedIn") != null
    	        && (Boolean) session.getAttribute("isLoggedIn")) {
    		if((Integer)session.getAttribute("writerpermission") != 2) {
    			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    			}
    	Posts post = postRepository.findById(postId)
       .orElseThrow(() -> new ResourceNotFoundException("Post not found for this id :: " + postId));

    	postRepository.delete(post);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
        
    	}else{
    	      throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    
    
    
}