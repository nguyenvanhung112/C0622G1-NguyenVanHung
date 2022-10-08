package model;

public class Hokhau {
    private int maHoKhau;
    private String tenChuHo;
    private int soLuongThanhVien;
    private String ngayLap;
    private String diachi;

    public Hokhau() {
    }

    public Hokhau(String tenChuHo, int soLuongThanhVien, String ngayLap, String diachi) {
        this.tenChuHo = tenChuHo;
        this.soLuongThanhVien = soLuongThanhVien;
        this.ngayLap = ngayLap;
        this.diachi = diachi;
    }

    public Hokhau(int maHoKhau, String tenChuHo, int soLuongThanhVien, String ngayLap, String diachi) {
        this.maHoKhau = maHoKhau;
        this.tenChuHo = tenChuHo;
        this.soLuongThanhVien = soLuongThanhVien;
        this.ngayLap = ngayLap;
        this.diachi = diachi;
    }

    public int getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(int maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public int getSoLuongThanhVien() {
        return soLuongThanhVien;
    }

    public void setSoLuongThanhVien(int soLuongThanhVien) {
        this.soLuongThanhVien = soLuongThanhVien;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
