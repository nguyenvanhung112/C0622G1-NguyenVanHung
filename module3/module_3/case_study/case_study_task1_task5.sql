USE case_study;
-- Task 2
SELECT * FROM nhan_vien WHERE char_length(ho_ten) <= 15 AND ho_ten REGEXP '^[HKT].*$';
-- Task 3
SELECT * FROM khach_hang WHERE (TIMESTAMPDIFF(YEAR,ngay_sinh,CURDATE()) BETWEEN 18 AND 50) AND (dia_chi LIKE "%Đà Nẵng%" OR dia_chi LIKE "%Quảng Trị%");
-- Task 4
SELECT khach_hang.ma_khach_hang, khach_hang.ho_ten, COUNT(hop_dong.ma_khach_hang) as so_lan_dat_phong 
FROM khach_hang 
INNER JOIN  hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
INNER JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach WHERE loai_khach.ten_loai_khach = "Diamond" 
GROUP BY hop_dong.ma_khach_hang ORDER BY so_lan_dat_phong;
-- Task 5
SELECT khach_hang.ma_khach_hang,
khach_hang.ho_ten,
loai_khach.ten_loai_khach,
hop_dong.ma_hop_dong, 
dich_vu.ten_dich_vu, 
hop_dong.ngay_lam_hop_dong,
hop_dong.ngay_ket_thuc, 
(ifnull(dich_vu.chi_phi_thue,0)+ SUM(ifnull(hop_dong_chi_tiet.so_luong,0)*ifnull(dich_vu_di_kem.gia,0)))  as tong_tien
FROM khach_hang
LEFT JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach 
LEFT JOIN hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang 
LEFT JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
LEFT JOIN dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY hop_dong.ma_hop_dong, khach_hang.ma_khach_hang
ORDER BY khach_hang.ma_khach_hang;