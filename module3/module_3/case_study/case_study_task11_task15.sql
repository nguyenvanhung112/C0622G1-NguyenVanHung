USE case_study;
-- Task 11
SELECT dich_vu_di_kem.ma_dich_vu_di_kem,dich_vu_di_kem.ten_dich_vu_di_kem FROM dich_vu_di_kem 
JOIN hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
JOIN hop_dong ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
JOIN khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach WHERE loai_khach.ten_loai_khach = "Diamond" AND khach_hang.dia_chi LIKE "%Quảng NGÃI%" OR khach_hang.dia_chi LIKE "%Vinh%" ;
-- Task 12
SELECT hop_dong.ma_hop_dong, 
nhan_vien.ho_ten,
khach_hang.ho_ten,
khach_hang.so_dien_thoai,
dich_vu.ten_dich_vu,
dich_vu.ma_dich_vu,
SUM(IFNULL(hop_dong_chi_tiet.so_luong,0)) as so_luong_dich_vu_di_kem,
hop_dong.tien_dat_coc
FROM hop_dong
JOIN nhan_vien ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
JOIN khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu 
LEFT JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
WHERE dich_vu.ma_dich_vu IN (SELECT hop_dong.ma_dich_vu FROM hop_dong WHERE hop_dong.ngay_lam_hop_dong BETWEEN'2020-10-01' AND '2020-12-31') 
AND dich_vu.ma_dich_vu NOT IN (SELECT hop_dong.ma_dich_vu FROM hop_dong WHERE hop_dong.ngay_lam_hop_dong BETWEEN'2021-01-01' AND '2021-06-31')
GROUP BY hop_dong.ma_hop_dong;
-- Task 13
DROP VIEW IF EXISTS demo;
CREATE VIEW demo AS
SELECT dich_vu_di_kem.ma_dich_vu_di_kem,dich_vu_di_kem.ten_dich_vu_di_kem, SUM(hop_dong_chi_tiet.so_luong) as so_luong
FROM dich_vu_di_kem
JOIN hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem;
SELECT demo.ma_dich_vu_di_kem,demo.ten_dich_vu_di_kem,demo.so_luong FROM demo WHERE demo.so_luong = (SELECT MAX(demo.so_luong) FROM demo);
-- Task 14
SELECT hop_dong.ma_hop_dong, 
loai_dich_vu.ten_loai_dich_vu, 
dich_vu_di_kem.ten_dich_vu_di_kem,
COUNT(hop_dong_chi_tiet.ma_dich_vu_di_kem) as so_lan_su_dung
FROM hop_dong
JOIN dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
JOIN loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
JOIN hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
JOIN dich_vu_di_kem ON hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
GROUP BY hop_dong_chi_tiet.ma_dich_vu_di_kem
HAVING COUNT(hop_dong_chi_tiet.ma_dich_vu_di_kem) = 1
ORDER BY hop_dong.ma_hop_dong;
-- Task 15
SELECT nhan_vien.ma_nhan_vien,
nhan_vien.ho_ten,
trinh_do.ten_trinh_do,
bo_phan.ten_bo_phan,
nhan_vien.so_dien_thoai,
nhan_vien.dia_chi
FROM nhan_vien
JOIN trinh_do ON nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
JOIN bo_phan ON nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
JOIN hop_dong ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien 
WHERE YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN "2020" AND "2021"
GROUP BY nhan_vien.ma_nhan_vien
HAVING COUNT(hop_dong.ma_hop_dong) < 4;