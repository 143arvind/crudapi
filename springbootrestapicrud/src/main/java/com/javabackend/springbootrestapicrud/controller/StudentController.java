package com.javabackend.springbootrestapicrud.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabackend.springbootrestapicrud.entity.Student;
import com.javabackend.springbootrestapicrud.service.StudentService;
/*
  POST   http://localhost:9095/api/student/post: Create a new student (provide JSON body).
  GET    http://localhost:9095/api/student/get/: Retrieve a specific student by ID.
  GET    http://localhost:9095/api/student/getall: Retrieve all students.
  PUT    http://localhost:9095/api/student/put/{id}: Update an existing student (provide JSON body).
  DELETE http://localhost:9095/api/student/delete/{id}: Delete a student by ID
 */

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
    private StudentService studentService;
	
	@PostMapping("/post")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
	
	@GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
	
	 @GetMapping("/getall")
	 public ResponseEntity<List<Student>> getAllStudents() {
	 List<Student> students = studentService.getAllStudents();
	        return new ResponseEntity<>(students, HttpStatus.OK);
	    }
	@PutMapping("/put/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) {
	        studentService.deleteStudent(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}
