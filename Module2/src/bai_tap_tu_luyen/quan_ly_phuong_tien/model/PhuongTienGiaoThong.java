package bai_tap_tu_luyen.quan_ly_phuong_tien.model;

public abstract class PhuongTienGiaoThong extends HangSanXuat {
    private String bienKiemSoat;
    private int namSanXuat;
    private String chuSoHuu;

    public PhuongTienGiaoThong(int maHangSanXuat, String tenHangSanXuat, String quocGia, String bienKiemSoat, int namSanXuat, String chuSoHuu) {
        super(maHangSanXuat, tenHangSanXuat, quocGia);
        this.bienKiemSoat = bienKiemSoat;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }

    public PhuongTienGiaoThong() {
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "PhuongTienGiaoThong{" +
                "bienKiemSoat='" + bienKiemSoat + '\'' +
                ", HangSanXuat='" + super.toString() + '\'' +
                ", namSanXuat=" + namSanXuat +
                ", chuSoHuu='" + chuSoHuu + '\'' +
                '}';
    }
}
