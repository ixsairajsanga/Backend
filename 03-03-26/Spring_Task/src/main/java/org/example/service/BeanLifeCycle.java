package org.example.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


@Component
public class BeanLifeCycle implements InitializingBean, DisposableBean {


   private UserRepository repo;

    public BeanLifeCycle(UserRepository repo){
        System.out.println("Constructor Called");
        this.repo = repo;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("PostConstruct Called");
    }

    @Override
    public void afterPropertiesSet(){
        System.out.println("InitializingBean Called");
    }

    public void processUser(){
        repo.getUser();
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("PreDestroy Called");
    }

    @Override
    public void destroy(){
        System.out.println("DisposableBean destroy Called");
    }

}