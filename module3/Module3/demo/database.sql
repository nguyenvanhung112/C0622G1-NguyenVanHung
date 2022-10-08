drop database if exists quan_li_ho_khau;
create database quan_li_ho_khau;
use quan_li_ho_khau;
create table ho_khau(
ma_ho_khau int primary key auto_increment,
ten_chu_ho varchar(50),
so_luong_thanh_vien int,
ngay_lap_ho_khau date,
dia_chi varchar(50),
is_delete bit DEFAULT 0
);
create table thanh_vien(
id int primary key auto_increment,
ten varchar(50),
ngay_sinh date,
ma_ho_khau int,
is_delete bit DEFAULT 0,
foreign key (ma_ho_khau) references ho_khau(ma_ho_khau) ON DELETE CASCADE
);
SET FOREIGN_KEY_CHECKS=0;
insert into ho_khau(ma_ho_khau,ten_chu_ho,so_luong_thanh_vien,ngay_lap_ho_khau,dia_chi) 
value 
(1,"Nguyễn Văn Vinh",3,"2022-12-11","Cẩm Lệ - Đà Nẵng"),
(2,"Nguyễn Văn Quang",3,"2022-12-20","Hòa Khánh - Đà Nẵng"),
(3,"Nguyễn Văn Hải",3,"2022-11-10","Liên Chiểu - Đà Nẵng"),
(4,"Nguyễn Văn Hùng",3,"2022-11-10","Sơn Trà - Đà Nẵng"),
(5,"Nguyễn Văn Nam",3,"2022-11-10","Thanh Khê - Đà Nẵng");
insert into thanh_vien(id,ten,ngay_sinh,ma_ho_khau)
value
(1,"Nguyễn Văn Vinh","1995-02-12",1),
(2,"Nguyễn Văn Quang","1995-02-12",2),
(3,"Nguyễn Văn Hải","1995-02-12",3),
(4,"Nguyễn Văn Hùng","1995-02-12",4),
(5,"Nguyễn Văn Nam","1995-02-12",5),
(6,"Nguyễn Khánh","1995-02-12",1),
(7,"Nguyễn Văn B","1995-02-12",1),
(8,"Nguyễn Văn N","1995-02-12",2),
(9,"Nguyễn Văn M","1995-02-12",2),
(10,"Nguyễn Văn D","1995-02-12",3),
(11,"Nguyễn Văn G","1995-02-12",3),
(12,"Nguyễn Văn H","1995-02-12",4),
(13,"Nguyễn Văn L","1995-02-12",5);
CREATE VIEW nguoi_trong_ho_khau as
select  ho_khau.ma_ho_khau,thanh_vien.ten ,thanh_vien.ngay_sinh,thanh_vien.id FROM thanh_vien
JOIN ho_khau on ho_khau.ma_ho_khau = thanh_vien.ma_ho_khau;