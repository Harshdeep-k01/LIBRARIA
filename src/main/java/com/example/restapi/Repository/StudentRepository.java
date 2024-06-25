package com.example.restapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
