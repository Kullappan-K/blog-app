package com.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.blog.key.CommentKey;

@Entity
@Table(name = "comments")
@IdClass(value = CommentKey.class)
public class Comments {

	@Id
	@Column(name = "id", nullable = false)
	private int id;
	
	@Id
	@Column(name = "blog_id", nullable = false)
	private int blog_id;
	
	@Column(name = "author_id", nullable = false)
	private String author_id;
	
	@Column(name = "comment_body", nullable = false)
	private String comment_body;
	
	@Column(name = "created_at", nullable = false)
	private String created_at;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getComment_body() {
		return comment_body;
	}

	public void setComment_body(String comment_body) {
		this.comment_body = comment_body;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

}
