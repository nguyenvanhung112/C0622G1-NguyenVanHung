drop database if exists bai_thi;
create database bai_thi;
use bai_thi;

create table danhmuc(
id int primary key auto_increment,
ten varchar(50),
is_delete bit DEFAULT 0
);
SET FOREIGN_KEY_CHECKS=0;
create table sanpham(
id int primary key auto_increment,
tensanpham varchar(50),
gia DOUBLE,
soluong int,
mausac VARCHAR(50),
mota varchar(50),
iddanhmuc int,
is_delete bit DEFAULT 0,
foreign key (iddanhmuc) references danhmuc(id) ON DELETE CASCADE
);
INSERT INTO `bai_thi`.`danhmuc` (`id`, `ten`, `is_delete`) VALUES (1, 'Iphone', 0);
INSERT INTO `bai_thi`.`danhmuc` (`id`, `ten`, `is_delete`) VALUES (2, 'Máy Giặt', 0);
INSERT INTO `bai_thi`.`danhmuc` (`id`, `ten`, `is_delete`) VALUES (3, 'Tủ Lạnh', 0);
INSERT INTO `bai_thi`.`danhmuc` (`id`, `ten`, `is_delete`) VALUES (4, 'TV', 0);
INSERT INTO `bai_thi`.`danhmuc` (`id`, `ten`, `is_delete`) VALUES (5, 'Quạt', 0);
INSERT INTO `bai_thi`.`danhmuc` (`id`, `ten`, `is_delete`) VALUES (6, 'Loa', 0);
INSERT INTO `bai_thi`.`sanpham` (`id`, `tensanpham`, `gia`, `soluong`, `mausac`, `mota`, `iddanhmuc`, `is_delete`) VALUES (1, 'Iphone 11', 799, 12, 'Black,Yellow', 'ok', 1, 0);
INSERT INTO `bai_thi`.`sanpham` (`id`, `tensanpham`, `gia`, `soluong`, `mausac`, `mota`, `iddanhmuc`, `is_delete`) VALUES (2, 'Iphone 12', 1000, 11, 'Black,Yellow', 'ok', 1, 0);
INSERT INTO `bai_thi`.`sanpham` (`id`, `tensanpham`, `gia`, `soluong`, `mausac`, `mota`, `iddanhmuc`, `is_delete`) VALUES (3, 'Iphone X', 900, 10, 'Bliack,Yelow', 'ok', 1, 0);
INSERT INTO `bai_thi`.`sanpham` (`id`, `tensanpham`, `gia`, `soluong`, `mausac`, `mota`, `iddanhmuc`, `is_delete`) VALUES (4, 'Máy Giặt Pana', 900, 9, 'Bliack,Yelow', 'ok', 2, 0);
INSERT INTO `bai_thi`.`sanpham` (`id`, `tensanpham`, `gia`, `soluong`, `mausac`, `mota`, `iddanhmuc`, `is_delete`) VALUES (5, 'Tủ Lạnh', 900, 10, 'Bliack,Yelow', 'ok', 3, 0);
INSERT INTO `bai_thi`.`sanpham` (`id`, `tensanpham`, `gia`, `soluong`, `mausac`, `mota`, `iddanhmuc`, `is_delete`) VALUES (6, 'TV', 900, 7, 'Bliack,Yelow', 'ok', 4, 0);
INSERT INTO `bai_thi`.`sanpham` (`id`, `tensanpham`, `gia`, `soluong`, `mausac`, `mota`, `iddanhmuc`, `is_delete`) VALUES (7, 'Quạt', 900, 5, 'Bliack,Yelow', 'ok', 5, 0);
INSERT INTO `bai_thi`.`sanpham` (`id`, `tensanpham`, `gia`, `soluong`, `mausac`, `mota`, `iddanhmuc`, `is_delete`) VALUES (8, 'Loa', 900, 1, 'Bliack,Yelow', 'ok', 6, 0);
