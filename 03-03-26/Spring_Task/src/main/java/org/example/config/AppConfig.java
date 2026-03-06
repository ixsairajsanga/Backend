package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

//    @Bean
//    public UserRepository userRepository(){
//        return new UserRepository();
//    }
//
//    @Bean
//    public UserService userService(){
//        return new UserService(userRepository());
//    }
//
//
//    @Bean
//    public BeanLifeCycle beanLifeCycle(){
//        return new BeanLifeCycle(userRepository());
//    }



}