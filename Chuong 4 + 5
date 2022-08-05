
-- Bài 4
-- 1 Liệt kê tên nhân viên, mã phòng ban và lương nhân viên được tăng 15% (PCTSAL)
select ENAME , DEPTNO , SAL * 0.15 + SAL as PCTSAL from EMP where SAL is not null ;

-- 2 . Viết câu lệnh hiển thị như sau
-- KING*** *PRESIDENT
-- BLAKE*** **MANAGER
-- CLARK*** **MANAGER
-- JONES*** **MANAGER
select  rpad(  ENAME, length( ENAME ) + 3 , '*' ) || lpad( JOB ,10 , '*' )
from EMP where JOB is not null order by  JOB desc ;

-- 3 . Viết câu lệnh hiển thị như sau:
-- KING (President)
-- BLAKE (Manager)
-- CLARK (Manager)
-- JONES (Manager)
select concat( concat(concat( ENAME , '  ('  ) , JOB  ) , ')')   as EMPLOYEE from EMP where JOB is not null ;

-- 4 . Viết câu lệnh hiển thị như sau
-- ENAME DEPTNO JOB
-- BLAKE 30 Manager
-- MARTIN 30 Salesperson
select ENAME , DEPTNO  , INITCAP(replace( JOB , 'SALESMAN' , 'saleperson') )  as JOB from EMP where  DEPTNO = 30 ;

-- 5. Tìm ngày thứ 6 đầu tiên cách 2 tháng so với ngày hiện tại hiển thị ngày dưới dạng 09
--   February 1990.
select (case
        when to_char( next_day(  add_months( current_date  , 2  ) , 'FRI') , 'w' ) = 2
            then to_char(( next_day(  add_months( current_date , 2  )  , 'FRI') - 7 ) , 'dd MM yyyy' )
       when to_char( next_day(  add_months(  current_date, 2  ) , 'FRI') , 'w' ) = 3
           then to_char(( next_day(  add_months( current_date , 2  )  , 'FRI') - 14 ) , 'dd MM yyyy' )
       when to_char( next_day(  add_months( current_date , 2  ) , 'FRI') , 'w' ) = 4
           then to_char(( next_day(  add_months(  current_date, 2  )  , 'FRI') - 21) , 'dd MM yyyy' )
       else to_char( next_day(  add_months( current_date , 2  ) , 'FRI') , 'dd MM yyyy' )
    end
    )   as FirstFriday from DUAL ;

-- 6. Tìm thông itn về tên nhân viên, ngày gia nhập công ty của nhân viên phòng số 20,
-- sao cho hiển thị như sau:

select ENAME , TO_CHAR( HIREDATE , 'month, ddspth yyyy') as Date_hire from EMP where  DEPTNO = 20 and HIREDATE is not null ;

-- 7. Hiển thị tên nhân viên, ngày gia nhập công ty, ngày xét nâng lương (sau ngày gia
-- nhập công ty 1 năm), sắp xếp theo thứ tự ngày xét nâng lương
select ENAME , TO_CHAR( HIREDATE , 'dd-mm-yyyy') as HIREDATE ,
       TO_CHAR(ADD_MONTHS( HIREDATE , 12 ) , 'dd-mm-yyyy')  as REVIEW from EMP
       where HIREDATE is not null
       order by  TO_DATE( REVIEW , 'dd-mm-yyyy');
-- 8. Hiển thị tên nhân viên và lương dưới dạngKING 5000
-- MARTIN BELOW 1500
-- MILLER BELOW 1500
-- SCOTT 3000
-- SMITH BELOW 1500
-- TURNER On Target
-- WARD BELOW 1500
select ENAME , ( case
                     when SAL > 1500 then trim(SAL)
                     when SAL < 1500 then replace( SAL , SAL , 'BLOW 1500')
      when SAL = 1500 then replace( SAL , SAL , 'On Target')

    end
    ) as Sal
from EMP where  SAL is not null ;

-- 9 . Cho biết thứ của ngày hiện tại
select to_char( current_date , 'DAY' ) as THU from DUAL  ;

-- 10  Đưa chuỗi dưới dạng nn/nn, kiểm tra nếu khúng khuôn dạng trả lời là YES, ngược lại
-- là NO. Kiểm tra với các chuỗi 12/34, 01/1a, 99\88

-- select decode( '12/34' , '12/34' , 'YES' , 'NO' )  ;

-- 11 . Hiển thị tên nhân viên, ngày gia nhập công ty, ngày lĩnh lương sao cho ngày lĩnh
-- lương phải vào thứ 6, nhân viên chỉ được nhận lương sau ít nhất 15 ngày làm việc tại
-- công ty, sắp xếp theo thứ tự ngày gia nhập công ty.

select ENAME , HIREDATE, TO_CHAR(  next_day( HIREDATE + 15, 'FRI' )  , 'dd-mm') as NgayNhanLuong from EMP where
            current_date  - 15 > HIREDATE and HIREDATE is not null order by HIREDATE asc ;
-- Bài 4.5 Hàm trên nhóm dữ liệu
-- 1. Tìm lương thấp nhất, lớn nhất và lương trung bình của tất cả các nhân viên

    select MIN(SAL) as SALMIN , MAX( SAL) as MAXSAL , floor( AVG( SAL) )  as AVGSAL from EMP ;

-- 2. Tìm lương nhỏ nhất và lớn của mỗi loại nghề nghiệp

    select Min(SAL) as MINSAL , MAX(SAL) as MAXSAL,  JOB from EMP where SAL is not null group by JOB ;

-- 3. Tìm xem có bao nhiêu giám đốc trong danh sách nhân viên.

    select count(JOB) as TheNumberOfPresident from EMP where  JOB like 'PRESIDENT'


-- 4. Tìm tất cả các phòng ban mà số nhân viên trong phòng >3

   select DEPTNO , DNAME  from DEPT where DEPTNO in
                ( select EMP.DEPTNO from EMP having  count( EMP.DEPTNO) > 3 group by EMP.DEPTNO);


-- 5. Tìm ra mức lương nhỏ nhất của mỗi nhân viên làm việc cho một giám đốc nào đó
-- sắp xếp theo thứ tự tăng dần của mức lương.
select DEPTNO , MIN( SAL) as MINSAL  from EMP
    where DEPTNO in ( select  DEPTNO from EMP where JOB = 'PRESIDENT' ) group by DEPTNO;


-- Bài 5
-- 1 Hiển thị toàn bộ tên nhân viên và tên phòng ban làm việc sắp xếp theo tên phòng
-- ban.
select ENAME , DNAME  from EMP E , DEPT D where D.DEPTNO (+)= E.DEPTNO order by DNAME asc ;

-- 2 . Hiển thị tên nhân viên, vị trí địa lý, tên phòng với điều kiện lương >1500.
select E.ENAME , LOC , D.DNAME  from  EMP E , DEPT D where  D.DEPTNO (+)= E.DEPTNO and SAL > 1500 ;

-- 3 . Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương
select E.ENAME , E.JOB , E.SAL , S.GRADE from EMP E, SALGRADE S where E.SAL between  S.LOSAL and S.HISAL ;

-- 4  Hiển thị tên nhân viên, nghề nghiệp, lương và mức lương, với điều kiện mức
-- lương=3.

select E.ENAME , E.JOB , E.SAL , S.GRADE from EMP E, SALGRADE S where E.SAL between  S.LOSAL and S.HISAL and S.GRADE = 3;

-- 5 Hiển thị những nhân viên tại DALLAS
select ENAME , LOC , SAL  from EMP join DEPT D on EMP.DEPTNO = D.DEPTNO where LOC like 'DALLAS' ;

-- 6. Hiển thị tên nhân viên , nghề nghiệp, lương, mức lương, tên phòng làm việc trừ nhân
-- viên có nghề là clerk và sắp xếp theo chiều giảm.

select E.ENAME , E.JOB , E.SAL , S.GRADE , D.DNAME
from EMP E join DEPT D on E.DEPTNO = D.DEPTNO , SALGRADE S
where E.SAL between  S.LOSAL and S.HISAL and E.JOB not like 'CLERK' order by D.DNAME desc ;

-- 7 Hiển thị chi tiết về những nhân viên kiếm được 36000 $ 1 năm hoặc nghề là clerk.
-- (gồm các trường tên, nghề, thu nhập, mã phòng, tên phòng, mức lương)

select E.ENAME , E.JOB , E.SAL * 12 as ANUAL_SAL , D.DEPTNO , D.DNAME , GRADE
from EMP E join DEPT D on E.DEPTNO = D.DEPTNO , SALGRADE S
where E.SAL between  S.LOSAL and S.HISAL and ( E.SAL * 12 >= 36000 or E.JOB like 'CLERK' ) ;

-- 8  Hiển thị những phòng không có nhân viên nào làm việc.

select * from DEPT where DEPTNO not in ( select distinct  EMP.DEPTNO from EMP where  EMP.DEPTNO is not null );


-- 9 . Hiển thị mã nhân viên, tên nhân viên, mã người quản lý, tên người quản lý
SELECT e.ENAME emp_name,
       e.SAL   emp_sal,
       m.ENAME mgr_name,
       m.SAL   mgr_sal
FROM EMP e,
     EMP m
WHERE e.mgr = m.empno
  AND e.sal < m.sal;

-- 10

-- 11 . Hiển thị nghề nghiệp được tuyển dụng vào năm 1981 và không được tuyển dụng vào
-- năm 1994.

select distinct JOB  from EMP where TO_CHAR( HIREDATE , 'yyyy') like 1981
            and JOB not in ( select distinct JOB from EMP where TO_CHAR( HIREDATE , 'yyyy') like 1994 ) ;

-- 12 Tìm những nhân viên gia nhập công ty trước giám đốc của họ.

SELECT *
FROM EMP
WHERE HIREDATE < ALL (SELECT HIREDATE FROM EMP WHERE JOB = 'MANAGER')
  AND JOB != 'MANAGER';

-- 13  Tìm tất cả các nhân viên, ngày gia nhập công ty, tên nhân viên, tên người giám đốc
-- và ngày gia nhập công ty của người giám đốc ấy.

-- 14 . Tìm những nhân viên kiếm được lương cao nhất trong mỗi loại nghề nghiệp.


-- 15. Tìm mức lương cao nhất trong mỗi phòng ban, sắp xếp theo thứ tự phòng ban.

select DNAME , EMP.DEPTNO ,  MAX( SAL)
from EMP join DEPT on EMP.DEPTNO = DEPT.DEPTNO where EMP.DEPTNO is not null group by EMP.DEPTNO , DNAME ;

select SAL , DEPTNO from EMP  order by DEPTNO desc  ;

-- 16 Tìm nhân viên gia nhập vào phòng ban sớm nhất

select  ENAME , HIREDATE from EMP where
        DEPTNO in (  select  DEPTNO from EMP where JOB like 'PRESIDENT' )

-- 17 . Hiển thị những nhân viên có mức lương lớn hơn lương TB của phòng ban mà họ làm
-- việc.



-- 18  . Hiển thị tên nhân viên, mã nhân viên, mã giám đốc, tên giám đốc, phòng ban làm
-- việc của giám đốc, mức lương của giám đốc.

Select job from emp where deptno = 10
Union
Select job from emp where deptno = 30;