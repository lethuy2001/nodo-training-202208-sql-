package com.example.quanlysach.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table( name = "LM_THUY_MUONSACH")
public class MuonSach {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sachSeq", sequenceName = "LM_THUY_MUONSACH_SEQ")
    private Integer ID ;

    @ManyToOne
    @JoinColumn( name = "ID_BANDOC")
    private BanDoc banDoc ;

    @ManyToOne
    @JoinColumn( name = "ID_SACH")
    private Sach sach ;

    private Integer SOLUONG ;
    private Date NGAYGIOMUON ;
    private Date NGAYTRA;
    private Integer TRANGTHAI ;
    private String GHICHU ;
}
