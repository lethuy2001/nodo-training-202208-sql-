package edu.java.spring.controller;

import edu.java.spring.dao.StudentDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "clazz")
public class JavaClass {
    List<Student> students ;

    public JavaClass(List<Student> students) {
        this.students = students;
    }

    @XmlElements( @XmlElement( name = "student" , type = Student.class ))
    public List<Student> getStudents( ){
        return  students;
    }
}
