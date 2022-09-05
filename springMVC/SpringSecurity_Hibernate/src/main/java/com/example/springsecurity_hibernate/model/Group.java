package com.example.springsecurity_hibernate.model;

import org.hibernate.annotations.SortComparator;
import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.util.List;
import java.util.SortedSet;

@Entity
@Table( name = "HN_GROUP" )
public class Group {
    private int id ;
    private String name ;

    private List<User> users ;

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name= "id" , unique = true , nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "name" , nullable = false , length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany( cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "groupId")
//    @SortNatural
    @SortComparator(UsernameComparator.class)
    public List<User> getUsers() {
        return users;
    }
    public void setUsers( List<User> users) {
        this.users = users;
    }
}
