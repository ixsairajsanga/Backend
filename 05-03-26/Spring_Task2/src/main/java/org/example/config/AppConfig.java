package org.example.config;

import org.example.controller.GreetingController;
import org.example.service.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "org.example")
public class AppConfig {
    @Bean
   public GreetingService greetingService(){
        return new GreetingService();
    }


    @Bean
    public GreetingController greetingController(){
        return new GreetingController();
    }
}
