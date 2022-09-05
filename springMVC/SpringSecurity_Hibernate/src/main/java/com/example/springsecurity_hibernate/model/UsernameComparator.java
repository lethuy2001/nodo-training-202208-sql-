package com.example.springsecurity_hibernate.model;

import java.util.Comparator;

public class UsernameComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.getUsername().compareTo(o2.getUsername()) ;
    }
}
