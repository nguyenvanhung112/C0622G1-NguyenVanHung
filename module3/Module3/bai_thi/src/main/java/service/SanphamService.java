package service;

import model.Sanpham;
import repository.impl.IRepo;
import repository.impl.RepoSanpham;

import java.util.List;

public class SanphamService implements IService {
    IRepo repo = new RepoSanpham();
    @Override
    public List<Sanpham> getList() {
        return repo.getList();
    }

    @Override
    public boolean add(Sanpham newSanpham) {
        return repo.add(newSanpham);
    }

    @Override
    public boolean delete(int id) {
        return repo.delete(id);
    }

    @Override
    public List<Sanpham> find(String ten, double gia, String mausac, int danhmuc) {
        return repo.find(ten,gia,mausac,danhmuc);
    }

    @Override
    public List<Sanpham> findTen(String ten) {
        return repo.findTen(ten);
    }
}
