create database jdbc_assignment24;

use jdbc_assignment24;

create table library_book (
    book_id int primary key,
    title varchar(100),
    author varchar(100),
    price decimal(10,2)
);

insert into library_book values
(101, 'java programming', 'james gosling', 600),
(102, 'database systems', 'korth', 750),
(103, 'data structures', 'mark allen', 500);

create table book_issue (
    book_id int primary key,
    student_name varchar(100),
    issue_date varchar(20),
    return_date varchar(20)
);

insert into book_issue values
(101, 'rahul', '2026-10-01', '2026-10-10'),
(102, 'priya', '2026-10-02', '2026-10-12'),
(103, 'amit', '2026-10-03', '2026-10-13');