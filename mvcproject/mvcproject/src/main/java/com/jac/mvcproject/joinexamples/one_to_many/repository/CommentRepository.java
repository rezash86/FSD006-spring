package com.jac.mvcproject.joinexamples.one_to_many.repository;

import com.jac.mvcproject.joinexamples.one_to_many.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c WHERE c.post.id=:postId")
    List<Comment> findByPostId(@Param("postId") Long postId);
}
