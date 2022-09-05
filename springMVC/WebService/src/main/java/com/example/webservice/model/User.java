package com.example.webservice.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "HN_USER" , uniqueConstraints = {@UniqueConstraint(columnNames = "username")})
public class User {
    @Id
    @Column(name = "username")
    private String username ;

    @Column(name = "password")
    private String password ;

    @Column(name = "email")
    private String email ;

    @Column(name = "age")
    private int age;

    @Column(name = "groupId")
    private int groupId ;
}
