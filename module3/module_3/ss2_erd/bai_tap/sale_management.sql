DROP DATABASE IF EXISTS sale_management;
CREATE DATABASE sale_management;
USE sale_management;
CREATE TABLE customer(
c_id INT PRIMARY KEY AUTO_INCREMENT,
c_name VARCHAR(45),
c_age INT
);
CREATE TABLE `order`(
o_id INT PRIMARY KEY AUTO_INCREMENT,
c_id INT,
o_date DATE,
o_total_price DOUBLE,
FOREIGN KEY (c_id) REFERENCES customer(c_id)
);
CREATE TABLE product(
p_id INT PRIMARY KEY AUTO_INCREMENT,
p_name VARCHAR(45),
p_price DOUBLE
);
CREATE TABLE order_detail(
o_id INT,
p_id INT,
od_qty INT,
PRIMARY KEY (o_id,p_id),
FOREIGN KEY (o_id) REFERENCES `order`(o_id),
FOREIGN KEY (p_id) REFERENCES product(p_id)
);
