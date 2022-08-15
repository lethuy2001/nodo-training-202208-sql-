-- 1. Thêm dữ liệu vào bảng PROJECTS.
-- PROJID 1 2
-- P_DESC WRITE C030 COURSE PROOF READ NOTES
-- P_START_DATE 02-JAN-88 01-JAN-89
-- P_END_DATE 03-JAN-88 10-JAN-89
-- BUDGET_AMOUNT 500 600
-- MAX_NO_STAFF 1 1

insert  into PROJECT2001
values ( 1 , 'WRITE C030 COURSE' , '02-JAN-88' , '03-JAN-88' , 500 , 1 , 0 ) ;

insert into  PROJECT2001
 values ( 2 , 'PROOF READ NOTES' , '01-JAN-89' , '10-JAN-89' , 600 , 1 , 0 ) ;

-- 2. Thêm dữ liệu vào bảng ASSIGNMENTS.
-- PROJID 1 1 2
-- EMPNO 7369 7902 7844
-- A_START_DATE 01-JAN-88 04-JAN-88 01-JAN-89
-- A_END_DATE 03-JAN-88 07-JAN-88 10-JAN-89
-- BILL_RATE 50.00 55.00 45.50
-- ASSIGN_TYPE WR WR PF
-- HOURS 15 20 30

select * from  ASSIGNMENT2001 ;

 insert into  ASSIGNMENT2001
values (1 , 7369 , '01-JAN-88' , '03-JAN-88' , 50.00 , 'WR' , 15 ) ;

insert into  ASSIGNMENT2001
values (1 , 7902 , '04-JAN-88'  , '07-JAN-88' , 55.00 , 'WR' , 20 ) ;

insert into  ASSIGNMENT2001
values (2 , 7844 , '01-JAN-89' , '10-JAN-89' , 45.50 , 'PF' , 30 ) ;

-- 3. Cập nhật trường ASIGNMENT_TYPE từ WR thành WT.

update ASSIGNMENT2001 set ASSIGN_TYPE = 'WT' where ASSIGN_TYPE = 'WR' ;

-- 4 Nhập thêm số liệu vào bảng ASSIGNMENTS.
insert into  ASSIGNMENT2001
values (2 , 7902 , '04-JAN-88'  , '07-JAN-88' , 55.00 , 'WR' , 20 ) ;

insert into  ASSIGNMENT2001
values (1 , 7844 , '01-JAN-89' , '10-JAN-89' , 45.50 , 'PF' , 30 ) ;