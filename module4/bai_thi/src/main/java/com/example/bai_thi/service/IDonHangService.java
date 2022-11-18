package com.example.bai_thi.service;

import com.example.bai_thi.dto.DonHangHienThi;
import com.example.bai_thi.model.DonHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDonHangService {
    Page<DonHangHienThi> findListDonHang(Pageable pageable);

    DonHang findListDonHangById(int id);

    void save(DonHang donHang);
}
