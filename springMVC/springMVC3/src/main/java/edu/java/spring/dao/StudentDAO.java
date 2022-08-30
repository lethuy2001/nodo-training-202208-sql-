package edu.java.spring.dao;

import edu.java.spring.controller.Student;

import java.util.List;

public interface StudentDAO {
    public void insert(Student student ) ;
    public List<Student>  list() ;
    public void DeleteById( int id ) ;

    public Student FindById( Integer id ) ;
    public void Update( Student student ) ;

    public List<Student> findByName( String name ) ;
}
