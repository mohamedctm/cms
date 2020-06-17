package com.project2.cms.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//import lombok.Data;

@Entity
@Table(schema="project2", name = "posts")


public class Posts {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "postid")
	private Integer postId;
	  @Column(name = "author")
	private Integer author;
	  @Column(name = "posttitle")
	private String postTitle;
	  @Column(name = "postdescription")
	private String postDescription;
	  @Column(name = "posttext")
	private String postText;
	  @Column(name = "datesubmitted")
	private Date dateSubmitted;
	  @Column(name = "datepublished")
	private Date datePublished;
	  @Column(name = "posttype")
	private String postType;
	  @Column(name = "postfield")
	private String postField;
	  @Column(name = "keywords")
	private String keyWords;
	  @Column(name = "resolver")
	private Integer resolver ;
	  @Column(name = "status")
	private String status ;
	  @Column(name = "published")
	private Integer published;
	
	public Posts() {}
	
	public Posts(Integer postId, Integer author, String postTitle, String postDescription, String postText,
			Date dateSubmitted, Date datePublished, String postType, String postField, String keyWords,
			Integer resolver, String status, Integer published) {
		super();
		this.postId = postId;
		this.author = author;
		this.postTitle = postTitle;
		this.postDescription = postDescription;
		this.postText = postText;
		this.dateSubmitted = dateSubmitted;
		this.datePublished = datePublished;
		this.postType = postType;
		this.postField = postField;
		this.keyWords = keyWords;
		this.resolver = resolver;
		this.status = status;
		this.published = published;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostDescription() {
		return postDescription;
	}

	public void setPostDescription(String postDescription) {
		this.postDescription = postDescription;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public Date getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(Date dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostField() {
		return postField;
	}

	public void setPostField(String postField) {
		this.postField = postField;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public Integer getResolver() {
		return resolver;
	}

	public void setResolver(Integer resolver) {
		this.resolver = resolver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPublished() {
		return published;
	}

	public void setPublished(Integer published) {
		this.published = published;
	}

	@Override
	public String toString() {
		return "Posts [postId=" + postId + ", author=" + author + ", postTitle=" + postTitle + ", postDescription="
				+ postDescription + ", postText=" + postText + ", dateSubmitted=" + dateSubmitted + ", datePublished="
				+ datePublished + ", postType=" + postType + ", postField=" + postField + ", keyWords=" + keyWords
				+ ", resolver=" + resolver + ", status=" + status + ", published=" + published + "]";
	}
	
	
	

}
