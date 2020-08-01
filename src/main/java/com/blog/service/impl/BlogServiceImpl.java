package com.blog.service.impl;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.key.BlogKey;
import com.blog.model.Article;
import com.blog.model.Blog;
import com.blog.repository.BlogRepository;
import com.blog.service.BlogService;

@Service
@Transactional
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogRepository blogRepository;
	
	
	@Override
	public List<Blog> getAllBlog() {
		return blogRepository.findAll();
	}

	@Override
	public List<Blog> getBlog(BlogKey blogKey) {
		return blogRepository.findAllById(Arrays.asList(blogKey));
	}

	@Override
	public void createBlog(Blog blog) {
		blogRepository.save(blog);
	}
}
