package com.javabackend.springbootrestapicrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Student {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	    
	private String name;
	private int age;
    private String email;
    public void setId(Long id) {
        this.id = id;
    }
}
