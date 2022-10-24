package com.example.demo.controller;

import com.example.demo.entity.Danhmuc;
import com.example.demo.service.DanhMucService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("danhmuc")
public class DanhMucController {

    private final DanhMucService danhMucService ;

    public DanhMucController ( DanhMucService danhMucService ){
        this.danhMucService = danhMucService ;
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Danhmuc>> getAll( @PathVariable("id") Integer id  ){
        return ResponseEntity.ok( this.danhMucService.getAll(id) ) ;
    }

    @PostMapping("")
    public ResponseEntity<Danhmuc> create( @RequestBody Danhmuc danhmuc ){
        return ResponseEntity.ok( this.danhMucService.create(danhmuc) );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Danhmuc> update( @RequestBody Danhmuc danhmuc ){
        return ResponseEntity.ok( this.danhMucService.update(danhmuc) );
    }

    @GetMapping("find")
    public ResponseEntity<List<Danhmuc>> findMaAndTen( @RequestParam(name = "code" , defaultValue = "") String code ,
                                                 @RequestParam(name = "name" , defaultValue = "") String name ,
                                                 @RequestParam(name = "status" , defaultValue = "") Integer status ,
                                                 @RequestParam(name = "id" , defaultValue = "") Integer id ){
        return ResponseEntity.ok( this.danhMucService.findByMaAndName(code, name, status, id) ) ;
    }

}
