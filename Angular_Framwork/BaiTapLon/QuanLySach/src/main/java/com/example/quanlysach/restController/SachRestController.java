package com.example.quanlysach.restController;

import com.example.quanlysach.entity.NhaXuatBan;
import com.example.quanlysach.entity.Sach;
import com.example.quanlysach.responsitory.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class SachRestController {

    @Autowired
    SachService s ;

    @GetMapping("")
    public ResponseEntity<List<Sach>> findAll(){
        return ResponseEntity.ok( s.findAll())  ;
    }

    @PostMapping("")
    public Sach create( @RequestBody Sach a ) {
        a.setMA( "S" + (s.findAllSort().get(0).getID() + 1 ) ) ;
        a.setSOLUONGCON( a.getTONGSOSACH() );
        return s.save( a ) ;
    }

    @PutMapping( "/{id}")
    public ResponseEntity<Sach> update( @PathVariable("id") Integer id  , @RequestBody Sach a ){
        if( !s.existsById(id )){
            return ResponseEntity.notFound().build() ;
        }

        return ResponseEntity.ok( s.save(a) );
    }
}
