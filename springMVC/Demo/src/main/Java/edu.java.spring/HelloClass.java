package edu.java.spring;

import org.springframework.beans.factory.DisposableBean;

import java.util.List;

public class HelloClass implements DisposableBean {
    String message ;
    private List<JavaClass> clazz ;

    public String getMessage(){
        return message ;
    }
    public HelloClass(){
        this.message = "From Constructor: Say hello everyone!" ;
    }

    public HelloClass( HelloClass clazz ){
        this.message = clazz.message ;
    }
    public HelloClass( int person ){
        this.message = "From constructor: Say hello to  " + person + " perspons"  ;
    }

    public void initMessage(){
        System.out.println("Calling init method...");
        this.message = "From init method: Say hello bean!";
    }

    public void release(){
        this.message = null ;
        System.out.println("Message is null");
    }

    public void printMessage(){
        System.out.println("Your message: " + message);
    }

    @Override
    public void destroy() throws Exception {
        this.message = null ;
        System.out.println("Message is null");
    }

    public void setMessage(String message) {
        this.message = "Call From Setter: " + message ;
    }

    public List<JavaClass> getClazz() {
        return clazz;
    }

    public void setClazz(List<JavaClass> clazz) {
        this.clazz = clazz;
    }
}