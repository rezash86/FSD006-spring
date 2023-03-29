package com.jac.mvcproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jac.mvcproject.dto.StudentGetOutputDTO;
import com.jac.mvcproject.model.Student;
import com.jac.mvcproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    private final ObjectMapper mapper;

    @Autowired
    public StudentController(StudentService studentService, ObjectMapper mapper) {
        this.studentService = studentService;
        this.mapper = mapper;
    }

    @GetMapping("")
    public ResponseEntity<List<StudentGetOutputDTO>> getAllStudents(){
        var studentList = studentService.getAllStudents();
        var result = getStudentOutputDTO(studentList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<StudentGetOutputDTO>> searchStudents(@RequestParam String lastName){
        var studentList = studentService.getStudentByLastName(lastName);
        var result = getStudentOutputDTO(studentList);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private List<StudentGetOutputDTO> getStudentOutputDTO(List<Student> studentList){
        List<StudentGetOutputDTO> result = new ArrayList<>(studentList.size());
        for(Student student: studentList){
            result.add(mapper.convertValue(student, StudentGetOutputDTO.class));
        }
        return result;
    }
}
