package edu.java.spring;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {
    private final Logger logger = Logger.getLogger(HelloWorld.class) ;
    private HelloClass clazz ;
    String message ;

    @Required
    public void setMessage( String value ){
        this.message = value ;
    }

//    public HelloWorld( String name , HelloClass clazz ){
//        this.message = "From HelloWorld contructor: " + name + " : " + clazz.getMessage();
//    }

    public void sayHello(){
        clazz.printMessage();
        logger.info("From Hello world: " + message );
    }

}
