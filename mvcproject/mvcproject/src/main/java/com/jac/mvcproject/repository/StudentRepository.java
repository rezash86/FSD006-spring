package com.jac.mvcproject.repository;

import com.jac.mvcproject.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    List<StudentEntity> findByLastName(String lastName);

    @Query("SELECT s FROM StudentEntity s WHERE email NOT like '%gmail%' ")
    List<StudentEntity> findNotGmailUsers();
}
