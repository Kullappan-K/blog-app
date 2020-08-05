package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blog.key.CommentKey;
import com.blog.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, CommentKey>{

	@Query(value = "select * from comments cm where cm.blog_id = ?1", nativeQuery = true)
	List<Comments>getAllComments(int blogId);
	
	@Query(value = "select * from comments cm where cm.blog_id = ?1 and cm.id = ?2", nativeQuery = true)
	List<Comments>getComments(int blogId, int commentId);
}
