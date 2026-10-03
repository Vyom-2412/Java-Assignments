create database college;

use college;

create table student (
    student_id int primary key,
    student_name varchar(50),
    course varchar(50),
    marks int
);

insert into student values
(101, 'rahul', 'bca', 85),
(102, 'priya', 'bca', 90),
(103, 'amit', 'bba', 78);

create table product (
    product_id int primary key,
    product_name varchar(50),
    quantity int,
    price decimal(10,2)
);

insert into product values
(1, 'laptop', '10', 55000),
(2, 'mouse', '25', 500),
(3, 'keyboard', '15', 1200);