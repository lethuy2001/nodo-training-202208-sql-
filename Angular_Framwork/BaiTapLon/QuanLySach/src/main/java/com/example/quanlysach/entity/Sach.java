package com.example.quanlysach.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table( name = "LM_THUY_SACH")
public class Sach {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sachSeq", sequenceName = "LM_THUY_SACH_SEQ")
    private Integer ID ;
    private String MA ;
    private String TEN ;

    @ManyToOne
    @JoinColumn( name = "ID_NXB ")
    private NhaXuatBan nhaXuatBan ;

    @ManyToOne
    @JoinColumn(name = "ID_TACGIA")
    private TacGia tacGia ;

    private String CHUDE ;
    private Date NAMSANXUAT ;
    private String MOTA ;
    private Integer  SOLUONGCON ;
    private Integer SOLUONGMUON ;
    private Integer TONGSOSACH ;
}
