package com.example.courseprojects;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@SuppressWarnings("CheckStyle")


@SpringBootApplication
@ComponentScan(basePackages = {"controller", "service", "repository", "util"})
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        System.out.println("Farm API is running...");


    }
}