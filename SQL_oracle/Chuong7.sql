-- Bài 7. Tạo bảng PROJECT với các column được chỉ ra dưới đây, PROJID là promary key, và
-- P_END_DATE > P_START_DATE.
-- Column name Data Type Size.
-- PROJID NUMBER 4
-- P_DESC VARCHAR2 20
-- P_START_DATE DATE
-- P_END_DATE DATE
-- BUDGET_AMOUNT NUMBER 7,2
-- MAX_NO_STAFF NUMBER 2

create table PROJECT2001(
    PROJD number(4) primary key ,
    P_DESC varchar(20) ,
    P_START_DATE DATE ,
    P_END_DATE DATE  ,
    check ( P_END_DATE > P_START_DATE ) ,
    BUDGET_AMOUNT number( 7,2) ,
    MAX_NO_STAFF number( 2)
);

-- 2. Tạo bảng ASSIGNMENTS với các column được chỉ ra dưới đây, đồng thời cột
-- PROJID là foreign key tới bảng PROJECT, cột EMPNO là foreign key tới bảng EMP.
-- Column name Data Type Size.
-- PROJID NUMBER 4 NOT NULL
-- EMPNO NUMBER 4 NOT NULL
-- A_START_DATE DATE
-- A_END_DATE DATE
-- BILL_AMOUNT NUMBER 4,2
-- ASSIGN_TYPE VARCHAR2 2

create table ASSIGNMENT2001 (
    PROJD NUMBER(4) not null  ,
    EMPONO NUMBER(4) not null  ,
    A_START_DATE DATE ,
    A_END_DATE DATE ,
    BILL_AMOUNT number(4,2) ,
    ASSIGN_TYPE varchar2(2) ,
    primary key ( PROJD , EMPONO) ,
    foreign key ( PROJD ) references PROJECT2001(PROJD) ,
    foreign key ( EMPONO) references EMP ( EMPNO)
);

select * from ASSIGNMENT2001 ;
select * from PROJECT2001 ;

-- 3 Thêm column COMMENTS kiểu LONG vào bảng PROJECTS. Thêm column HOURS kiểu
-- NUMBER vào bảng ASSIGNMENTS.

ALTER table  ASSIGNMENT2001 add HOURS number ;
ALTER  table  PROJECT2001 add  COMMENTS LONG;

-- 4 . Sử dụng view USER_OBJECTS hiển thị tất cả các đối tượng user sở hữu.
select * from TAB ;

-- 5 . Thêm ràng buộc duy nhất (UNIQUE) cho 2 column PROJECT_ID và EMPNO của bảng
-- ASSIGNMENTS.

ALTER table ASSIGNMENT2001 add constraint PROJECT_ID UNIQUE ( PROJD , EMPONO )

-- 6. Xem các thông tin về các ràng buộc trong USER_CONSTRAINTS.

select * from USER_CONSTRAINTS ;

-- 7 Xem trong USER hiện tại có tất cả bao nhiêu bảng

select count(TABLE_NAME) TheNumberOfTable from DICTIONARY