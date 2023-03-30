package com.jac.mvcproject.joinexamples.one_to_many.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
