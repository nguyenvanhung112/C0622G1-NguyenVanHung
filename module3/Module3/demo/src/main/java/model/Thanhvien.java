package model;

public class Thanhvien {
    private int id;
    private String ten;
    private String ngaySinh;
    private int maHoKhau;

    public Thanhvien() {
    }

    public Thanhvien(int id, String ten, String ngaySinh, int maHoKhau) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.maHoKhau = maHoKhau;
    }

    public Thanhvien(String ten, String ngaySinh, int maHoKhau) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.maHoKhau = maHoKhau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public int getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(int maHoKhau) {
        this.maHoKhau = maHoKhau;
    }
}
