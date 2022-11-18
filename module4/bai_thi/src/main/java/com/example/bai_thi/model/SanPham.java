package com.example.bai_thi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int cost;
    private String tinhTrang;
    @Column(columnDefinition = "int default 1")
    private int deleteStatus = 1;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name ="loai_san_pham_id",referencedColumnName = "id")
    private LoaiSanPham loaiSanPhamId;

    @OneToMany(mappedBy = "sanPhamId")
    private Set<DonHang> donHangSet;

    public SanPham() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public LoaiSanPham getLoaiSanPhamId() {
        return loaiSanPhamId;
    }

    public void setLoaiSanPhamId(LoaiSanPham loaiSanPhamId) {
        this.loaiSanPhamId = loaiSanPhamId;
    }

    public Set<DonHang> getDonHangSet() {
        return donHangSet;
    }

    public void setDonHangSet(Set<DonHang> donHangSet) {
        this.donHangSet = donHangSet;
    }
}
