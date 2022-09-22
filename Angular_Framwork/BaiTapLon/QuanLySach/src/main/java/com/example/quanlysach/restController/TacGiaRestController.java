package com.example.quanlysach.restController;

import com.example.quanlysach.entity.TacGia;
import com.example.quanlysach.responsitory.TacGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class TacGiaRestController {
    @Autowired
    TacGiaService tg ;


    @GetMapping()
    public ResponseEntity<List<TacGia>> findAll(){
        return ResponseEntity.ok(tg.findAll()) ;
    }

    @PostMapping()
    public ResponseEntity<TacGia> create(@RequestBody TacGia tacGia ){
        return ResponseEntity.ok( tg.save(tacGia)) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<TacGia> update( @PathVariable("id") Integer id , @RequestBody TacGia tacGia ){
//        if(  !tg.existsById(id) ){
//            return ResponseEntity.notFound().build() ;
//        }
        return ResponseEntity.ok( tg.save(tacGia));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete ( @PathVariable("id") Integer id ){
        if( !tg.existsById(id) ){
            return ResponseEntity.notFound().build() ;
        }
        tg.deleteById(id);
        return null;
    }
}
