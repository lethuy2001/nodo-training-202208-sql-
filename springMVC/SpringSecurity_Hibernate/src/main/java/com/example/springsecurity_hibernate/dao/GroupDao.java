package com.example.springsecurity_hibernate.dao;

import com.example.springsecurity_hibernate.model.Group;

import java.util.List;

public interface GroupDao  {
    public void insert(Group group );

    public List<Group> list() ;

    public void delete( int id ) ;

    public void update( Group group ) ;
}
