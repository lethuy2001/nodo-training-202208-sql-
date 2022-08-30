package com.example.springsecurity_hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:config.xml")
public class SpringSecurityHibernateApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringSecurityHibernateApplication.class, args);
        ctx.start();
    }

}
