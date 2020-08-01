package com.blog.key;

import java.io.Serializable;

public class BlogKey implements Serializable{
	
	public int id;
	public String user_id;
	
	public BlogKey() {}
	
	public BlogKey(int id, String user_id) {
		super();
		this.id = id;
		this.user_id = user_id;
	}

}
