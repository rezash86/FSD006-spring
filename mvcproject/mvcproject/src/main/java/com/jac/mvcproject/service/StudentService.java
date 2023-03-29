package com.jac.mvcproject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.mvcproject.entity.StudentEntity;
import com.jac.mvcproject.model.Student;
import com.jac.mvcproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final ObjectMapper objectMapper;


    @Autowired
    public StudentService(StudentRepository studentRepository, ObjectMapper objectMapper) {
        this.studentRepository = studentRepository;
        this.objectMapper = objectMapper;
    }

    public List<Student> getAllStudents(){
        List<StudentEntity> studentEntities =  studentRepository.findAll();
        return mapper(studentEntities);
    }

    public List<Student> getStudentByLastName(String lastName){
        var result = studentRepository.findByLastName(lastName);
        return mapper(result);
    }

    private List<Student> mapper(List<StudentEntity> studentEntities){
        List<Student> students = new ArrayList<>(studentEntities.size());
        for(StudentEntity entity: studentEntities){
            students.add(objectMapper.convertValue(entity, Student.class));
        }

        return students;
    }
}

