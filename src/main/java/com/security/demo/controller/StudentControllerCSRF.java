package com.security.demo.controller;

import com.security.demo.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentControllerCSRF {

    public List<Student> studentList = new ArrayList<>(List.of(
            new Student(1, "Ishan", 20),
            new Student(2, "Prasik", 30),
            new Student(3, "Ruturaj", 40)
    ));

    @GetMapping("/token")
    public CsrfToken getCSRFToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
      return studentList;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        studentList.add(student);
        return student;
    }

}
