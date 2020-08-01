package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.key.BlogKey;
import com.blog.model.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, BlogKey>{

}
