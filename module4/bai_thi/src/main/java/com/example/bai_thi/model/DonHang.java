package com.example.bai_thi.model;

import javax.persistence.*;

@Entity
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ngayMua;
    private int soluong;
    @Column(columnDefinition = "int default 1")
    private int deleteStatus = 1;

    @ManyToOne
    @JoinColumn(name = "san_pham_id",referencedColumnName = "id")
    private SanPham sanPhamId;

    public DonHang() {
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
