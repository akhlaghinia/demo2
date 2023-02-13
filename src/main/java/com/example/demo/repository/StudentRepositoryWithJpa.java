package com.example.demo.repository;

import com.example.demo.model.jpa.Student;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jdk.jfr.StackTrace;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.example.demo.model.jpa.QStudent.student;

@Repository
public class StudentRepositoryWithJpa {
    @Autowired
    private JPAQueryFactory queryFactory;

    public List<Student> findAll() {
        return queryFactory.selectFrom(student).fetch();
    }

    public Student findById(Long id) {
        return queryFactory
                .selectFrom(student)
                .where(student.id.eq(id))
                .fetch().get(0);
    }

    public boolean deleteById(Long id) {
        try {
            queryFactory.delete(student).where(student.id.eq(id));
            return true;
            } catch (Exception e){
            e.printStackTrace();
            return false;
            }
        }
        public Student updateStudent (Student s){
        queryFactory.update(student)
                .set(student.lastName, s.getLastName())
                .set(student.firstName, s.getFirstName())
                .where(student.id.eq(s.getId()))
                .execute();
        return findById(s.getId());
    }
    }
