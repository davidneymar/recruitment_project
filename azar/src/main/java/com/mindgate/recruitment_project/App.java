package com.mindgate.recruitment_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("com.mindgate")
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "program Start" );
        SpringApplication.run(App.class, args);
        System.out.println("program End");
    }
}
