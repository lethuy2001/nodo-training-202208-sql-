package com.example.springsecurity_hibernate.model;

import javax.persistence.*;
import com.example.springsecurity_hibernate.model.Group;

@Entity
public class User implements  Comparable<User> {

    private String username ;
    private String password ;
    private String email ;
    private int age ;
    private Group group ;

    public User(){

    }
    public User(String username, String password, String email, int age ) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(User o) {
        return age - o.age  ;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    //    public int getGroupId() {
//        return groupId;
//    }
//
//    public void setGroupId(int groupId) {
//        this.groupId = groupId;
//    }
}
