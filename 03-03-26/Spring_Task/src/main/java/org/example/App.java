package org.example;


/**
 * Hello world!
 *
 */

import org.example.config.AppConfig;
import org.example.service.BeanLifeCycle;
import org.example.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService service = context.getBean(UserService.class);

        BeanLifeCycle cycle=context.getBean(BeanLifeCycle.class);

        service.processUser();
        context.close();
    }
}