package com.example.demo;

import com.example.demo.dao.StudentDAO;
import com.example.demo.dao.StudentImpl;
import com.example.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication(
		scanBasePackages = { "com.example.demo", "reza.jac" },
		excludeName = { "com.codetinkering.IgnoreMe" }
//		exclude = { IgnoreMe.class }
)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
//			getAll(studentDAO);
//			getStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO){
		Student studentEntity =  Student
				.builder()
				.firstName("reza")
				.lastName("shalchi")
				.email("r.s@jac.com")
				.build();
		studentDAO.save(studentEntity);
	}

	private void createMultipleStudent(StudentDAO studentDAO){
		Student studentEntity1 =  Student
				.builder()
				.firstName("A")
				.lastName("aaaa")
				.email("r.s@jac.com")
				.build();

		Student studentEntity2 =  Student
				.builder()
				.firstName("B")
				.lastName("bbbb")
				.email("r.s@jac.com")
				.build();

		Student studentEntity3 =  Student
				.builder()
				.firstName("C")
				.lastName("cccc")
				.email("r.s@jac.com")
				.build();

		studentDAO.save(studentEntity1);
		studentDAO.save(studentEntity2);
		studentDAO.save(studentEntity3);
	}

	private void readStudent(StudentDAO studentDAO){
		Student student = studentDAO.findById(9);
		System.out.println(student);
	}

	private void getAll(StudentDAO studentDAO){
		List<Student> allStudents = studentDAO.findAll();
		for(Student st: allStudents){
			System.out.println(st);
		}
	}

	private void getStudentsByLastName(StudentDAO studentDAO){
		studentDAO.findByLastName("shalchi").forEach(System.out::println);
	}

	private void updateStudent(StudentDAO studentDAO){
		// retrieve the student based on the id: primary key
		int studentId = 1;
		Student student = studentDAO.findById(studentId);
		// do a change
		student.setFirstName("ROSE");
		//update the student
		studentDAO.update(student);
		//display the updated student

		System.out.println("updated student" + student);
	}

	private void deleteStudent(StudentDAO studentDAO){
		int id = 4;
		studentDAO.delete(id);
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		int deleted  = studentDAO.deleteAll();
		System.out.println("ALL are gone !!! "+ deleted);
	}
}
