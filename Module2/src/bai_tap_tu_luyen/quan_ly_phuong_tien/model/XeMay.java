package bai_tap_tu_luyen.quan_ly_phuong_tien.model;

public class XeMay extends PhuongTienGiaoThong {
    private double congSuat;

    public XeMay() {
    }

    public XeMay(int maHangSanXuat, String tenHangSanXuat, String quocGia, String bienKiemSoat, int namSanXuat, String chuSoHuu, double congSuat) {
        super(maHangSanXuat, tenHangSanXuat, quocGia, bienKiemSoat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "XeMay{" +
                super.toString() +
                "congSuat=" + congSuat +
                '}';
    }
}
