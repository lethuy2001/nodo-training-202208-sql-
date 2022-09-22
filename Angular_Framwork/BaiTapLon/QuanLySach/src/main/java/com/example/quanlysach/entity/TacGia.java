package com.example.quanlysach.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table( name = "LM_THUY_TACGIA")
public class TacGia {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sachSeq", sequenceName = "LM_THUY_TACGIA_SEQ")
    private Integer ID ;
    private String MA ;
    private String TEN ;
    private String SDT ;
    private String DIACHI ;
    private String MOTA ;
}
