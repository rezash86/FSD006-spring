package com.jac.mvcproject.joinexamples.many_to_many.repository;

import com.jac.mvcproject.joinexamples.many_to_many.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
