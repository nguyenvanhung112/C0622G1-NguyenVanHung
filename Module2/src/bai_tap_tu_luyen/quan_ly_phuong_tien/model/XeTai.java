package bai_tap_tu_luyen.quan_ly_phuong_tien.model;

public class XeTai extends PhuongTienGiaoThong {
    private double trongTai;

    public XeTai() {
    }

    public XeTai(int maHangSanXuat, String tenHangSanXuat, String quocGia, String bienKiemSoat, int namSanXuat, String chuSoHuu, double trongTai) {
        super(maHangSanXuat, tenHangSanXuat, quocGia, bienKiemSoat, namSanXuat, chuSoHuu);
        this.trongTai = trongTai;
    }

    public double getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(double trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "XeTai{" +
                super.toString() +
                "trongTai=" + trongTai +
                '}';
    }
}
