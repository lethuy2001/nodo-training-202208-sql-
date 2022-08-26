package edu.java.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean(name = "bean2")
    @Scope("singleton")
    public HelloClass getHelloBean() {
        HelloClass bean = new HelloClass() ;
        bean.message = "Xin chào lớp học java" ;
        return bean;
    }
}
