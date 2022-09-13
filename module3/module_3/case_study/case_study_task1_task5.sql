USE case_study;
SELECT * FROM nhan_vien WHERE char_length(ho_ten) <= 15 AND ho_ten REGEXP '^[HKT].*$';