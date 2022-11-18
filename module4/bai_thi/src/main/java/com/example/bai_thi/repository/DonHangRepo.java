package com.example.bai_thi.repository;

import com.example.bai_thi.dto.DonHangHienThi;
import com.example.bai_thi.model.DonHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangRepo extends JpaRepository<DonHang,Integer> {

    @Query(value = "select `don_hang`.id donHangId, `san_pham`.name name, `san_pham`.cost, `loai_san_pham`.name loaiSanPham, `don_hang`.ngay_mua ngayMua, `don_hang`.soluong soLuong, `san_pham`.cost * `don_hang`.soLuong totalPrice from `don_hang` join `san_pham` on san_pham.id = don_hang.san_pham_id join `loai_san_pham` on `loai_san_pham`.id = `san_pham`.loai_san_pham_id",nativeQuery = true)
    Page<DonHangHienThi> getListDonHang(Pageable pageable);
}
