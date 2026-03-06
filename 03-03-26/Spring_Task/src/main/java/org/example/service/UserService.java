package org.example.service;


import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repo;

    public UserService(UserRepository repo){
        this.repo = repo;
    }

    public void processUser(){
        repo.getUser();
        System.out.println("Processing user");
    }

}