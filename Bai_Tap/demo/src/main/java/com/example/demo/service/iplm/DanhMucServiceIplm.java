package com.example.demo.service.iplm;

import com.example.demo.entity.Danhmuc;
import com.example.demo.reponsitory.DanhMucRepo;
import com.example.demo.service.DanhMucService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DanhMucServiceIplm implements DanhMucService {

    private final DanhMucRepo danhMucRepo ;

    public DanhMucServiceIplm ( DanhMucRepo danhMucRepo ) {
        this.danhMucRepo = danhMucRepo ;
    }

    @Override
    public List<Danhmuc> getAll( Integer id) {
        return this.danhMucRepo.getAllByLoaiDanhMuc(id) ;
    }
    @Override
    public Danhmuc create(Danhmuc danhmuc) {
        danhmuc.setCreateDate( LocalDate.now() );
        danhmuc.setStatus(1);
        return this.danhMucRepo.save(danhmuc);
    }

    @Override
    public Danhmuc update(Danhmuc danhmuc) {
        danhmuc.setUpdateDate( LocalDate.now() );

        return this.danhMucRepo.save(danhmuc);
    }

    @Override
    public List<Danhmuc> findByMaAndName(String code, String name, Integer status , Integer id ) {
        return this.danhMucRepo.getAllByMaAndTen( code , name , status , id );
    }
}
