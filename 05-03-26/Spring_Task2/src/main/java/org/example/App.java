package org.example;

import org.example.config.AppConfig;
import org.example.controller.GreetingController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingController controller=context.getBean(GreetingController.class);

        controller.display();



    }
}
