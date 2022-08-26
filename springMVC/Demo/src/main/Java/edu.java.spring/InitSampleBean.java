package edu.java.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;

public class InitSampleBean implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        HelloClass bean = new HelloClass() ;
        System.out.println("Before initialization: "  + bean );
        return bean ;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        HelloClass bean = new HelloClass() ;
        System.out.println("After initialization: " + bean );
        return  bean;
    }
}
