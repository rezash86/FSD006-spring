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
		return runner -> createStudent(studentDAO);
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
}
