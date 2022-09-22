package com.example.websocket.dao;

import com.example.websocket.model.User;

import java.util.List;

public interface UserDao {
    public String insert(User user) ;

    public String delete( String name ) ;

    public void Update( User user ) ;

    public List<User> findAll( );

    public User getByOne( String name ) ;
}
