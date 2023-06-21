package com.javaproject.Student.Management;

import com.javaproject.Student.Management.entity.Student;
import com.javaproject.Student.Management.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentManagementApplication  {
	private final StudentRepo studentRepo;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

}
