package com.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.blog.key.RepliesKey;

@Entity
@Table(name = "replies")
@IdClass(value = RepliesKey.class)
public class Replies {
	
	@Id
	@Column(name = "id", nullable = false)
	private int id;
	
	@Id
	@Column(name = "comment_id", nullable = false)
	private int comment_id;
	
	@Column(name = "author_id", nullable = false)
	private String author_id;
	
	@Column(name = "reply_body", nullable = false)
	private String reply_body;
	
	@Column(name = "created_at", nullable = false)
	private String created_at;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}

	public String getReply_body() {
		return reply_body;
	}

	public void setReply_body(String reply_body) {
		this.reply_body = reply_body;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

}
