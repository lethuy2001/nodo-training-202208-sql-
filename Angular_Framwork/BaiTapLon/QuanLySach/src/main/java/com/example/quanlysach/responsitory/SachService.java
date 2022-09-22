package com.example.quanlysach.responsitory;

import com.example.quanlysach.entity.Sach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SachService extends JpaRepository<Sach , Integer > {

    @Query("select s from Sach s order by s.ID desc ")
    List<Sach> findAllSort() ;
}
