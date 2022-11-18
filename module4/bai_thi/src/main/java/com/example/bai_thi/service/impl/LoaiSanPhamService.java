package com.example.bai_thi.service.impl;

import com.example.bai_thi.model.LoaiSanPham;
import com.example.bai_thi.repository.LoaiSanPhamRepo;
import com.example.bai_thi.service.ILoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiSanPhamService implements ILoaiSanPhamService {
    @Autowired
    LoaiSanPhamRepo loaiSanPhamRepo;
    @Override
    public List<LoaiSanPham> getListLoaiSanPham() {
        return loaiSanPhamRepo.findAll();
    }
}
