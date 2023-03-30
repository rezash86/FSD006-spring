package com.jac.mvcproject.joinexamples.many_to_many.repository;

import com.jac.mvcproject.joinexamples.many_to_many.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
