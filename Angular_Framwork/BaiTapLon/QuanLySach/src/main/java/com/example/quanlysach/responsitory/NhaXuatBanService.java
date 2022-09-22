package com.example.quanlysach.responsitory;

import com.example.quanlysach.entity.NhaXuatBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NhaXuatBanService extends JpaRepository<NhaXuatBan , Integer > {

    @Query("select nxb from NhaXuatBan nxb where nxb.TRANGTHAI = 1 or nxb.TRANGTHAI = 2")
    List<NhaXuatBan> findAllNXB() ;

    @Query("select nxb from NhaXuatBan nxb order by nxb.ID desc ")
    List<NhaXuatBan> findAllSort() ;

    @Query("select nxb from NhaXuatBan nxb where nxb.TRANGTHAI = 1 ")
    List<NhaXuatBan> findAllActive() ;
}
