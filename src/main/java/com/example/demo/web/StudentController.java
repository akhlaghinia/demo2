package com.example.demo.web;

import com.example.demo.model.jpa.Student;
import com.example.demo.model.sql.TbStudent;
import com.example.demo.service.StudentService;
import jdk.jfr.StackTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@ResponseBody
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<TbStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/v2/students")
    public List<Student> getAllStudentsWithJpa() {
        return studentService.getAllStudentsWithJpa();
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student s) {
        return (studentService.updateStudent(s));
    }

    @DeleteMapping("/students/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return (studentService.deleteById(id));
    }
}
