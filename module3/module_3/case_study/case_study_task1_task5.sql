USE case_study;
SELECT * FROM nhan_vien WHERE char_length(ho_ten) <= 15 AND ho_ten REGEXP '^[HKT].*$';
SELECT * FROM khach_hang WHERE (TIMESTAMPDIFF(YEAR,ngay_sinh,CURDATE()) BETWEEN 18 AND 50) AND (dia_chi LIKE "%Đà Nẵng%" OR dia_chi LIKE "%Quảng Trị%");
SELECT khach_hang.ma_khach_hang, khach_hang.ho_ten, COUNT(hop_dong.ma_khach_hang) as so_lan_dat_phong 
FROM khach_hang 
INNER JOIN  hop_dong ON khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
INNER JOIN loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach WHERE loai_khach.ten_loai_khach = "Diamond" 
GROUP BY hop_dong.ma_khach_hang ORDER BY so_lan_dat_phong;
