package com.poc.learnspringboot.courses.dao;

import com.poc.learnspringboot.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {


}

