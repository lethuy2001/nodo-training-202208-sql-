package com.example.quanlysach.restController;

import com.example.quanlysach.entity.BanDoc;
import com.example.quanlysach.responsitory.BanDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("BanDoc")
public class BanDocRestController {
    @Autowired
    BanDocService bd ;

    @GetMapping("")
    public ResponseEntity<List<BanDoc>> findAll() {
        return ResponseEntity.ok( bd.findAll() );
    }

    @GetMapping("find/{name}/{add}")
    public ResponseEntity<List<BanDoc>> findFilter( @PathVariable("name") String name , @PathVariable("add") String add  ) {
        System.out.println("'%'"+ name + "'%'" + "  " + "'%'" + add + "'%'");
        return ResponseEntity.ok( bd.findFilterBanDoc( '%' + name + '%', '%' + add + '%' ) );
    }

    @PostMapping("")
    public ResponseEntity<BanDoc> create( @RequestBody BanDoc banDoc ){
        banDoc.setMA( "BD" + (bd.findBanSort().get(0).getID() + 1 ) );
        banDoc.setNGAYTAOTAIKHOAN( new Date() );
        return ResponseEntity.ok(bd.save(banDoc)) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<BanDoc> update( @PathVariable("id") Integer id , @RequestBody BanDoc banDoc ){
        if( !bd.existsById(id) ){
            return ResponseEntity.notFound().build() ;
        }
        return ResponseEntity.ok(bd.save(banDoc)) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete( @PathVariable("id") Integer id  ){
        if( !bd.existsById(id) ){
            return ResponseEntity.notFound().build() ;
        }

        bd.deleteById(id);
        return null ;
    }
}
