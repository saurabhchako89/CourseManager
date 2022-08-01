package com.poc.learnspringboot.courses.controller;

import com.poc.learnspringboot.courses.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        return Arrays.asList(new Course(1,"Learn Microservices","Saurabh"));
    }
}
