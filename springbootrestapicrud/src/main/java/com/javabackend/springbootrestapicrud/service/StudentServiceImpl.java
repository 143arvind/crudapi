package com.javabackend.springbootrestapicrud.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabackend.springbootrestapicrud.entity.Student;
import com.javabackend.springbootrestapicrud.exception.ResourceNotFoundException;
import com.javabackend.springbootrestapicrud.repo.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {
	 @Autowired
	 private StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            throw new ResourceNotFoundException("Student not found with id " + id);
        }
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		// TODO Auto-generated method stub
		 Optional<Student> optionalExistingStudent = studentRepository.findById(id);
	        if (optionalExistingStudent.isPresent()) {
	            student.setId(id);  // Ensure the ID is set for update
	            return studentRepository.save(student);
	        } else {
	            throw new ResourceNotFoundException("Student not found with id " + id);
	        }
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		 if (studentRepository.existsById(id)) {
	            studentRepository.deleteById(id);
	        } else {
	            throw new ResourceNotFoundException("Student not found with id " + id);
	        }
	    
	}

}
