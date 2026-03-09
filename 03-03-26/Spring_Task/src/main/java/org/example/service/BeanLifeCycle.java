package org.example.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;


@Component
public class BeanLifeCycle implements InitializingBean, DisposableBean {

    private static final Logger logger =Logger.getLogger(BeanLifeCycle.class.getName());

   private UserRepository repo;

    public BeanLifeCycle(UserRepository repo){
        logger.info("Constructor Called");
        this.repo = repo;
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("PostConstruct Called");
    }

    @Override
    public void afterPropertiesSet(){
        logger.info("InitializingBean Called");
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("PreDestroy Called");
    }

    @Override
    public void destroy(){
        logger.info("DisposableBean destroy Called");
    }

}