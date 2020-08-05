package com.blog.exception;

public class CommentsExceptionHandler extends Exception{
	
    private int statusCode;
	
	public CommentsExceptionHandler(String message, int statusCode) {
		super(message);
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


}
