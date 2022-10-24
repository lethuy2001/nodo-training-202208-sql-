package com.example.demo.service;

import com.example.demo.entity.Loaidanhmuc;

import java.util.List;

public interface LoaiDanhMucService {

    List<Loaidanhmuc> getAll() ;

    Loaidanhmuc create( Loaidanhmuc loaidanhmuc ) ;

    Loaidanhmuc update( Loaidanhmuc loaidanhmuc ) ;

    List<Loaidanhmuc> findByMaAndName( String code , String name , Integer id ) ;
}
