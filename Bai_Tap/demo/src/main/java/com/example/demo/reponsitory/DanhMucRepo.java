package com.example.demo.reponsitory;

import com.example.demo.entity.Danhmuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DanhMucRepo extends JpaRepository<Danhmuc , Integer > {

    @Query("select dm from Danhmuc dm where dm.loaidanhmuc.id = :id ")
    List<Danhmuc> getAllByLoaiDanhMuc(@Param("id") Integer id ) ;

    @Query("select dm from Danhmuc dm where dm.code like %:code% and dm.name like %:name% and " +
            "dm.status = :status and dm.loaidanhmuc.id = :id")
    List<Danhmuc> getAllByMaAndTen( @Param("code") String code , @Param("name") String name ,
                                    @Param("status") Integer status , @Param("id") Integer id ) ;

}
