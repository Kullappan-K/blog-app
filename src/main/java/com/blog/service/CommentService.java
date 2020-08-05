package com.blog.service;

import java.util.List;

import com.blog.model.Comments;
import com.blog.model.Replies;

public interface CommentService {
	List<Object> getAllComments(int blogId);
	List<Object> getComments(int blogId, int commentId);
	void createComments(Comments comments);
	void createReply(Replies replies);
}
