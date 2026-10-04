create database jdbc_assignment22;

use jdbc_assignment22;

create table login (
    username varchar(50) primary key,
    password varchar(50)
);

insert into login values
('admin', 'admin123'),
('student', 'student123');

create table hospital_staff (
    login_id varchar(50) primary key,
    staff_name varchar(50),
    role varchar(20),
    password varchar(50)
);

insert into hospital_staff values
('doc101', 'rahul', 'doctor', 'doc123'),
('nur101', 'priya', 'nurse', 'nur123');