package com.example.demo.service;

import com.example.demo.entity.Danhmuc;
import com.example.demo.entity.Loaidanhmuc;

import java.util.List;

public interface DanhMucService {

    List<Danhmuc> getAll( Integer id ) ;

    Danhmuc create( Danhmuc danhmuc ) ;

    Danhmuc update( Danhmuc danhmuc ) ;

    List<Danhmuc> findByMaAndName(String code , String name , Integer status , Integer id ) ;
}
