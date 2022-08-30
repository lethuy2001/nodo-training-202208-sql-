package edu.java.spring.controller;

import edu.java.spring.dao.StudentDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClazzController {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml") ;
    StudentDAO students = (StudentDAO) context.getBean("studentJdbcDAO") ;

    @RequestMapping(value = "/clazz/xml" , produces = {MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody JavaClass viewInXml () {
        return new JavaClass( students.list() ) ;
    }

    @RequestMapping(value = "/clazz/json" , produces = {MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody JavaClass viewInJSON () {
        return new JavaClass( students.list() ) ;
    }
}
