package com.example.bai_thi.dto;

import com.example.bai_thi.model.SanPham;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;


public class DonHangDTO {
    private int id;
    private String ngayMua;
    private int soluong;
    private int deleteStatus = 1;
    private SanPham sanPhamId;

    public DonHangDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public SanPham getSanPhamId() {
        return sanPhamId;
    }

    public void setSanPhamId(SanPham sanPhamId) {
        this.sanPhamId = sanPhamId;
    }

}
