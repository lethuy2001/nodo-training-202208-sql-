package com.example.quanlysach.responsitory;

import com.example.quanlysach.entity.BanDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BanDocService extends JpaRepository<BanDoc , Integer > {

    @Query("select bd from BanDoc bd order by bd.ID desc ")
    List<BanDoc> findBanSort() ;

    @Query("select bd from BanDoc bd where bd.TEN like :name and bd.DIACHI like :add")
    List<BanDoc> findFilterBanDoc(@Param("name") String name , @Param("add") String add ) ;

}
