package com.poc.learnspringboot.courses.service;

import com.poc.learnspringboot.courses.dao.UserRepository;
import com.poc.learnspringboot.courses.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> listAll() {
        return repo.findAll();
    }

    public void save(User user) {
        repo.save(user);
    }

    public User get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}