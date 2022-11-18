package com.example.bai_thi.service.impl;

import com.example.bai_thi.model.SanPham;
import com.example.bai_thi.repository.SanPhamRepo;
import com.example.bai_thi.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService implements ISanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;
    @Override
    public List<SanPham> getListSanPham() {
        return sanPhamRepo.findAll();
    }
}
