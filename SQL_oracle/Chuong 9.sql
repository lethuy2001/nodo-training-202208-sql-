-- 1. Tạo Index trên cột PROJID cho bảng ASSIGNMENT.

create  INDEX Isss_PROJID on ASSIGNMENT2001 ( PROJD ) ;

-- 2. Hiển thị danh sách của nhân viên thuộc sự quản lý của người có tên là 1 biến được
-- nhập từ bàn phím
-- EMPNO ENAME JOB MGR HIREDATE SAL COMM DEPTNO
-- 7698 BLAKE MANAGER 7839 01-05-1981 2850 30
-- 7654 MARTIN SALESMAN 7698 28-09-1981 1250 1400 30
-- 7499 ALLEN SALESMAN 7698 20-02-1981 1600 300 30
-- 7844 TURNER SALESMAN 7698 08-09-1981 1500 0 30
-- 7900 JAMES CLERK 7698 03-12-1981 950 30
-- 7521 WARD SALESMAN 7698 22-02-1981 1250 500 30
create SEQUENCE  my_sequences INCREMENT BY 1 Start With 1 maxvalue 30 minvalue  1 cycle ;

select EMPNO , ENAME , JOB , MGR , HIREDATE , SAL , COMM , DEPTNO
from EMP where  MGR = ( select EMPNO from EMP B where B.ENAME like 'BLAKE')
            or EMPNO =  ( select EMPNO from EMP B where B.ENAME like 'BLAKE');
