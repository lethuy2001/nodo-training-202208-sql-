package com.example.demo.service.iplm;

import com.example.demo.entity.Loaidanhmuc;
import com.example.demo.reponsitory.LoaiDanhMucRepo;
import com.example.demo.service.LoaiDanhMucService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoaiDanhMucServiceIplm implements LoaiDanhMucService {

    private final LoaiDanhMucRepo loaiDanhMucRepo ;

    public LoaiDanhMucServiceIplm( LoaiDanhMucRepo loaiDanhMucRepo ){
        this.loaiDanhMucRepo = loaiDanhMucRepo ;
    }

    @Override
    public List<Loaidanhmuc> getAll() {
        return this.loaiDanhMucRepo.findAll() ;
    }

    @Override
    public Loaidanhmuc create(Loaidanhmuc loaidanhmuc) {
        loaidanhmuc.setStatus(1);
        loaidanhmuc.setCreateDate( LocalDate.now() );
        return this.loaiDanhMucRepo.save(loaidanhmuc );
    }

    @Override
    public Loaidanhmuc update(Loaidanhmuc loaidanhmuc) {
        loaidanhmuc.setUpdateDate( LocalDate.now() );
        return this.loaiDanhMucRepo.save(loaidanhmuc) ;
    }

    @Override
    public List<Loaidanhmuc> findByMaAndName(String code, String name, Integer status) {
        return this.loaiDanhMucRepo.findByNameOrMa( code  ,   name ,  status );
    }
}
