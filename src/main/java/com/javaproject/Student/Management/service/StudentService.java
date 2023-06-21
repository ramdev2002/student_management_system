package com.javaproject.Student.Management.service;

import com.javaproject.Student.Management.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student saveStudent(Student student);

    Student getStudentById(Integer id);

    Student updateStudent(Student student);
    void deteleStudentById(Integer id);
}
