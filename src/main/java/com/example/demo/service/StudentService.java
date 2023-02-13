package com.example.demo.service;

import com.example.demo.model.jpa.Student;
import com.example.demo.model.sql.TbStudent;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.StudentRepositoryWithJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentRepositoryWithJpa studentRepositoryWithJpa;

    @Transactional
    public List<TbStudent> getAllStudents() {
        var students = studentRepository.findAll();
        students.forEach(tbStudent -> System.out.println(tbStudent.getFirstname()));
        return students;
    }

    @Transactional
    public List<Student> getAllStudentsWithJpa() {
        var students = studentRepositoryWithJpa.findAll();
        return students;
    }
    @Transactional
    public Student updateStudent(Student s){
        return(studentRepositoryWithJpa.updateStudent(s));
    }
    @Transactional
    public boolean deleteById(Long id){
        return (studentRepositoryWithJpa.deleteById(id));
    }
    //please add update and insert and delete methods
}
