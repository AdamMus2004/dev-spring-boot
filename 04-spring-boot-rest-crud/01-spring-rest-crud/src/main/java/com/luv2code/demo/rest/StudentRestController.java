package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;


    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Michael","Jackson"));
        theStudents.add(new Student("Michael","Phelps"));
        theStudents.add(new Student("Adam","Mus"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }


    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {


        if (id>= theStudents.size() || id<0) {
            throw new StudentNotFoundException("Student id not found: "+ id);
        }
        return theStudents.get(id);
    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {

        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());

        error.setMessage(exception.getMessage());

        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleAnyException(Exception exception) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setTimeStamp(System.currentTimeMillis());

        error.setMessage(exception.getMessage());

        error.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
