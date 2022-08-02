package com.poc.learnspringboot.courses.service;

import java.util.List;

import com.poc.learnspringboot.courses.dao.CourseRepository;
import com.poc.learnspringboot.courses.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseService {

    @Autowired
    private CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> listAll() {
        return repo.findAll();
    }

    public void save(Course product) {
        repo.save(product);
    }

    public Course get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
