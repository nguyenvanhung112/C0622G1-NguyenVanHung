USE case_study;
-- Task 16
DELETE FROM nhan_vien
WHERE nhan_vien.ma_nhan_vien NOT IN (SELECT hop_dong.ma_nhan_vien FROM hop_dong WHERE (YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN '2019' AND '2021'));
-- Task 17

DROP VIEW IF EXISTS demo2;
CREATE VIEW demo2 AS
SELECT khach_hang.ma_khach_hang,
khach_hang.ho_ten,
loai_khach.ten_loai_khach,
hop_dong.ma_hop_dong, 
dich_vu.ten_dich_vu, 
hop_dong.ngay_lam_hop_dong,
hop_dong.ngay_ket_thuc, 
SUM(ifnull(dich_vu.chi_phi_thue,0)+ (ifnull(hop_dong_chi_tiet.so_luong,0)*ifnull(dich_vu_di_kem.gia,0)))  as tong_tien
FROM khach_hang
LEFT JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach 
LEFT JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
LEFT JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
LEFT JOIN dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY khach_hang.ma_khach_hang
ORDER BY khach_hang.ma_khach_hang;
UPDATE khach_hang 
JOIN demo2 on khach_hang.ma_khach_hang = demo2.ma_khach_hang
JOIN hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
SET khach_hang.ma_loai_khach = 1
WHERE khach_hang.ma_loai_khach=2 AND khach_hang.ma_khach_hang IN (SELECT demo2.ma_khach_hang FROM demo2 WHERE demo2.tong_tien > 1000000
) AND YEAR(hop_dong.ngay_lam_hop_dong) = 2021; 
SELECT * FROM khach_hang;
-- Task 18
SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM khach_hang
WHERE khach_hang.ma_khach_hang IN (SELECT hop_dong.ma_khach_hang FROM hop_dong WHERE (YEAR(hop_dong.ngay_lam_hop_dong) < 2021 ));
-- Task 19
DROP VIEW IF EXISTS demo3;
CREATE VIEW demo3 AS
SELECT hop_dong_chi_tiet.ma_dich_vu_di_kem, SUM(hop_dong_chi_tiet.so_luong) as so_luong FROM hop_dong_chi_tiet
JOIN hop_dong ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
WHERE hop_dong.ma_hop_dong NOT IN (SELECT hop_dong.ma_hop_dong FROM hop_dong 
WHERE year(hop_dong.ngay_lam_hop_dong)>=2021)
GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem;
UPDATE dich_vu_di_kem
JOIN demo3 ON demo3.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem SET dich_vu_di_kem.gia = dich_vu_di_kem.gia*2 WHERE demo3.so_luong > 10;
-- Task 20
SELECT nhan_vien.ma_nhan_vien,nhan_vien.ho_ten,nhan_vien.email,nhan_vien.so_dien_thoai,nhan_vien.ngay_sinh,nhan_vien.dia_chi FROM nhan_vien
UNION ALL
SELECT khach_hang.ma_khach_hang,khach_hang.ho_ten,khach_hang.email,khach_hang.so_dien_thoai,khach_hang.ngay_sinh,khach_hang.dia_chi FROM khach_hang;