package com.example.demo.controller;

import com.example.demo.entity.Loaidanhmuc;
import com.example.demo.service.LoaiDanhMucService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("loaidanhmuc")
public class LoaiDanhMucController {

    private final LoaiDanhMucService loaiDanhMucService ;

    public LoaiDanhMucController( LoaiDanhMucService loaiDanhMucService ){
        this.loaiDanhMucService = loaiDanhMucService ;
    }

    @GetMapping("")
    public ResponseEntity<List<Loaidanhmuc>> getAll( ){
        return ResponseEntity.ok( this.loaiDanhMucService.getAll()) ;
    }

    @PostMapping("")
    public ResponseEntity<Loaidanhmuc> create ( @RequestBody Loaidanhmuc loaidanhmuc ){
        return ResponseEntity.ok( this.loaiDanhMucService.create(loaidanhmuc) );
    }

    @PutMapping("{id}")
    public ResponseEntity<Loaidanhmuc> update( @PathVariable("id") Integer id, @RequestBody Loaidanhmuc loaidanhmuc ){
        return ResponseEntity.ok( this.loaiDanhMucService.update(loaidanhmuc)) ;
    }

    @GetMapping("find")
    public ResponseEntity<List<Loaidanhmuc>> getByMaAndName ( @RequestParam(value = "code" , defaultValue = "" ) String code ,
                                 @RequestParam(value = "name" , defaultValue = "") String name ,
                                 @RequestParam(value = "status" , defaultValue = "" ) Integer status )  {
        return ResponseEntity.ok( this.loaiDanhMucService.findByMaAndName( code , name , status ) );
    }
}
