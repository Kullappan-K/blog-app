package com.blog.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.blog.model.Comments;
import com.blog.model.Replies;
import com.blog.repository.CommentsRepository;
import com.blog.repository.ReplyRepository;
import com.blog.service.CommentService;

@Service
public class CommentsServiceImpl implements CommentService{
	
	@Autowired
	private CommentsRepository commentsRepository;
	
	@Autowired
	private ReplyRepository replyRepository;

	@Override
	public List<Object> getAllComments(int blogId) {
		Map<String, Object>resultMap = new HashMap<String, Object>();
		List<Object>resultList = new ArrayList<>();
		List<Comments>commentList = commentsRepository.getAllComments(blogId);
		if(!CollectionUtils.isEmpty(commentList)) {
		List<Integer>idList = commentList.stream().map(comment -> comment.getId()).collect(Collectors.toList());
		Map<Object, List<Replies>>replyMap = replyRepository.getReplies(idList).stream()
				.collect(Collectors.groupingBy(reply -> reply.getComment_id()));
		
		for(Comments comments : commentList) {
			resultMap.put("id", comments.getId());
			resultMap.put("blog_id", comments.getBlog_id());
			resultMap.put("author_id", comments.getAuthor_id());
			resultMap.put("comment_body", comments.getComment_body());
			resultMap.put("created_at", comments.getCreated_at());
			resultMap.put("reply_body", replyMap.get(comments.getId()) == null ? "No Reply Found" : 
				replyMap.get(comments.getId()));
			resultList.add(resultMap);
		}
		return resultList;
		}
		return resultList;
	}

	@Override
	public List<Object> getComments(int blogId, int commentId) {
		Map<String, Object>resultMap = new HashMap<String, Object>();
		List<Object>resultList = new ArrayList<>();
		List<Comments>commentList = commentsRepository.getComments(blogId, commentId);
		if(!CollectionUtils.isEmpty(commentList)) {
		List<Integer>idList = commentList.stream().map(comment -> comment.getId()).collect(Collectors.toList());
		Map<Object, List<Replies>>replyMap = replyRepository.getReplies(idList).stream()
				.collect(Collectors.groupingBy(reply -> reply.getComment_id()));
		
		for(Comments comments : commentList) {
			resultMap.put("id", comments.getId());
			resultMap.put("blog_id", comments.getBlog_id());
			resultMap.put("author_id", comments.getAuthor_id());
			resultMap.put("comment_body", comments.getComment_body());
			resultMap.put("created_at", comments.getCreated_at());
			resultMap.put("reply_body", replyMap.get(comments.getId()) == null ? "No Reply Found" : 
				replyMap.get(comments.getId()));
			resultList.add(resultMap);
		}
		return resultList;
		}
		return resultList;
	}

	@Override
	public void createComments(Comments comments) {
		commentsRepository.save(comments);
	}

	@Override
	public void createReply(Replies replies) {
		replyRepository.save(replies);
	}
}
