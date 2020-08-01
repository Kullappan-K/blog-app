package com.blog.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.blog.key.ArticleKey;

/**
 * 
 * Used to maintain the article table details
 * 
 * @author Kullappan K
 *
 */
@Entity
@Table(name = "article")
@IdClass(value = ArticleKey.class)
public class Article {
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "blog_id", nullable = false)
	private Integer blog_id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "article_body", nullable = false)
	private String article_body;
	
	@Id
	@Column(name = "author_id", nullable = false)
	private String author_id;
	
	@Column(name = "created_at", nullable = false)
	private String created_at;
	
	@Column(name = "updated_at", nullable = false)
	private String updated_at;
	
	@Column(name = "published_at", nullable = false)
	private String published_at;
	
	@Column(name = "category", nullable = false)
	private String category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(Integer blog_id) {
		this.blog_id = blog_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArticle_body() {
		return article_body;
	}

	public void setArticle_body(String article_body) {
		this.article_body = article_body;
	}

	public String getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
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

	public String getPublished_at() {
		return published_at;
	}

	public void setPublished_at(String published_at) {
		this.published_at = published_at;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	

}
