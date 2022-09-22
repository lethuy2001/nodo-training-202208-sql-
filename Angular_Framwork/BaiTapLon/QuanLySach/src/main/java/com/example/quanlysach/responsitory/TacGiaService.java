package com.example.quanlysach.responsitory;

import com.example.quanlysach.entity.TacGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TacGiaService extends JpaRepository<TacGia , Integer > {

}
