package com.blog.controller;

import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.exception.BlogExceptionHandler;
import com.blog.exception.CommentsExceptionHandler;
import com.blog.exception.DatabaseExceptionHandler;
import com.blog.key.BlogKey;
import com.blog.key.BlogTokenResponse;
import com.blog.key.SecurityData;
import com.blog.model.Article;
import com.blog.model.Blog;
import com.blog.model.Comments;
import com.blog.model.Replies;
import com.blog.service.impl.ArticleServiceImpl;
import com.blog.service.impl.BlogServiceImpl;
import com.blog.service.impl.CommentsServiceImpl;
import com.blog.service.impl.SecurityServiceImpl;
import com.blog.util.SecurityUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class BlogController {
	
	@Autowired
	private BlogServiceImpl blogServiceImpl;
	
	@Autowired
	private ArticleServiceImpl articleServiceImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecurityServiceImpl securityService;
	
	@Autowired
	private CommentsServiceImpl commentsServiceImpl;
	
	@Autowired
	private SecurityUtil securityUtil;
	
	@GetMapping("/allblogs")
	public ResponseEntity<?> getAllBlog() throws JsonProcessingException, BlogExceptionHandler {
		List<Blog> blogList = blogServiceImpl.getAllBlog();
		if(CollectionUtils.isEmpty(blogList)) {
			throw new BlogExceptionHandler("Blog not found", HttpStatus.BAD_REQUEST.value());
		}
		return ResponseEntity.ok(blogList);
	}
	
	@GetMapping("/allarticle")
	public ResponseEntity<?> getAllArticle() throws JsonProcessingException, BlogExceptionHandler {
		List<Article> articleList = articleServiceImpl.getAllArticle();
		if(CollectionUtils.isEmpty(articleList)) {
			throw new BlogExceptionHandler("Article not found", HttpStatus.BAD_REQUEST.value());
		}
		return ResponseEntity.ok(articleList);
	}
	
	@GetMapping("/blog/{id}")
	public ResponseEntity<?> getBlog(@PathVariable String id) throws JsonProcessingException, BlogExceptionHandler {
		List<Blog> blogData = blogServiceImpl.getBlog(new BlogKey(Integer.parseInt(id), String.valueOf(securityService.getUserId())));
		if(CollectionUtils.isEmpty(blogData)) {
			throw new BlogExceptionHandler("Blog not found", HttpStatus.BAD_REQUEST.value());
		}
		return ResponseEntity.ok(blogData);
	}
	
	@GetMapping("/blog/{id}/comments")
	public ResponseEntity<?> getAllComments(@PathVariable String id) throws JsonProcessingException, CommentsExceptionHandler{
		List<Object> commentList = commentsServiceImpl.getAllComments(Integer.parseInt(id));
		if(CollectionUtils.isEmpty(commentList)) {
			throw new CommentsExceptionHandler("Comments not found", HttpStatus.NOT_FOUND.value());
		}
		return ResponseEntity.ok(commentList);
	}
	
	@GetMapping("/blog/{id}/comments/{comment_id}")
	public ResponseEntity<?> getComments(@PathVariable String id, @PathVariable String comment_id) throws JsonProcessingException, CommentsExceptionHandler{
		List<Object> commentList = commentsServiceImpl.getComments(Integer.parseInt(id), Integer.parseInt(comment_id));
		if(CollectionUtils.isEmpty(commentList)) {
			throw new CommentsExceptionHandler("Comments not found", HttpStatus.NOT_FOUND.value());
		}
		return ResponseEntity.ok(commentList);
	}
	@PostMapping("/addcomments/create")
	public ResponseEntity<?> createComments(@RequestBody Comments comments) throws JsonProcessingException, DatabaseExceptionHandler{
		try {
			commentsServiceImpl.createComments(comments);
			}catch(Exception ex) {
				throw new DatabaseExceptionHandler("CHECK INSERT COMMENTS JSON", HttpStatus.CONFLICT.value());
			}
			return ResponseEntity.ok("Comments added successfully ");
	}
	
	@PostMapping("/addreply/create")
	public ResponseEntity<?> createReply(@RequestBody Replies replies) throws JsonProcessingException, DatabaseExceptionHandler{
		try {
			commentsServiceImpl.createReply(replies);
			}catch(Exception ex) {
				throw new DatabaseExceptionHandler("CHECK INSERT REPLY JSON", HttpStatus.CONFLICT.value());
			}
			return ResponseEntity.ok("reply added successfully");
	}
	
	@PostMapping("/addblog/create")
	public ResponseEntity<?> createBlog(@RequestBody Blog blog) throws DatabaseExceptionHandler {
		try {
		blogServiceImpl.createBlog(blog);
		}catch(Exception ex) {
			throw new DatabaseExceptionHandler("CHECK INSERT BLOG JSON", HttpStatus.CONFLICT.value());
		}
		return ResponseEntity.ok("blog created successfully");
	}
	
	@PostMapping("/addarticle/create")
	public ResponseEntity<?> createArticle(@RequestBody Article article) throws DatabaseExceptionHandler {
		try {
		   articleServiceImpl.createArticle(article);
	    }catch(Exception ex) {
		   throw new DatabaseExceptionHandler("CHECK INSERT ARTICLE JSON", HttpStatus.CONFLICT.value());
	    }
	    return ResponseEntity.ok("article created successfully");
	}
	
	@GetMapping("/blog/{id}/articles")
	public ResponseEntity<?>getArticle(@PathVariable String id) throws BlogExceptionHandler{
		List<Article> articleList = articleServiceImpl.getArticle(Integer.parseInt(id), securityService.getUserId());
		if(CollectionUtils.isEmpty(articleList)) {
			throw new BlogExceptionHandler("Articles not found", HttpStatus.BAD_REQUEST.value());
		}
		return ResponseEntity.ok(articleList);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?>createToken(@RequestBody SecurityData securityData)throws Exception{
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(securityData.getUserName(), 
				securityData.getPassword()));
		}catch(BadCredentialsException e) {
			throw new BlogExceptionHandler("Invaild User... Check login details", HttpStatus.UNAUTHORIZED.value());
		}
		final UserDetails userDetails = securityService.loadUserByUsername(securityData.getUserName());
		
		if(userDetails == null) {
			return ResponseEntity.ok(new BlogTokenResponse(""));
		}
		
		final String jwt = securityUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new BlogTokenResponse(jwt));
	}
}
