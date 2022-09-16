DROP DATABASE IF EXISTS demo;
CREATE DATABASE demo;
USE demo;
CREATE TABLE products (
id INT PRIMARY KEY,
product_code VARCHAR(50),
product_name VARCHAR(50),
product_price DOUBLE,
product_amount INT,
product_description VARCHAR(50),
product_status VARCHAR(50)
);
INSERT INTO products
VALUES(1,'P001','Ô mô', 35000, 50, 'Sạch những vết bẩn cứng đầu','cháy hàng'),
(2,'P002','Aba', 35000, 50, 'Sạch những vết bẩn cứng đầu','còn hàng'),
(3,'P003','Compho', 35000, 50, 'Sạch những vết bẩn cứng đầu và thơm lâu','cháy hàng'),
(4,'P004','Chou Chou', 35000, 50, 'Sạch những vết bẩn cứng đầu và lưu hương lâu','còn hàng');
SELECT * FROM products;
CREATE UNIQUE INDEX index1 ON products(product_code);
CREATE INDEX index2 ON products(product_code,product_price);
EXPLAIN SELECT * FROM products WHERE products.product_code = 'P001';
CREATE VIEW view_products AS SELECT products.product_code,products.product_name,products.product_price,products.product_status FROM products;
SELECT * FROM view_products;
UPDATE view_products SET view_products.product_name = "Tide" WHERE view_products.product_name = "Chou Chou";
DROP VIEW view_products;
DELIMITER //
CREATE PROCEDURE sp_products()
BEGIN
SELECT * FROM products;
END //
DELIMITER ;
DELIMITER //
CREATE PROCEDURE sp_products1(
id INT,
product_code VARCHAR(50),
product_name VARCHAR(50),
product_price DOUBLE,
product_amount INT,
product_description VARCHAR(50),
product_status VARCHAR(50))
BEGIN
INSERT INTO products VALUES(id,product_code,product_name,product_price,product_amount,product_description,product_status);
END //
DELIMITER ;
CALL sp_products1(5,'P005','Siba', 35000, 50, 'Sạch những vết bẩn cứng đầu và lưu hương lâu','còn hàng');
DELIMITER //
CREATE PROCEDURE sp_update(
p_id INT,
p_code VARCHAR(50),
p_name VARCHAR(50),
p_price DOUBLE,
p_amount INT,
p_description VARCHAR(50),
p_status VARCHAR(50))
BEGIN
UPDATE products SET product_code = p_code,
product_name = p_name,
product_price = p_price,
product_amount = p_amount,
product_description = p_description,
product_status= p_status
WHERE id = p_id;
END //
DELIMITER ;
CALL sp_update (4,'P006','Ale', 35000, 100, 'hương lâu','còn hàng');
DELIMITER //
CREATE PROCEDURE sp_delete(p_id INT)
BEGIN
DELETE FROM products WHERE id = p_id;
END //
DELIMITER ;
CALL sp_delete(2);
SELECT * FROM products;