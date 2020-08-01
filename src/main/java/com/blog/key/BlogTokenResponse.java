package com.blog.key;

public class BlogTokenResponse {
	
	private final String jwt;

	public BlogTokenResponse(String jwt) {
		this.jwt = jwt;
	}
	public String getJwt() {
		return jwt;
	}
}
