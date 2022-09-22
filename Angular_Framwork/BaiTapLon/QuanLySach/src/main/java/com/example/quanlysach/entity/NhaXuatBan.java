package com.example.quanlysach.entity;

import lombok.Data;
import org.aspectj.weaver.loadtime.Agent;

import javax.persistence.*;

@Data
@Entity
@Table( name = "LM_THUY_NHAXUATBAN")
public class NhaXuatBan {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sachSeq", sequenceName = "LM_THUY_NHAXUATBAN_SEQ")
    private Integer ID ;

    private String MA ;
    private String TEN ;
    private Integer TRANGTHAI ;
    private String DIACHI;
    private String  MOTA ;
}
