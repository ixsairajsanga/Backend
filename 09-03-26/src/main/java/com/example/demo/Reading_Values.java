package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Reading_Values {

    @Value("${msg}")
    private String Message;

   @Value("${instapass}") private int pass;
    @PostConstruct
    public void printAppName(){
        System.out.println("Application Name "+Message);
        System.out.println(pass);
    }


}
