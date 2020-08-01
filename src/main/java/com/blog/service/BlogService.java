package com.blog.service;

import java.util.List;

import com.blog.key.BlogKey;
import com.blog.model.Blog;

public interface BlogService {
	
	List<Blog> getAllBlog();
	List<Blog> getBlog(BlogKey blogKey);
	void createBlog(Blog blog);
}
