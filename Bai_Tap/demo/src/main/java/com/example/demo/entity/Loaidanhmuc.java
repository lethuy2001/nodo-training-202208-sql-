package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "loaidanhmuc")
@Data
public class Loaidanhmuc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "code", length = 10)
    private String code;

    @Column(name = "name", length = 50)
    private String name;

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

    @OneToMany( mappedBy = "loaidanhmuc", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Danhmuc> list ;

}