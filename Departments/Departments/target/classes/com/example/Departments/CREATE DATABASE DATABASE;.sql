-- DROP DATABASE college;
CREATE DATABASE college;
USE college;
CREATE TABLE department(
    departmentId INT AUTO_INCREMENT PRIMARY KEY,
    name varchar(30) NOT NULL,
    descrption varchar(400) NOT NULL
);
CREATE TABLE teachers(
    tech_id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name varchar(30) NOT NULL,
    email varchar(60) NOT NULL,
    mobile_num bigint NOT NULL,
    departmentId INT,
    CONSTRAINT fk_department
    FOREIGN KEY (departmentId) 
        REFERENCES department(departmentId)
);
