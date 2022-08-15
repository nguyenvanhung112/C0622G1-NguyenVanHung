package bai_tap_tu_luyen.quan_ly_phuong_tien.model;

public class Oto extends PhuongTienGiaoThong {
    private int soChoNgoi;
    private String kieuXe;

    public Oto() {
    }

    public Oto(int maHangSanXuat, String tenHangSanXuat, String quocGia, String bienKiemSoat, int namSanXuat, String chuSoHuu, int soChoNgoi, String kieuXe) {
        super(maHangSanXuat, tenHangSanXuat, quocGia, bienKiemSoat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return "Oto{" +
                super.toString() +
                "soChoNgoi=" + soChoNgoi +
                ", kieuXe='" + kieuXe + '\'' +
                '}';
    }
}
