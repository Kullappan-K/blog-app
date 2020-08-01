package com.blog.model;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.blog.key.BlogKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * Used to maintain the blog table details
 * 
 * @author Kullappan K
 *
 */
@Entity
@Table(name = "blog")
@IdClass(BlogKey.class)
public class Blog {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "blog_name", nullable = false)
	private String name;

	@Column(name = "blog_description", nullable = false)
	private String description;

	@Column(name = "created_at", nullable = false)
	private String created_at;

	@Column(name = "updated_at", nullable = false)
	private String updated_at;

	@Column(name = "user_id", nullable = false)
	@Id
	private String user_id;
	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCreated_at() {
		return created_at;
	}



	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}



	public String getUpdated_at() {
		return updated_at;
	}



	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}



	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
	  @Override public String toString() { ObjectMapper blogMapper = new
	  ObjectMapper(); String blogData = ""; try { blogData =
	  blogMapper.writeValueAsString(this); } catch (JsonProcessingException e) {
	  e.printStackTrace(); } return blogData; }
	 
}
