package com.jac.mvcproject.joinexamples;

import com.jac.mvcproject.joinexamples.one_to_many.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
