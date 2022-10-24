package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "danhmuc")
@Data
public class Danhmuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", length = 10)
    private String code;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "nhom", length = 30)
    private String nhom;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;

    @Column(name = "use_create", length = 20)
    private String useCreate;

    @Column(name = "status")
    private Integer status;

    @JoinColumn(name = "ldm_id")
    @ManyToOne
    private Loaidanhmuc loaidanhmuc ;
}