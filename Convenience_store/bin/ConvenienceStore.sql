--create database QLstore
--go

use QLstore
go
CREATE TABLE SanPham(
   maSP  VARCHAR (10) primary key,
   tenSP NVARCHAR (50) NOT NULL, 
   loaiSP NVARCHAR (50) NOT NULL,
   soLuong int NOT NULL,
);
CREATE TABLE DaySanPham(
	ngayNhap DateTime NOT NULL,
	ngaySanXuat DateTime NOT NULL,
	NgayHetHan DateTime NOT NULL,
	FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);
CREATE TABLE DonGia (
    donGiaNhap FLOAT NOT NULL,
    donGiaBan FLOAT NOT NULL,
    donGiaKhuyenMai FLOAT,
);
CREATE TABLE ChuongTrinhKhuyenMai(
	maKM VARCHAR (10) primary key,
	han DateTime NOT NULL,
	loaiKM NVARCHAR (50) NOT NULL,

);
CREATE TABLE ChiTietKhuyenMai(
	maCTKM VARCHAR (10) primary key,
	mucGiamGia FLOAT NOT NULL,
	quaTang NVARCHAR (50),
	dieuKien NVARCHAR(50),
	moTA NVARCHAR (100),


	
);


INSERT SanPham([maSP], [tenSP],[loaiSP],[soLuong]) VALUES ('SP1', N'Banh', N'Thuc Pham', 30)
INSERT SanPham([maSP], [tenSP],[loaiSP],[soLuong]) VALUES ('SP2', N'Keo', N'Thuc Pham',28)
INSERT SanPham([maSP], [tenSP],[loaiSP],[soLuong]) VALUES ('SP3', N'Sua',N'Thuc Pham' , 43)

 