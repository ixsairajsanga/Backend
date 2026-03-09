package org.example.repository;


import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public void getUser(){
        System.out.println("Fetching user from DB");
    }

    public void saveUser(){
        System.out.println("Saved the user");
    }

}