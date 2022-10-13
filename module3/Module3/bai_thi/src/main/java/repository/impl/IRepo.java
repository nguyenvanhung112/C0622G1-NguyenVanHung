package repository.impl;

import model.Sanpham;

import java.util.List;

public interface IRepo {
    List<Sanpham> getList();

    boolean add(Sanpham newSanpham);

    boolean delete(int id);

    List<Sanpham> find(String ten, double gia, String mausac, int danhmuc);

    List<Sanpham> findTen(String ten);
}
