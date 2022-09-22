package com.example.quanlysach.restController;

import com.example.quanlysach.entity.NhaXuatBan;
import com.example.quanlysach.responsitory.NhaXuatBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nxb")
public class NhaXuatBanController {

    @Autowired
    NhaXuatBanService nxb ;

    @GetMapping("")
    public ResponseEntity< List<NhaXuatBan>> findAll(){
        return ResponseEntity.ok( nxb.findAllNXB() )  ;
    }

    @GetMapping("/findActive")
    public ResponseEntity< List<NhaXuatBan>> findAllActive(){
        return ResponseEntity.ok( nxb.findAllActive() )  ;
    }

    @PostMapping("")
    public NhaXuatBan create( @RequestBody NhaXuatBan a ) {
        a.setMA( "PC" + (nxb.findAllSort().get(0).getID() + 1 ) ) ;
        return nxb.save( a) ;
    }

    @PutMapping( "/{id}")
    public ResponseEntity< NhaXuatBan> update( @PathVariable("id") Integer id  , @RequestBody NhaXuatBan a ){
        if( !nxb.existsById(id )){
            return ResponseEntity.notFound().build() ;
        }

        return ResponseEntity.ok( nxb.save(a) );
    }

    @PutMapping("delete/{id}")
    public ResponseEntity<NhaXuatBan> delete( @PathVariable("id") Integer id  , @RequestBody NhaXuatBan a){
        if( !nxb.existsById(id)){
            return ResponseEntity.notFound().build() ;
        }
        a.setTRANGTHAI(3);
        return ResponseEntity.ok( nxb.save(a) );
    }
}
