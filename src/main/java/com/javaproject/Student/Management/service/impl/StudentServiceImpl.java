package com.javaproject.Student.Management.service.impl;

import com.javaproject.Student.Management.entity.Student;
import com.javaproject.Student.Management.repo.StudentRepo;
import com.javaproject.Student.Management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void deteleStudentById(Integer id) {
        studentRepo.deleteById(id);
    }


}
