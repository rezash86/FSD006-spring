package com.jac.mvcproject.joinexamples;

import com.jac.mvcproject.joinexamples.many_to_many.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepositoryWithTag extends JpaRepository<Post, Long> {
}
