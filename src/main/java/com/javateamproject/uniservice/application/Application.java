package com.javateamproject.uniservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 18.02.2018
 *
 * @author Andrey Romanov (steampart@gmail.com)
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan("com.javateamproject.uniservice")
@EnableJpaRepositories(basePackages = "com.javateamproject.uniservice.repositories")
@EntityScan(basePackages = "com.javateamproject.uniservice.models")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
