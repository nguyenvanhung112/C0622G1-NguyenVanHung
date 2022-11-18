package com.example.bai_thi.service.impl;

import com.example.bai_thi.dto.DonHangHienThi;
import com.example.bai_thi.model.DonHang;
import com.example.bai_thi.repository.DonHangRepo;
import com.example.bai_thi.service.IDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DonHangService implements IDonHangService {
    @Autowired
    DonHangRepo donHangRepo;
    @Override
    public Page<DonHangHienThi> findListDonHang(Pageable pageable) {
        return donHangRepo.getListDonHang(pageable);
    }

    @Override
    public DonHang findListDonHangById(int id) {
        return donHangRepo.findById(id).orElse(null);
    }

    @Override
    public void save(DonHang donHang) {
        donHangRepo.save(donHang);
    }
}
