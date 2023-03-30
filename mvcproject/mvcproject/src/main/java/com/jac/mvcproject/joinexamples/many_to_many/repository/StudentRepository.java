package com.jac.mvcproject.joinexamples.many_to_many.repository;

import com.jac.mvcproject.joinexamples.many_to_many.model.withnewEntity.MyStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<MyStudent, Long> {
}
