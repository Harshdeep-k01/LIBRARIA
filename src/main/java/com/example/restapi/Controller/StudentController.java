package com.example.restapi.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.Entity.Student;
import com.example.restapi.Repository.StudentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudentController {
    @Autowired
    StudentRepository repo;

    //get all the students
    //localhost:8080/students
    @GetMapping("/students")
     public List<Student> getAllStudents(){
        List<Student> students = repo.findAll();
        return students;
    }

}
