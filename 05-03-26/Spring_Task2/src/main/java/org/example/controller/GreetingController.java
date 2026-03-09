package org.example.controller;

import org.example.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GreetingController {

    @Autowired
    public  GreetingService greetingService;

   public void display(){
       System.out.println(greetingService.greet("Hello Good evening"));
    }



}
