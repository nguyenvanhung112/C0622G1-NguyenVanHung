package com.example.bai_thi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(columnDefinition = "int default 1")
    private int deleteStatus = 1;
    @OneToMany(mappedBy = "loaiSanPhamId")
    private Set<SanPham> sanPhamSet;

    public LoaiSanPham() {
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

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<SanPham> getSanPhamSet() {
        return sanPhamSet;
    }

    public void setSanPhamSet(Set<SanPham> sanPhamSet) {
        this.sanPhamSet = sanPhamSet;
    }
}
