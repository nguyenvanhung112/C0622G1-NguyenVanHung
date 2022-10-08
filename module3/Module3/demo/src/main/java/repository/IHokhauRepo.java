package repository;

import model.Hokhau;
import model.Thanhvien;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IHokhauRepo {

    List<Hokhau> getList();

    List<Thanhvien> getListThanhvien(int id);

    Map<Integer, List<Thanhvien>> getListThanhvienmap() throws SQLException;

    Hokhau selecthokhau(int id);

    boolean update(Hokhau hokhau);
}
