DROP DATABASE IF EXISTS student_management;
CREATE DATABASE student_management;
USE student_management;
CREATE TABLE student (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45),
    `age` INT,
    `country` VARCHAR(45)
);
CREATE TABLE class(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);
CREATE TABLE teacher(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45),
`age` INT,
`country` VARCHAR(45)
);
INSERT INTO student(id, name, age, country)
VALUES(001,"Nguyễn Văn Hùng",20,"Việt Nam");