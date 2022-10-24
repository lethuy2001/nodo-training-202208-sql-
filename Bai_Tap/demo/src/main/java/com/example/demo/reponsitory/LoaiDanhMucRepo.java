package com.example.demo.reponsitory;

import com.example.demo.entity.Loaidanhmuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface LoaiDanhMucRepo extends JpaRepository<Loaidanhmuc , Integer > {

    @Query(" select lm from Loaidanhmuc lm where lm.code like %:code% and lm.name like %:name% and lm.status = :status  ")
    List<Loaidanhmuc> findByNameOrMa(@Param("code") String code , @Param("name") String name , @Param("status") Integer status ) ;
}
