package service;

import model.Hokhau;
import model.Thanhvien;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IHokhauService {
    List<Hokhau> getListHoKhau();



    Map<Integer, List<Thanhvien>> getListThanhVienmap() throws SQLException;

    Hokhau selecthokhau(int id);

    boolean update(Hokhau hokhau);
}
