create database QLstore
go
use QLstore
go
CREATE TABLE SanPham(
   maSP  VARCHAR (10) primary key,
   tenSP NVARCHAR (30) NOT NULL, 
   loaiSP NVARCHAR (30) NOT NULL,
   soLuong int NOT NULL,
);


INSERT SanPham([maSP], [tenSP],[loaiSP],[soLuong]) VALUES ('SP1', N'Banh', N'Thuc Pham', 30)
INSERT SanPham([maSP], [tenSP],[loaiSP],[soLuong]) VALUES ('SP2', N'Keo', N'Thuc Pham',28)
INSERT SanPham([maSP], [tenSP],[loaiSP],[soLuong]) VALUES ('SP3', N'Sua',N'Thuc Pham' , 43)

 