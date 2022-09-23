DROP DATABASE IF EXISTS product_management;
CREATE DATABASE product_management;
USE product_management;
CREATE TABLE phieu_nhap(
so_phieu_nhap INT PRIMARY KEY AUTO_INCREMENT,
ngay_nhap DATE
);
CREATE TABLE phieu_xuat(
so_phieu_xuat INT PRIMARY KEY AUTO_INCREMENT,
ngay_xuat DATE
);
CREATE TABLE vat_tu(
ma_vat_tu INT PRIMARY KEY AUTO_INCREMENT,
ten_vat_tu VARCHAR(45)
);
CREATE TABLE phieu_nhap_vat_tu(
so_phieu_nhap INT,
ma_vat_tu INT,
don_gia_nhap DOUBLE,
so_luong_nhap INT,
PRIMARY KEY (so_phieu_nhap,ma_vat_tu),
FOREIGN KEY (so_phieu_nhap) REFERENCES phieu_nhap(so_phieu_nhap),
FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu)
);
CREATE TABLE phieu_xuat_vat_tu(
so_phieu_xuat INT,
ma_vat_tu INT,
don_gia_xuat DOUBLE,
so_luong_xuat INT,
PRIMARY KEY (so_phieu_xuat,ma_vat_tu),
FOREIGN KEY (so_phieu_xuat) REFERENCES phieu_xuat(so_phieu_xuat),
FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu)
);
CREATE TABLE don_hang(
so_don_hang INT PRIMARY KEY AUTO_INCREMENT,
ngay_don_hang DATE
);
CREATE TABLE so_dien_thoai(
so_dt VARCHAR(10) PRIMARY KEY
);
CREATE TABLE nha_cung_cap(
ma_nha_cung_cap INT PRIMARY KEY AUTO_INCREMENT,
ten_nha_cung_cap VARCHAR(45),
dia_chi VARCHAR(45),
so_dt VARCHAR(10),
FOREIGN KEY (so_dt) REFERENCES so_dien_thoai(so_dt)
);
CREATE TABLE don_hang_vat_tu(
ma_vat_tu INT,
so_don_hang INT,
ma_nha_cung_cap INT,
PRIMARY KEY (ma_vat_tu,so_don_hang),
FOREIGN KEY (so_don_hang) REFERENCES don_hang(so_don_hang),
FOREIGN KEY (ma_vat_tu) REFERENCES vat_tu(ma_vat_tu),
FOREIGN KEY (ma_nha_cung_cap) REFERENCES nha_cung_cap(ma_nha_cung_cap)
);