package com.javaproject.Student.Management.repo;

import com.javaproject.Student.Management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
