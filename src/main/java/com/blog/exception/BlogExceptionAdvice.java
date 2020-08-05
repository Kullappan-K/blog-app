package com.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BlogExceptionAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(BlogExceptionHandler.class)
	public ResponseEntity<BlogError>emptyBlog(BlogExceptionHandler ex){
		BlogError blogError = new BlogError();
		blogError.setErrorMessage(ex.getMessage());
		blogError.setErrorCode(ex.getStatusCode());
		return new ResponseEntity<BlogError>(blogError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserExceptionHandler.class)
	public ResponseEntity<BlogError>invaildUser(UserExceptionHandler ex){
		BlogError blogError = new BlogError();
		blogError.setErrorMessage(ex.getMessage());
		blogError.setErrorCode(ex.getStatusCode());
		return new ResponseEntity<BlogError>(blogError, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(DatabaseExceptionHandler.class)
	public ResponseEntity<BlogError>dbError(DatabaseExceptionHandler ex){
		BlogError blogError = new BlogError();
		blogError.setErrorMessage(ex.getMessage());
		blogError.setErrorCode(ex.getStatusCode());
		return new ResponseEntity<BlogError>(blogError, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(CommentsExceptionHandler.class)
	public ResponseEntity<BlogError>emptyComment(CommentsExceptionHandler ex){
		BlogError blogError = new BlogError();
		blogError.setErrorMessage(ex.getMessage());
		blogError.setErrorCode(ex.getStatusCode());
		return new ResponseEntity<BlogError>(blogError, HttpStatus.NOT_FOUND);
	}
}
