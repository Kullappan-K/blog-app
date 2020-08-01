package com.blog.exception;

public class DatabaseExceptionHandler extends Exception{
	
    private int statusCode;
	
	public DatabaseExceptionHandler(String message, int statusCode) {
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
