package com.example.springsecurity_hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table( name = "HN_GROUP" , uniqueConstraints = {@UniqueConstraint( columnNames = "id")})
public class Group {
    private int id ;
    private String name ;

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
}
