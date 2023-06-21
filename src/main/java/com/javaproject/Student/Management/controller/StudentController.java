package com.javaproject.Student.Management.controller;

import com.javaproject.Student.Management.entity.Student;
import com.javaproject.Student.Management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    // Handler method to handle listing students and return model and view
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudent());
        return "students";
    }

    @GetMapping("/students/new")
    public String CreateStudentForm(Model model){
        // create Student object to hold student form data
        Student student=new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("students/edit/{id}")
    public String editStudent(@PathVariable Integer id, Model model){
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Integer id,
                                @ModelAttribute("student") Student student,Model model){

        //get student from database by id
        Student existingStudent=studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());


        //save update data
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    //handler to handle delete student request
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentService.deteleStudentById(id);
        return "redirect:/students";
    }
}
