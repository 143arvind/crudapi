package com.javabackend.springbootrestapicrud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabackend.springbootrestapicrud.entity.Student;
import org.springframework.stereotype.Repository;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
