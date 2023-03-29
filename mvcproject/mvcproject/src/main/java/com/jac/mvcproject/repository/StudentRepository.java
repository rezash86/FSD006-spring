package com.jac.mvcproject.repository;

import com.jac.mvcproject.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findByLastName(String lastName);
}
