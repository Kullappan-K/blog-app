package com.blog.service.impl;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.blog.model.Article;
import com.blog.model.Blog;
import com.blog.repository.ArticleRepository;
import com.blog.service.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepository articleRepository;
	
	@Override
	public List<Article> getAllArticle() {
		return articleRepository.findAll();
	}

	@Override
	public List<Article> getArticle(int key, int authorId) {
		return articleRepository.getArticleList(key, authorId);
	}

	@Override
	public void createArticle(Article article) {
		articleRepository.save(article);
	}
}
