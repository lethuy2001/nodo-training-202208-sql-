package edu.java.spring.controller;

import edu.java.spring.dao.StudentDAO;
import edu.java.spring.dao.impl.StudentDAOImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("student")
public class StudentCtrl {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

    StudentDAOImpl dml = (StudentDAOImpl) context.getBean("studentJdbcDAO") ;

     @GetMapping("list")
    public String home() {
         return "redirect:/student/list";
     }
}
