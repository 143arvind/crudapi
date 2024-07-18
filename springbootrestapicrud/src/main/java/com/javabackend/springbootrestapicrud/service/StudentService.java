package com.javabackend.springbootrestapicrud.service;

import java.util.List;

import com.javabackend.springbootrestapicrud.entity.Student;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
