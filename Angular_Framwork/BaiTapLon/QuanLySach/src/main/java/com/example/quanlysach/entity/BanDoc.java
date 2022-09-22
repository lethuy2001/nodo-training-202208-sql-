package com.example.quanlysach.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table( name = "LM_THUY_BANDOC")
public class BanDoc {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sachSeq", sequenceName = "LM_THUY_BANDOC_SEQ")
    private Integer ID ;
    private String MA ;
    private String TEN ;
    private String SDT ;
    private String DIACHI ;
    private Date NGAYSINH ;
    private Date NGAYTAOTAIKHOAN ;
    private Integer HANG ;

}
