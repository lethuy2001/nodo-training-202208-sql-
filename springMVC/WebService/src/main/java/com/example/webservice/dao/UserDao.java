package com.example.webservice.dao;

import com.example.webservice.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll() ;
    String insert(User user ) ;

    public User getByName( String username ) ;

    public void delete( String name ) ;

    public void update( User user ) ;
}
