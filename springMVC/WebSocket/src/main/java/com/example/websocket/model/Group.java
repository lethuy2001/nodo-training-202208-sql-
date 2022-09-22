package com.example.websocket.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "HN_GROUP" , uniqueConstraints = { @UniqueConstraint( columnNames = {"id"})})
public class Group {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id ;

    @Column( name = "name")
    private String name ;

}
