package com.example.springsecurity_hibernate.dao;

import com.example.springsecurity_hibernate.model.User;

import java.util.List;

public interface UserDao {
    public void insert(User user) ;

    public List<User> list(Integer id) ;

    public void delele( int id ) ;

    public void update ( User user ) ;

    public List<User> listUserByGroup( int groupId );
}
