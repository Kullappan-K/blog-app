package com.blog.service;

import java.util.List;
import java.util.Optional;

import com.blog.model.Article;
import com.blog.model.Blog;

public interface ArticleService {
	List<Article> getAllArticle();
	List<Article> getArticle(int key, int authorId);
	void createArticle(Article article);
}
