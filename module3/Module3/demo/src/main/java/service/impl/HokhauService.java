package service.impl;

import model.Hokhau;
import model.Thanhvien;
import repository.IHokhauRepo;
import repository.impl.HokhauRepo;
import service.IHokhauService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class HokhauService implements IHokhauService {
    IHokhauRepo hokhauRepo = new HokhauRepo();
    @Override
    public List<Hokhau> getListHoKhau() {
        return hokhauRepo.getList();
    }

    @Override
    public Map<Integer, List<Thanhvien>> getListThanhVienmap() throws SQLException {
        return hokhauRepo.getListThanhvienmap();
    }

    @Override
    public Hokhau selecthokhau(int id) {
        return hokhauRepo.selecthokhau(id);
    }

    @Override
    public boolean update(Hokhau hokhau) {
        return hokhauRepo.update(hokhau);
    }
}
