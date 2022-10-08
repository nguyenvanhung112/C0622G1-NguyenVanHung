package repository.impl;

import model.Hokhau;
import model.Thanhvien;
import repository.IHokhauRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HokhauRepo implements IHokhauRepo {
    BaseRepo baseRepo = new BaseRepo();
    private static final String INSERT_HOKHAU_SQL = "INSERT INTO customer (customer_type_id,name,date_of_birth,gender,id_card,phone_number, email,address) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_HOKHAU = "select * from hienthihokhau";
    private static final String UPDATE_HOKHAU_SQL = "update thanh_vien set ten = ? where ma_ho_khau = ?;";
    private static final String UPDATE_HOKHAU_SQL1 = "update ho_khau set ngay_lap_ho_khau=? ,dia_chi=? where ma_ho_khau = ?;";
    private static final String SELECT_ALL_THANHVIEN = "select * from thanh_vien where ma_ho_khau = ?";
    @Override
    public List<Hokhau> getList() {
        List<Hokhau> hokhauList = new ArrayList<>();
        Connection connection = baseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOKHAU);
            System.out.println(preparedStatement);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                int maHoKhau = rs.getInt("ma_ho_khau");
                String tenChuHo = rs.getString("ten");
                int soLuongThanhVien = rs.getInt("so_luong_thanh_vien");
                String ngayLap = rs.getString("ngay_lap_ho_khau");
                String diachi = rs.getString("dia_chi");
                hokhauList.add(new Hokhau(maHoKhau,tenChuHo,soLuongThanhVien,ngayLap,diachi));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hokhauList;
    }

    @Override
    public List<Thanhvien> getListThanhvien(int id) {
        List<Thanhvien> thanhvienList = new ArrayList<>();
        Connection connection = baseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THANHVIEN);
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("ten");
                String ngaysinh = rs.getString("ngay_sinh");
                int maHoKhau = rs.getInt("ma_ho_khau");
                thanhvienList.add(new Thanhvien(name,ngaysinh,maHoKhau));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return thanhvienList;
    }

    @Override
    public Map<Integer, List<Thanhvien>> getListThanhvienmap() throws SQLException {
        Map<Integer,List<Thanhvien>> listMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(Hokhau hokhau : getList()){
            list.add(hokhau.getMaHoKhau());
        }
        Connection connection = baseRepo.getConnection();
        for (int item: list)
            {
            List<Thanhvien> thanhvienList = new ArrayList<>();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THANHVIEN);
            preparedStatement.setInt(1,item);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("ten");
                String ngaysinh = rs.getString("ngay_sinh");
                int maHoKhau = rs.getInt("ma_ho_khau");
                thanhvienList.add(new Thanhvien(name,ngaysinh,maHoKhau));
            }
            listMap.put(item,thanhvienList);
        }
        return listMap;
    }

    @Override
    public Hokhau selecthokhau(int id) {
        List<Hokhau> hokhauList = getList();
        for (Hokhau item: hokhauList) {
            if (item.getMaHoKhau()==id){
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean update(Hokhau hokhau) {
        Connection connection = baseRepo.getConnection();
        boolean update = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOKHAU_SQL);
            preparedStatement.setString(1,hokhau.getTenChuHo());
            preparedStatement.setInt(2,hokhau.getMaHoKhau());
            update = preparedStatement.executeUpdate() > 0;
            PreparedStatement preparedStatement1 = connection.prepareStatement(UPDATE_HOKHAU_SQL1);
            preparedStatement1.setString(1,hokhau.getNgayLap());
            preparedStatement1.setString(2,hokhau.getDiachi());
            preparedStatement1.setInt(3,hokhau.getMaHoKhau());
            System.out.println(preparedStatement);
            update = preparedStatement1.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return update;
    }
}
