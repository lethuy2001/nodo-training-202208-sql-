package com.example.quanlysach.restController;

import com.example.quanlysach.entity.BanDoc;
import com.example.quanlysach.entity.MuonSach;
import com.example.quanlysach.entity.Sach;
import com.example.quanlysach.responsitory.MuonSachService;
import com.example.quanlysach.responsitory.SachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("ms")
public class MuonSachRestController {

    @Autowired
    MuonSachService ms;

    @Autowired
    SachService s ;

    @GetMapping("")
    public ResponseEntity<List<MuonSach>> findAll() {
        return ResponseEntity.ok(ms.findAll());
    }

    @PostMapping("")
    public ResponseEntity<MuonSach> create(@RequestBody MuonSach muonSach) {

        Sach sach = s.getById( muonSach.getSach().getID() ) ;
        sach.setSOLUONGMUON( sach.getSOLUONGMUON() + muonSach.getSOLUONG() );
        sach.setSOLUONGCON( sach.getTONGSOSACH() - sach.getSOLUONGMUON() );

        s.save(sach) ;
        muonSach.setNGAYGIOMUON( new Date() );
        return ResponseEntity.ok(ms.save(muonSach));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MuonSach> update(@PathVariable("id") Integer id, @RequestBody MuonSach muonSach) {
        if (!ms.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ms.save(muonSach));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        if (!ms.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        ms.deleteById(id);
        return null;
    }
}
