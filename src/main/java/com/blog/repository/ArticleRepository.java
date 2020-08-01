package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.key.ArticleKey;
import com.blog.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, ArticleKey>{
	
	@Query(value = "select * from article ar where ar.blog_id = ?1 and ar.author_id = ?2", nativeQuery = true)
	List<Article>getArticleList(int key, int authorId);

}
