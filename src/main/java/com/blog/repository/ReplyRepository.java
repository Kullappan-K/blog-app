package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.key.RepliesKey;
import com.blog.model.Replies;

@Repository
public interface ReplyRepository extends JpaRepository<Replies, RepliesKey>{
	
	@Query(value = "select * from replies re where re.comment_id in (:ids)", nativeQuery = true)
	List<Replies>getReplies(@Param("ids") List<Integer> commentIdList);

}
