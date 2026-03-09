package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Reading_Values {

    @Value("${app.name}")
    private String appName;

    @PostConstruct
    public void printAppName(){
        System.out.println("Application Name "+appName);
    }


}
