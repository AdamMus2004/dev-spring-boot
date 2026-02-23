package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @GetMapping("/students")
    public List<Student> getStudents() {
        return new ArrayList<>(List.of(
                new Student("Michael","Jackson"),
                new Student("Michael","Phelps"),
                new Student("Adam","Mus")
        ));

    }
}
