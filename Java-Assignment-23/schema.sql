create database jdbc_assignment23;

use jdbc_assignment23;

create table student (
    roll_no int primary key,
    name varchar(50),
    course varchar(50),
    marks int
);

insert into student values
(1, 'rahul', 'bca', 85),
(2, 'priya', 'bca', 90),
(3, 'amit', 'bba', 78);

create table employee (
    employee_id int primary key,
    name varchar(50),
    department varchar(50),
    salary decimal(10,2)
);

insert into employee values
(101, 'rahul', 'it', 50000),
(102, 'priya', 'hr', 45000),
(103, 'amit', 'finance', 55000);