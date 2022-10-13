package repository.impl;

import model.Sanpham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoSanpham implements IRepo{
    BaseRepo baseRepo = new BaseRepo();
    private static final String DELETE_SANPHAM_SQL = "update sanpham set is_delete = 1  where id = ?;";
    private static final String SELECT_ALL_SANPHAM = "select * from sanpham where is_delete = 0";
    private static final String INSERT_SANPHAM_SQL = "INSERT INTO sanpham (tensanpham,gia,soluong,mausac,mota,iddanhmuc) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_SANPHAM = "select * from sanpham where tensanpham like ?, gia =? , mausac like ?, iddanhmuc =?  is_delete = 0";
    private static final String SELECT_SANPHAM_TEN = "select * from sanpham where tensanpham like ? and gia =? and mausac like ? and iddanhmuc =? and is_delete = 0";
    @Override
    public List<Sanpham> getList() {
        List<Sanpham> sanphams = new ArrayList<>();
        Connection connection = baseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SANPHAM);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String tensanpham = rs.getString("tensanpham");
                double gia = rs.getDouble("gia");
                int soluong = rs.getInt("soluong");
                String mausac = rs.getString("mausac");
                String mota = rs.getString("mota");
                int danhmuc = rs.getInt("iddanhmuc");
                sanphams.add(new Sanpham(id,tensanpham, gia, soluong, mausac, mota, danhmuc));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sanphams;
    }

    @Override
    public boolean add(Sanpham newSanpham) {
        Connection connection = baseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SANPHAM_SQL);
            preparedStatement.setString(1, newSanpham.getTen());
            preparedStatement.setDouble(2, newSanpham.getGia());
            preparedStatement.setInt(3, newSanpham.getSoluong());
            preparedStatement.setString(4, newSanpham.getMausac());
            preparedStatement.setString(5, newSanpham.getMota());
            preparedStatement.setInt(6, newSanpham.getDanhmuc());
            System.out.println(preparedStatement);
            int num = preparedStatement.executeUpdate();
            return  num == 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = baseRepo.getConnection();
        boolean delete = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SANPHAM_SQL);
            preparedStatement.setInt(1,id);
            delete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return delete;
    }

    @Override
    public List<Sanpham> find(String ten, double gia, String mausac, int danhmuc) {
        Connection connection = baseRepo.getConnection();
        List<Sanpham> list = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SANPHAM_SQL);
            preparedStatement.setString(1, "%"+ten);
            preparedStatement.setDouble(2, gia);
            preparedStatement.setString(3, "%"+mausac);
            preparedStatement.setInt(4, danhmuc);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String tensanpham = rs.getString("tensanpham");
                double gia1 = rs.getDouble("gia");
                int soluong = rs.getInt("soluong");
                String mausac1 = rs.getString("mausac");
                String mota = rs.getString("mota");
                int iddanhmuc = rs.getInt("iddanhmuc");
                list.add(new Sanpham(id,tensanpham,gia1,soluong,mausac1,mota,iddanhmuc));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Sanpham> findTen(String ten) {
        List<Sanpham> list = new ArrayList<>();
        for (Sanpham sanpham: getList()) {
            if (sanpham.getTen().contains(ten)){
                list.add(sanpham);
            }
        }
        return list;
    }
}
