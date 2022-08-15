create table LM_THUY_NHAXUATBAN (
     ID NUMBER(4) PRIMARY KEY  ,
     MA NVARCHAR2(5) unique ,
     TEN NVARCHAR2(60) ,
     TRANGTHAI INT  ,
     DIACHI NVARCHAR2(120) ,
     MOTA NVARCHAR2(255)
)

create table  LM_THUY_TACGIA(
    ID NUMBER(4) PRIMARY KEY  ,
    MA NVARCHAR2(5) unique ,
    TEN NVARCHAR2(50) ,
    SDT NVARCHAR2(13) ,
    DIACHI NVARCHAR2(120) ,
    MOTA NVARCHAR2(255)
)

create table  LM_THUY_SACH (
    ID NUMBER(4) PRIMARY KEY  ,
    MA NVARCHAR2(5) unique ,
    TEN NVARCHAR2(40) ,
    ID_NXB NUMBER(4) ,
    ID_TACGIA NUMBER(4) ,
    CHUDE NVARCHAR2(30) ,
    NAMSANXUAT DATE ,
    MOTA NVARCHAR2(255) ,
    SOLUONGCON INT CHECK ( SOLUONGCON > 0 ),
    SOLUONGMUON INT ,
    TONGSOSACH INT ,
    FOREIGN KEY (ID_NXB) REFERENCES LM_THUY_NHAXUATBAN(ID) ,
    FOREIGN KEY (ID_TACGIA) REFERENCES LM_THUY_TACGIA(ID)
)

alter table LM_THUY_SACH modify ( TONGSOSACH number(1))

create table LM_THUY_BANDOC (
    ID NUMBER(4) PRIMARY KEY  ,
    MA NVARCHAR2(5) unique ,
    TEN NVARCHAR2(40) ,
    SDT NVARCHAR2(13) ,
    DIACHI NVARCHAR2(255) ,
    NGAYSINH DATE ,
    NGAYTAOTAIKHOAN DATE ,
    HANG INT
)

CREATE TABLE  LM_THUY_MUONSACH (
    ID NUMBER(4) PRIMARY KEY  ,
    ID_BANDOC NUMBER(4) ,
    ID_SACH NUMBER(4) ,
    SOLUONG INT check ( SOLUONG < 5 ),
    NGAYGIOMUON date ,
    NGAYTRA DATE ,
    TRANGTHAI INT ,
    GHICHU NVARCHAR2(100) ,
    FOREIGN KEY (ID_BANDOC ) REFERENCES LM_THUY_BANDOC (ID) ,
    FOREIGN KEY (ID_SACH ) REFERENCES  LM_THUY_SACH(ID)
);
-- Câu 1

create index LM_THUY_BANDOC_INDEX_ID on LM_THUY_BANDOC(ID) ;
create index LM_THUY_SACH_INDEX_ID on LM_THUY_SACH(ID) ;

-- Câu 2

create sequence LM_THUY_MUONSACH_SEQ
increment by 1
start with 1

create sequence  LM_THUY_SACH_SEQ
increment by 1
start with 1

create sequence  LM_THUY_NHAXUATBAN_SEQ
    increment by 1
    start with 1


create sequence  LM_THUY_BANDOC_SEQ
    increment by 1
    start with 1

create sequence   LM_THUY_TACGIA_SEQ
    increment by 1
    start with 1;

-- Câu 3

create unique index NHAXUATBAN_IDX_ID on LM_THUY_NHAXUATBAN(MA) ;
create unique index TACGIA_IDX_ID ON LM_THUY_TACGIA(MA) ;
create unique index SACH_IDX_ID on LM_THUY_SACH(MA) ;
create unique index BANDOC_IDX_ID on LM_THUY_BANDOC(MA) ;

-- Câu 4
-- Insert nhà xuất bản
insert into LM_THUY_NHAXUATBAN( ID, MA, TEN, TRANGTHAI, DIACHI, MOTA)
values (LM_THUY_NHAXUATBAN_SEQ.nextval , 'NXBMS' , 'LÊ MINH THỤY' , 1 , 'SƠN TÂY HÀ NỘI' , 'nhà xuất bản chuyên nghiệp' ) ;
insert into LM_THUY_NHAXUATBAN( ID, MA, TEN, TRANGTHAI, DIACHI, MOTA)
values (LM_THUY_NHAXUATBAN_SEQ.nextval , 'NXBKM' , 'KIM ĐỒNG' , 1 , 'HÀ NỘI' , 'nhà xuất bản vui vẻ' ) ;

-- Insert Tác giả
insert into LM_THUY_TACGIA(ID, MA, TEN, SDT, DIACHI, MOTA)
values ( LM_THUY_TACGIA_SEQ.nextval , 'TGCSA' , 'NGUYỄN VIẾT HIÊN' , '0358832999' , 'Thạch thất hà nội' , 'Mat nguy hieerm kho gaafn') ;
insert into LM_THUY_TACGIA(ID, MA, TEN, SDT, DIACHI, MOTA)
values ( LM_THUY_TACGIA_SEQ.nextval , 'TGCHS' , 'SIÊU NHÂN' , '0353432999' , 'Sơn tây hà nội' , 'tính cách hiên lành') ;
-- Insert Sách
insert into LM_THUY_SACH(ID, MA, TEN, ID_NXB, ID_TACGIA, CHUDE, NAMSANXUAT, MOTA, SOLUONGCON, SOLUONGMUON, TONGSOSACH)
values ( LM_THUY_SACH_SEQ.nextval , 'KDISC' , 'chiếc lá cuối cùng' , 2 , 2 , 'văn học' , to_date( '2022-04-06' , 'yyyy-mm-dd' ) , 'Cuốn sách nói về niềm tin vượt qua bệnh tật' , 19 , 20 , 29 ) ;
insert into LM_THUY_SACH(ID, MA, TEN, ID_NXB, ID_TACGIA, CHUDE, NAMSANXUAT, MOTA, SOLUONGCON, SOLUONGMUON, TONGSOSACH)
values ( LM_THUY_SACH_SEQ.nextval , 'KDSHY' , 'tay tien' , 2 , 3 , 'văn học đương đại' ,  to_date( '2019-04-06' , 'yyyy-mm-dd') , 'Động viên quân đội để đánh giặc' , 25 , 5 , 30 ) ;
insert into LM_THUY_SACH(ID, MA, TEN, ID_NXB, ID_TACGIA, CHUDE, NAMSANXUAT, MOTA, SOLUONGCON, SOLUONGMUON, TONGSOSACH)
values ( LM_THUY_SACH_SEQ.nextval , 'KDSSY' , 'tay tien' , 2 , 3 , 'văn học đương đại' ,  to_date( '2019-04-06' , 'yyyy-mm-dd') , 'Động viên quân đội để đánh giặc' , 25 , 5 , 30 ) ;

-- Insert Bạn đọc
insert into LM_THUY_BANDOC(ID, MA, TEN, SDT, DIACHI, NGAYSINH, NGAYTAOTAIKHOAN, HANG)
values ( LM_THUY_BANDOC_SEQ.nextval , 'BDSSC' , 'ĐỖ TẤT Hòa' , '0945586555' , 'thường tín hà nội' , to_date( '2001-04-06' , 'yyyy-mm-dd' )  ,to_date( '2021-04-06' , 'yyyy-mm-dd' ) , 3 ) ;
insert into LM_THUY_BANDOC(ID, MA, TEN, SDT, DIACHI, NGAYSINH, NGAYTAOTAIKHOAN, HANG)
values ( LM_THUY_BANDOC_SEQ.nextval , 'BDCSC' , 'Hòa minzi' , '0934586555' , 'thanh xuân hà nội' , to_date( '2001-09-10' , 'yyyy-mm-dd' )  ,to_date( '2021-07-06' , 'yyyy-mm-dd' )   , 1 ) ;
insert into LM_THUY_BANDOC(ID, MA, TEN, SDT, DIACHI, NGAYSINH, NGAYTAOTAIKHOAN, HANG)
values ( LM_THUY_BANDOC_SEQ.nextval , 'BDCCC' , 'Hòa minzi' , '0934586555' , 'thanh xuân hà nội' , to_date( '2001-09-10' , 'yyyy-mm-dd' )  ,to_date( '2021-07-06' , 'yyyy-mm-dd' )   , 1 ) ;

-- Insert mượn sách
insert into LM_THUY_MUONSACH(ID, ID_BANDOC, ID_SACH, SOLUONG, NGAYGIOMUON, NGAYTRA, TRANGTHAI, GHICHU)
values ( LM_THUY_MUONSACH_SEQ.nextval , 34 , 3, 3 , to_date('2022-08-01' , 'yyyy-mm-dd')  , to_date('2022-09-01' , 'yyyy-mm-dd')  , 1 , 'Trả treex han nha') ;
insert into LM_THUY_MUONSACH(ID, ID_BANDOC, ID_SACH, SOLUONG, NGAYGIOMUON, NGAYTRA, TRANGTHAI, GHICHU)
values ( LM_THUY_MUONSACH_SEQ.nextval , 35, 3 , 2 ,  to_date('2022-07-05' , 'yyyy-mm-dd') , to_date('2022-09-01' , 'yyyy-mm-dd') , 2 , 'Trả treex han nha') ;

-- Câu 5	Hiển thị dách sách tác giả và tổng số lượng sách của tác giả gồm các trường thông tin:
-- Mã Tác Giả, Tên Tác Giả, Chủ Đề, Số Lượng Sách
-- Sắp xếp theo số lượng sách giảm dần.

select LTT.MA , LTT.TEN , S.CHUDE ,   S.TONGSOSACH  from LM_THUY_SACH s inner join  LM_THUY_TACGIA LTT on s.ID_TACGIA = LTT.ID
order by S.TONGSOSACH desc


-- 6.	Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất gồm các trường thông tin:
-- Mã Sách, Tên Sách, Tên Nhà Xuất Bản, Tên Tác Giả, Chủ Đề, Năm Xuất Bản, Số Lượng Còn Lại, Số Lượng Đã Mượn, Tổng Số

select S.MA as MASACH, S.TEN as TENSACH , LTN.TEN  as TEN_NXB , LTT.TEN as TEN_TACGIA , S.CHUDE ,s.NAMSANXUAT , s.SOLUONGCON , s.SOLUONGMUON , s.TONGSOSACH  from LM_THUY_SACH S
                                                     inner join LM_THUY_NHAXUATBAN LTN on S.ID_NXB = LTN.ID
                                                     inner join  LM_THUY_TACGIA LTT on S.ID_TACGIA = LTT.ID
                                                     WHERE ROWNUM <= 10
                                                     ORDER BY S.SOLUONGMUON DESC  ;


-- 7.	Hiển thị  thông tin bạn đọc và sách được mượn từ ngày đầu tháng hiện tại đến thời điểm hiện tại.5
-- Mã Bạn Đọc, Tên Bạn Đọc, Mã Sách, Tên Sách, Ngày Giờ Mượn, Số lượng
-- Sắp xếp theo ngày giờ mượn giảm dần, Tên bạn đọc tăng dần.

select B.MA as MA_BANDOC , B.TEN as TEN_BANDOC , S.MA as MA_SACH , S.TEN as TENSACH, M.NGAYGIOMUON , M.SOLUONG  from LM_THUY_SACH S
INNER JOIN  LM_THUY_MUONSACH M on S.ID = M.ID_SACH
INNER JOIN LM_THUY_BANDOC B on M.ID_BANDOC = B.ID
WHERE NGAYGIOMUON between TRUNC( CURRENT_DATE , 'MONTH') and CURRENT_DATE
ORDER BY M.NGAYGIOMUON DESC  , B.TEN ASC  ;


-- 8.	Hiển thị 10 quyển sách có số lượng được mượn nhiều nhất tính từ đầu năm 2022
-- Mã Sách, Tên Sách, Số Lượng Đã Được Mượn.

select s.ma as MASACH , s.TEN as TENSACH , sum( M.SOLUONG) as SoLuongDaMuon
from LM_THUY_SACH s inner join LM_THUY_MUONSACH m on s.ID = m.ID_SACH
where to_char( m.NGAYGIOMUON , 'yyyy') >= 2022 and ROWNUM <= 10
group by s.ma, s.TEN
order by sum( M.SOLUONG) desc
;


-- 9.	Hiển thị danh sách bạn đọc và số lần mượn sách tính từ đầu năm 2022 sắp xếp theo tên bạn đọc tăng dần:
-- Mã Bạn Đọc, Tên Bạn Đọc, Số Lần Mượn

select b.MA as MA_BANDOC , b.TEN as TEN_BANDOC , count(m.ID_BANDOC) as SOLANMUON from LM_THUY_BANDOC b
inner join LM_THUY_MUONSACH m on b.ID = m.ID_BANDOC
where to_char( m.NGAYGIOMUON , 'yyyy') >= 2022
group by b.MA, b.TEN
order by count(m.ID_BANDOC) asc  ;

select * from LM_THUY_BANDOC ;

-- 10.	Hiển thị thông tin bạn đọc gồm có:
-- Mã Bạn Đọc, Tên Bạn Đọc, Tuổi (được tính dựa vào trường ngày sinh)

select b.MA as MA_BANDOC , b.TEN  as TEN_BANDOC, ( to_char(SYSDATE , 'yyyy') - to_char( b.NGAYSINH , 'yyyy') ) as TUOI from LM_THUY_BANDOC b;

-- 11.	Thống kê tổng số bạn đọc theo độ tuổi
-- Tuổi, Tổng số Bạn Đọc

select ( to_char(SYSDATE , 'yyyy') - to_char( NGAYSINH , 'yyyy') ) as TUOI  ,
       count(( to_char(SYSDATE , 'yyyy') - to_char( NGAYSINH , 'yyyy') ))as TONGSOBANDOC from LM_THUY_BANDOC
       group by ( to_char(SYSDATE , 'yyyy') - to_char( NGAYSINH , 'yyyy') );

-- 12.	Thống kê số lượng sách được xuất bản theo Nhà Xuất Bản, Theo năm xuất bản.
-- Năm Xuất Bản, Mã Nhà Xuất Bản,Tên Nhà Xuất Bản, Số Lượng Sách
-- Sắp xếp theo Năm xuất bản giảm dần, Tên Nhà xuất bản tăng dần.

select b.MA as MA_NHAXUATBAN, b.TEN as TEN_NXB , TO_CHAR(s.NAMSANXUAT , 'yyyy')  , sum( s.TONGSOSACH ) as SOLUONGSACH
from LM_THUY_NHAXUATBAN B inner join LM_THUY_SACH S on B.ID = S.ID_NXB
group by b.MA, b.TEN, s.NAMSANXUAT
order by TO_CHAR(s.NAMSANXUAT , 'yyyy') desc  , b.TEN asc ;

-- 13.	Hiển thị 5 quyển sách được các bạn đọc có độ tuổi từ 18 đến 25 mượn nhiều nhất tính từ đầu năm 2022. (Tính theo trường số lượng mượn của sách)
-- Mã Sách, Tên Sách, Số Lượng Được Mượn

select LTS.MA as MA_SACH , LTS.TEN as TENSACH , sum( LTM.SOLUONG ) as SOLUONGMUON  from LM_THUY_BANDOC
                                  inner join LM_THUY_MUONSACH LTM on LM_THUY_BANDOC.ID = LTM.ID_BANDOC
                                  inner join LM_THUY_SACH LTS on LTM.ID_SACH = LTS.ID
where ROWNUM <= 5 and ( to_char(SYSDATE , 'yyyy') - to_char( NGAYSINH , 'yyyy') ) between 18 and 25 and to_char(LTM.NGAYGIOMUON , 'yyyy') >= 2022
group by LTS.MA, LTS.TEN
order by sum( LTM.SOLUONG ) desc

-- 14.	Hiển thị toàn bộ bạn đọc và sách mà bạn đọc đấy mượn, sẽ có bạn chưa mượn vẫn cần hiển thị và tên sách để là null.
-- Mã bạn đọc, tên ban đọc, tên sách

select  b.MA , b.TEN as TEN_BANDOC , LTS.TEN as TEN_SACH from LM_THUY_BANDOC b left join LM_THUY_MUONSACH LTM on b.ID = LTM.ID_BANDOC
                                                      left join LM_THUY_SACH LTS on LTM.ID_SACH = LTS.ID;

create table KAKA(
     id int
)