package com.example.restapi.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.Entity.Student;
import com.example.restapi.Repository.StudentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;





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

    //get student based on id
    //localhost:8080/students/1
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        return student;
    }

    //create student
    //localhost:8080/student/add
    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student){
        repo.save(student);
    }

    //update student
    @PutMapping("student/update/{id}")
    public Student updateStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        student.setName("poonam");
        student.setPercentage(82);
        repo.save(student);
        return student;
    }

    //delete a student
    @DeleteMapping("/student/delete/{id}")
    public void deleteStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        repo.delete(student);
    }
    
}
