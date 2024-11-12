CREATE DATABASE QLStore;
GO

USE QLStore;
GO

CREATE TABLE SanPham (
    maSP VARCHAR(10) PRIMARY KEY,
    tenSP NVARCHAR(150) NOT NULL, 
    loaiSP NVARCHAR(50) NOT NULL,
    soLuong INT NOT NULL,
    xuatXu NVARCHAR(50) NOT NULL,
    thuongHieu NVARCHAR(50) NOT NULL,
    moTa NVARCHAR(150),
    nhaSanXuat NVARCHAR(150),
    donGia FLOAT NOT NULL
);

CREATE TABLE DaySanPham (
    maSP VARCHAR(10) NOT NULL,
    ngayNhap DATETIME NOT NULL,
    ngaySanXuat DATETIME NOT NULL,
    ngayHetHan DATETIME NOT NULL,
    FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);

CREATE TABLE DonGia (
    maSP VARCHAR(10) NOT NULL,
    donGiaNhap FLOAT NOT NULL,
    donGiaBan FLOAT NOT NULL,
    donGiaKhuyenMai FLOAT,
    FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);

CREATE TABLE ChuongTrinhKhuyenMai (
    maKM VARCHAR(10) PRIMARY KEY,
    maSP VARCHAR(10) NOT NULL,
    han DATETIME NOT NULL,
    loaiKM NVARCHAR(50) NOT NULL,
    FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);

CREATE TABLE ChiTietKhuyenMai (
    maCTKM VARCHAR(10) PRIMARY KEY,
    maKM VARCHAR(10) NOT NULL,
    mucGiamGia FLOAT NOT NULL,
    quaTang NVARCHAR(50),
    dieuKien NVARCHAR(50),
    moTa NVARCHAR(100),
    FOREIGN KEY (maKM) REFERENCES ChuongTrinhKhuyenMai(maKM)
);

CREATE TABLE TaiKhoan (
    maTK VARCHAR(10) PRIMARY KEY,
    tenNguoiDung NVARCHAR(50) NOT NULL,
    matKhau NVARCHAR(50) NOT NULL
);

CREATE TABLE NhanVien (
    maNV VARCHAR(10) PRIMARY KEY,
    tenNV NVARCHAR(50) NOT NULL,
    ngaySinh date,
    diaChi NVARCHAR(50),
    gioiTinh CHAR(1) NOT NULL,
    luong FLOAT NOT NULL,
    ngayVaoLam date,
    sdt varchar(15) NOT NULL,
    maTK VARCHAR(10),
    FOREIGN KEY (maTK) REFERENCES TaiKhoan(maTK)
);

CREATE TABLE BaoCao (
    maBaoCao VARCHAR(10) PRIMARY KEY,
    maNV VARCHAR(10) NOT NULL,
    tenBaoCao NVARCHAR(50) NOT NULL,
    ngayLap DATETIME,
    nguoiLap NVARCHAR(50) NOT NULL,
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV)
);

CREATE TABLE ChiTietBaoCao (
    maCTBaoCao VARCHAR(10) PRIMARY KEY,
    tenBaoCao NVARCHAR(50) NOT NULL,
    ngayLap DATETIME NOT NULL,
    nguoiLap NVARCHAR(50) NOT NULL,
    tongDoanhThu FLOAT NOT NULL,
    sLSPTonKho INT NOT NULL,
    sLSPHetHan INT NOT NULL,
    sLSPNhap INT,
    sLSPBan INT NOT NULL,
    FOREIGN KEY (maCTBaoCao) REFERENCES BaoCao(maBaoCao)
);

CREATE TABLE KhachHang (
    maKH VARCHAR(10) PRIMARY KEY,
    tenKH NVARCHAR(50) NOT NULL,
    ngaySinh DATETIME NOT NULL,
    gioiTinh CHAR(1) NOT NULL,
    loaiThanhVien NVARCHAR(50) NOT NULL
);

CREATE TABLE DatHangONL (
    maDatHang VARCHAR(10) PRIMARY KEY,
    maNV VARCHAR(10) NOT NULL,
    maKH VARCHAR(10) NOT NULL,
    tenKH NVARCHAR(50) NOT NULL,
    ngayDat DATETIME NOT NULL,
    tongTien FLOAT NOT NULL,
    tranhThaiThanhToan CHAR(1) NOT NULL,
    FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
    FOREIGN KEY (maKH) REFERENCES KhachHang(maKH)
);

CREATE TABLE HoaDon (
    maHoaDon VARCHAR(10) PRIMARY KEY,
    ngayLap DATE,
    tongTien INT,
    hinhThucThanhToan VARCHAR(20),
    maKH VARCHAR(10),
    maNV VARCHAR(10),
	FOREIGN KEY (maNV) REFERENCES NhanVien(maNV),
	FOREIGN KEY (maKH) REFERENCES KhachHang(maKH)
);

CREATE TABLE ChiTietHoaDon (
    maCTHoaDon VARCHAR(10) PRIMARY KEY,
    tenNguoiLap NVARCHAR(50) NOT NULL,
    ngayLap DATETIME NOT NULL,
    tenKH NVARCHAR(50) NOT NULL,
    tongSLSP INT NOT NULL,
    tongThanhTien FLOAT NOT NULL,
    FOREIGN KEY (maCTHoaDon) REFERENCES HoaDon(maHoaDon)
);

CREATE TABLE ChiTietDonDat (
    maCTDH VARCHAR(10) PRIMARY KEY,
    tenKH NVARCHAR(50) NOT NULL,
    tenNV NVARCHAR(50) NOT NULL,
    ngayDat DATETIME NOT NULL,
    tongSoLuongSP INT NOT NULL,
    tongTien FLOAT NOT NULL,
    tranhThaiThanhToan CHAR(1) NOT NULL,
    trangThai CHAR(1) NOT NULL,
    FOREIGN KEY (maCTDH) REFERENCES DatHangONL(maDatHang)
);

CREATE TABLE HDSP (
    maSP VARCHAR(10) NOT NULL,
    maCTHoaDon VARCHAR(10) NOT NULL,
    tenSP NVARCHAR(50) NOT NULL,
    donGia FLOAT NOT NULL,
    soLuong INT NOT NULL,
    PRIMARY KEY (maSP, maCTHoaDon),
    FOREIGN KEY (maCTHoaDon) REFERENCES ChiTietHoaDon(maCTHoaDon),
    FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);

CREATE TABLE OrderSP (
    maSP VARCHAR(10) NOT NULL,
    maCTDH VARCHAR(10) NOT NULL,
    tenSP NVARCHAR(50) NOT NULL,
    donGia FLOAT NOT NULL,
    soLuong INT NOT NULL,
    PRIMARY KEY (maSP, maCTDH),
    FOREIGN KEY (maCTDH) REFERENCES ChiTietDonDat(maCTDH),
    FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);






 --INSERT SP
 INSERT INTO SanPham (maSP, tenSP, loaiSP, soLuong, xuatXu, thuongHieu, moTa, nhaSanXuat, donGia) VALUES 
('SP0001', N'Toastie Sa Tế Chà Bông Kiểu Thái', N'Đồ Ăn', 30, N'Việt Nam', N'7-Select SSV', N'', N'', 23000),
('SP0002', N'Hot Dog Xúc Xích Classsic', N'Đồ Ăn', 20, N'Việt Nam', N'7-Select SSV', N'', N'', 25000),
('SP0003', N'Snack Slide Original 150g -T10', N'Đồ Ăn', 50, N'Malaysia', N'Slide', N'Sản phẩm: Snack Slide Original 150g', N'CÔNG TY TNHH PHÂN PHỐI TIÊN TIẾN', 47000),
('SP0004', N'Snack Slide Hot Spicy 150g -T10', N'Đồ Ăn', 50, N'Malaysia', N'Slide', N'Sản phẩm: Snack Slide Hot Spicy 150g', N'CÔNG TY TNHH PHÂN PHỐI TIÊN TIẾN', 49000),
('SP0005', N'Rong Biển O''Food Vị Mực 6g -T10', N'Đồ Ăn', 100, N'Việt Nam', N'O''Food', N'Sản phẩm: Rong Biển O''Food Vị Mực 6g', N'CHI NHÁNH CÔNG TY TNHH DAESANG VIỆT NAM', 15000),
('SP0006', N'Milo Sữa Lúa Mạch 180ml', N'Đồ Uống', 200, N'Việt Nam', N'Milo', N'Sản phẩm này là thức uống bổ sung', N'CÔNG TY TNHH PHÂN PHỐI QUẢ TÁO ĐỎ', 11000),
('SP0007', N'Sữa Sahmyook Đậu Đen ÓcChó HạnhNhân950ml', N'Đồ Uống', 150, N'Korea', N'Sahmyook', N'Sữa Sahmyook Hộp 950ml', N'CÔNG TY TNHH DỊCH VỤ VẠN LỘC PHÁT', 88000),
('SP0008', N'Sữa Tươi Tiệt Trùng TH Nguyên Chất 1L', N'Đồ Uống', 100, N'Việt Nam', N'TH True Milk', N'STTT TH Nguyên Chất 1L', N'CÔNG TY CP CHUỖI THỰC PHẨM', 48000),
('SP0009', N'Dasani Nước Tinh Khiết 1.5L Nước Suối Water', N'Đồ Uống Đóng chai', 300, N'Việt Nam', N'Dasani', N'Dasani Nước Tinh Khiết 1.5L Nước Suối', N'CÔNG TY TNHH NƯỚC GIẢI KHÁT COCA-COLA VIỆT NAM', 13000),
('SP0010', N'Lavie Nước Khoáng 1.5L Nước Suối Water', N'Đồ Uống Đóng chai', 250, N'Việt Nam', N'Lavie', N'Lavie Nước Khoáng 1.5L Nước Suối', N'CÔNG TY TNHH BÁN LẺ SONG MÃ', 13000),
('SP0011', N'Nước Aquafina 1.5L', N'Đồ Uống Đóng chai', 200, N'Việt Nam', N'Aquafina', N'Aquafina Nước Tinh Khiết 1,5L Nước Suối Aqua', N'CÔNG TY TNHH SẢN XUẤT DỊCH VỤ THƯƠNG MẠI XUẤT NHẬP KHẨU MINH QUANG', 13000),
('SP0012', N'Trứng Gà V.Food hộp x 6 trứng', N'Thực Phẩm', 100, N'Việt Nam', N'Vfood', N'Trứng Gà V.Food hộp x 6 trứng', N'CÔNG TY CP THỰC PHẨM VĨNH THÀNH ĐẠT', 22000),
('SP0013', N'Trứng Gà Nhật ISE Vỉ 6 Qủa', N'Thực Phẩm', 100, N'Việt Nam', N'Vfood', N'Trứng Gà ISE', N'CÔNG TY CP THỰC PHẨM VĨNH THÀNH ĐẠT', 25000),
('SP0014', N'Tôm Khô Hải Nam Size S 100g', N'Thực Phẩm', 50, N'Việt Nam', N'Hải Nam', N'Tôm Khô Hải Nam Size S 100g', N'CÔNG TY TNHH TM-SX HẢI NAM', 75000),
('SP0015', N'Xúc Xích Ponnie Phô Mai Cá 45g -T10', N'Đồ Ăn', 200, N'Việt Nam', N'masan', N'Sản phẩm: Xúc Xích Ponnie Phô Mai Heo 45g', N'HỢP TÁC XÃ THƯƠNG MẠI PHƯỜNG 14 QUẬN 3', 10000),
('SP0016', N'Gỏi Khô Gà Rau Răm 40g', N'Đồ Ăn', 150, N'Việt Nam', N'OHAYO', N'Sản phẩm: Gỏi KhôGà RauRăm Ohayo 40g', N'CÔNG TY CỔ PHẦN THƯƠNG MẠI DỊCH VỤ 3H VIỆT NAM', 15000),
('SP0017', N'Chân Gà Rút Xương Ohayo CayTê 60g', N'Đồ Ăn', 150, N'Việt Nam', N'OHAYO', N'Sản phẩm: Chân Gà RX Ohayo CayTê 60g', N'CÔNG TY CỔ PHẦN THƯƠNG MẠI DỊCH VỤ 3H VIỆT NAM', 20000),
('SP0018', N'Chà Bông Cá Hồi Tươi SG Food Gói 35g', N'Đồ Hộp', 100, N'Việt Nam', N'Saigon Food', N'Sản phẩm: Chà Bông Cá Hồi Tươi SGF Gói 35g', N'CÔNG TY CP SÀI GÒN FOOD', 30000),
('SP0019', N'Cá Hộp Ba Cô Gái 115g Tomato Sardines Canned Food', N'Đồ Hộp', 200, N'Việt Nam', N'Three Lady Cook', N'Sản phẩm: Cá Hộp Ba Cô Gái 115g', N'CÔNG TY TNHH THAI CORP INTERNATIONAL (VIỆT NAM)', 15000),
('SP0020', N'Cá Xốt Cà 3 Cô Gái 190g', N'Đồ Hộp', 200, N'Việt Nam', N'Three Lady Cook', N'Sản phẩm: Cá Xốt Cà 3 Cô Gái 190g', N'CÔNG TY TNHH THAI CORP INTERNATIONAL (VIỆT NAM)', 20000),
('SP0021', N'Thịt Hộp Spam Classic 340g', N'Đồ Hộp', 100, N'Unites States', N'Spam', N'Sản phẩm: Thịt Hộp Spam Class 340g', N'CÔNG TY TNHH TMDV TIẾP THỊ ĐỒNG THẮNG', 127000),
('SP0022', N'Cá Ngừ Ngâm Dầu Nautilus 170g Oily Fish Sardines Canned Food', N'Đồ Hộp', 150, N'Thailand', N'Nautilus', N'Tên sản phẩm: Cá Ngừ Ngâm Dầu Nautilus 170g', N'CÔNG TY TNHH NAUTILUS FOOD (VIỆT NAM)', 57000),
('SP0023', N'Đường Mía Biên Hòa T.Hạng 1kg', N'Gia Vị', 200, N'Việt Nam', N'Đường Biên Hòa', N'Sản phẩm : Đường BH/Mía T.Hạng 1kg', N'CÔNG TY CỔ PHẦN HÀNG TIÊU DÙNG BIÊN HÒA', 35000),
('SP0024', N'Dầu Ăn Gạo Lứt Simply 1L', N'Gia Vị', 150, N'Việt Nam', N'Simply', N'Sản phẩm: Dầu Gạo Lứt Simply 1L', N'CÔNG TY TNHH MỘT THÀNH VIÊN PHẠM ANH', 89000),
('SP0025', N'Dầu ăn Simply 1L Cooking Oil', N'Gia Vị', 150, N'Việt Nam', N'Simply', N'Sản phẩm: Dầu ăn Simply 1L new', N'CÔNG TY TNHH MỘT THÀNH VIÊN PHẠM ANH', 8500),
('SP0026', N'Dầu Gội H&S Bạc Hà 625ml Shampoo', N'Dầu Gội', 100, N'Việt Nam', N'Head & Shoulders', N'Sản phẩm: Dầu Gội H&S Bạc Hà 625ml', N'CHI NHÁNH CÔNG TY TNHH DỊCH VỤ VÀ THƯƠNG MẠI MESA', 212000),
('SP0027', N'Dầu Gội Clear Bạc Hà 630g Shampoo', N'Dầu Gội', 100, N'Việt Nam', N'Clear', N'Sản phẩm: Dầu Gội Clear Bạc Hà 630g', N'HỢP TÁC XÃ THƯƠNG MẠI QUẬN 3', 214000),
('SP0028', N'Tắm Gội 2in1 Romano 180g -T10', N'Dầu Gội', 150, N'Việt Nam', N'Romano', N'Sản phẩm: Tắm Gội 2in1 Romano 180g', N'CÔNG TY CP THƯƠNG MẠI DỊCH VỤ QUẬN 3', 55000),
('SP0029', N'Bột Giặt Omo 380g', N'Nước Giặt', 200, N'Việt Nam', N'Omo', N'Sản phẩm: BG Omo 380g', N'HỢP TÁC XÃ THƯƠNG MẠI QUẬN 3', 28000),
('SP0030', N'Nước Giặt Omo Giữ Màu Túi 2.8kg -T10', N'Nước Giặt', 150, N'Việt Nam', N'Omo', N'Sản phẩm: Nước Giặt Omo Giữ Màu Túi 2.8kg', N'HỢP TÁC XÃ THƯƠNG MẠI QUẬN 3', 18000),
('SP0031', N'Nước Giặt Downy Biển Xanh 2.65kg', N'Nước Giặt', 150, N'Việt Nam', N'Downy', N'Sản phẩm: Nước Giặt Downy Biển Xanh 2.65kg', N'CHI NHÁNH CÔNG TY TNHH DỊCH VỤ VÀ THƯƠNG MẠI MESA', 232000),
('SP0032', N'Thùng 24 lon bia Tiger crystal lon 330ml', N'Đồ Uống Có Cồn', 200, N'Việt Nam', N'Tiger', N'Bia Tiger Crystal lon 330ml', N'CÔNG TY CỔ PHẦN BIA- RƯỢU – NƯỚC GIẢI KHÁT SÀI GÒN', 410000),
('SP0033', N'Bia 333 Export thùng 24 lon x 330ml', N'Đồ Uống Có Cồn', 200, N'Việt Nam', N'Bia 333', N'Bia 333 Export lon 330ml', N'CÔNG TY CỔ PHẦN BIA- RƯỢU – NƯỚC GIẢI KHÁT SÀI GÒN', 277000),
('SP0034', N'Nước giải khát Coca Cola chai 1.5lít', N'Đồ Uống Đóng chai', 300, N'Việt Nam', N'Coca cola', N'Nước giải khát Coca Cola chai 1.5L', N'CÔNG TY CỔ PHẦN BIA- RƯỢU – NƯỚC GIẢI KHÁT SÀI GÒN', 20000),
('SP0035', N'Thùng 30 gói mì xào khô vị tôm xào chua ngọt Hảo Hảo 75g', N'Thực Phẩm Ăn Liền', 500, N'Việt Nam', N'Acecook', N'Mì xào khô vị tôm xào chua ngọt Hảo Hảo gói 75g', N'Công Ty Cp Acecook Việt Nam', 127000),
('SP0036', N'Phở thịt bò Vifon gói 65g', N'Thực Phẩm Ăn Liền', 400, N'Việt Nam', N'Vifon', N'Phở thịt bò Vifon gói 65g', N'Công Ty Cp Vifon Việt Nam', 9200),
('SP0037', N'Mì trộn tương đen Samyang gói 140g', N'Thực Phẩm Ăn Liền', 300, N'Korea', N'Samyang', N'Mì trộn tương đen Samyang', N'Công Ty Cp Samyang Việt Nam', 32500),
('SP0038', N'Bột ngọt (mì chính) Ajinomoto 400g', N'Gia Vị', 200, N'Việt Nam', N'Ajinomoto', N'Bột ngọt (mì chính) Ajinomoto gói 400g', N'Công Ty Cp Ajinomoto Việt Nam', 33000),
('SP0039', N'Muối biển Visaco Mặt trời (tinh) 450g', N'Gia Vị', 150, N'Việt Nam', N'Visaco', N'Muối biển Visaco Mặt trời (tinh) 450g', N'Công Ty Cp Visaco Việt Nam', 6700),
('SP0040', N'Tương ớt chua ngọt Cholimex PET 2.1kg', N'Gia Vị', 100, N'Việt Nam', N'Cholimex PET', N'Tương ớt chua ngọt Cholimex PET 2.1kg', N'Công Ty Cp Cholimex PET Việt Nam', 66500),
('SP0041', N'Nước tương Tam Thái Tử Nhất Ca chai 500ml', N'Gia Vị', 200, N'Việt Nam', N'Masan', N'Nước tương Tam Thái Tử Nhất Ca chai 500ml', N'Công ty cổ phần Hàng tiêu dùng Masan', 20100),
('SP0042', N'Vỉ 5 bút bi Thiên Long TL027', N'Văn Phòng Phẩm', 300, N'Việt Nam', N'Thiên Long', N'Vỉ 5 bút bi Thiên Long TL027', N'Thiên Long là công ty chuyên về văn phòng phẩm', 23900),
('SP0043', N'Vỉ 2 Bút lông dầu Thiên Long PM09', N'Văn Phòng Phẩm', 200, N'Việt Nam', N'Thiên Long', N'Vỉ 2 Bút lông dầu Thiên Long PM09', N'Thiên Long là công ty chuyên về văn phòng phẩm', 23900),
('SP0044', N'Vỉ 2 cục Gôm Thiên Long 08', N'Văn Phòng Phẩm', 150, N'Việt Nam', N'Thiên Long', N'Vỉ 2 cục Gôm Thiên Long 08', N'Thiên Long là công ty chuyên về văn phòng phẩm', 9500),
('SP0045', N'Khăn Ướt Kin Kin Hương Trà Xanh Gói 100 Tờ', N'Văn Phòng Phẩm', 100, N'Việt Nam', N'Kin Kin', N'Khăn Ướt Kin Kin Hương Trà Xanh Gói 100 Tờ', N'CÔNG TY TNHH KIN KIN LOGISTICS', 43000),
('SP0046', N'Băng Vệ Sinh Kotex Max Cool Siêu Mỏng Cánh Gói 20 Miếng 23Cm', N'Thiết yếu', 200, N'Việt Nam', N'Kotex', N'Băng Vệ Sinh Kotex Max Cool Siêu Mỏng Cánh Gói 20 Miếng 23Cm', N'Kimberly-Clark Corporation tập đoàn chăm sóc cá nhân đa quốc gia', 45000),
('SP0047', N'Bao cao su Durex Invisible Extra Thin Extra Sensitive siêu mỏng, vừa vặn và ôm sát (3 cái)', N'Thiết yếu', 150, N'Anh', N'DUREX', N'Bao cao su Durex Invisible Extra Thin Extra Sensitive siêu mỏng, vừa vặn và ôm sát (3 cái)', N'Reckitt Benckiser công ty hàng tiêu dùng đa quốc gia Anh-Hà Lan', 89000),
('SP0048', N'Xà Bông Cục Lifebuoy Matcha & Khổ Qua 90G', N'Thiết yếu', 200, N'Việt Nam', N'Lifebuoy', N'Xà Bông Cục Lifebuoy Matcha & Khổ Qua 90G', N'', 17500),
('SP0049', N'Sữa Chống Nắng Sunplay Aqua Clear SPF50 25G', N'Thiết yếu', 100, N'Việt Nam', N'Sunplay', N'Sữa Chống Nắng Sunplay Aqua Clear SPF50 25G', N'CÔNG TY TNHH ROHTO-MENTHOLATUM (VIỆT NAM)', 116000),
('SP0050', N'Nước Súc Miệng Listerine Coolmint 750Ml', N'Thiết yếu', 150, N'Việt Nam', N'Listerine', N'Nước Súc Miệng Listerine Coolmint 750Ml', N'', 150000);


INSERT INTO DaySanPham(maSP, ngayNhap, ngaySanXuat, ngayHetHan) VALUES 
('SP0001', '2024-03-15', '2024-02-10', '2024-08-10'),
('SP0002', '2024-05-18', '2024-04-08', '2024-10-08'),
('SP0003', '2024-10-30', '2024-09-16', '2025-03-16'),
('SP0004', '2024-04-18', '2024-03-14', '2024-09-14'),
('SP0005', '2024-01-11', '2023-12-07', '2024-06-07'),
('SP0006', '2024-09-27', '2024-08-16', '2025-02-16'),
('SP0007', '2024-10-26', '2024-09-15', '2025-03-15'),
('SP0008', '2024-01-09', '2023-12-05', '2024-06-05'),
('SP0009', '2024-02-10', '2024-01-05', '2024-07-05'),
('SP0010', '2024-03-12', '2024-02-06', '2024-08-06'),
('SP0011', '2024-04-14', '2024-03-09', '2024-09-09'),
('SP0012', '2024-05-16', '2024-04-10', '2024-10-10'),
('SP0013', '2024-06-18', '2024-05-11', '2024-11-11'),
('SP0014', '2024-07-20', '2024-06-12', '2024-12-12'),
('SP0015', '2024-08-22', '2024-07-13', '2025-01-13'),
('SP0016', '2024-09-24', '2024-08-14', '2025-02-14'),
('SP0017', '2024-07-27', '2024-06-22', '2024-12-22'),
('SP0018', '2024-01-10', '2023-12-06', '2024-06-06'),
('SP0019', '2024-02-11', '2024-01-07', '2024-07-07'),
('SP0020', '2024-01-10', '2024-01-05', '2024-07-05'),
('SP0021', '2024-04-17', '2024-03-11', '2024-09-11'),
('SP0022', '2024-05-19', '2024-04-12', '2024-10-12'),
('SP0023', '2024-06-21', '2024-05-13', '2024-11-13'),
('SP0024', '2024-07-23', '2024-06-14', '2024-12-14'),
('SP0025', '2024-08-25', '2024-07-15', '2025-01-15'),
('SP0026', '2024-06-25', '2024-05-20', '2024-11-20'),
('SP0027', '2024-10-29', '2024-09-17', '2025-03-17'),
('SP0028', '2024-08-29', '2024-07-25', '2025-01-25'),
('SP0029', '2024-02-10', '2024-01-05', '2024-07-05'),
('SP0030', '2024-03-14', '2024-02-06', '2024-08-06'),
('SP0031', '2024-04-16', '2024-03-07', '2024-09-07'),
('SP0032', '2024-02-12', '2024-01-10', '2024-07-10'),
('SP0033', '2024-06-20', '2024-05-09', '2024-11-09'),
('SP0034', '2024-07-22', '2024-06-10', '2024-12-10'),
('SP0035', '2024-08-24', '2024-07-11', '2025-01-11'),
('SP0036', '2024-09-26', '2024-08-12', '2025-02-12'),
('SP0037', '2024-10-28', '2024-09-13', '2025-03-13'),
('SP0038', '2024-05-20', '2024-04-15', '2024-10-15'),
('SP0039', '2024-02-12', '2024-01-08', '2024-07-08'),
('SP0040', '2024-03-16', '2024-02-09', '2024-08-09'),
('SP0041', '2024-04-18', '2024-03-10', '2024-09-10'),
('SP0042', '2024-05-20', '2024-04-11', '2024-10-11'),
('SP0043', '2024-06-22', '2024-05-12', '2024-11-12'),
('SP0044', '2024-07-24', '2024-06-13', '2024-12-13'),
('SP0045', '2024-08-26', '2024-07-14', '2025-01-14'),
('SP0046', '2024-09-28', '2024-08-15', '2025-02-15'),
('SP0047', '2024-03-15', '2024-02-10', '2024-08-10'),
('SP0048', '2024-01-12', '2023-12-08', '2024-06-08'),
('SP0049', '2024-02-14', '2024-01-09', '2024-07-09'),
('SP0050', '2024-03-18', '2024-02-10', '2024-08-10');





INSERT INTO DonGia (maSP, donGiaNhap, donGiaBan, donGiaKhuyenMai) VALUES
('SP0001', 16100, 23000, NULL),
('SP0002', 17500, 25000, NULL),
('SP0003', 18800, 47000, NULL),
('SP0004', 19600, 49000, NULL),
('SP0005', 6000, 15000, NULL),
('SP0006', 4400, 11000, NULL),
('SP0007', 35200, 88000, NULL),
('SP0008', 19200, 48000, NULL),
('SP0009', 5200, 13000, NULL),
('SP0010', 5200, 13000, NULL),
('SP0011', 5600, 14000, NULL),
('SP0012', 11600, 29000, NULL),
('SP0013', 16000, 40000, NULL),
('SP0014', 54800, 137000, NULL),
('SP0015', 16100, 23000, NULL),
('SP0016', 12000, 30000, NULL),
('SP0017', 13200, 30000, NULL),
('SP0018', 17600, 33000, NULL),
('SP0019', 13200, 19000, NULL),
('SP0020', 5080, 33000, NULL),
('SP0021', 2280, 127000, NULL),
('SP0022', 14000, 57000, NULL),
('SP0023', 3560, 35000, NULL),
('SP0024', 3400, 89000, NULL),
('SP0025', 8480, 8500, NULL),
('SP0026', 8560, 212000, NULL),
('SP0027', 22000, 214000, NULL),
('SP0028', 11200, 55000, NULL),
('SP0029', 7200, 28000, NULL),
('SP0030', 9280, 18000, NULL),
('SP0031', 16400, 232000, NULL),
('SP0032', 11080, 410000, NULL),
('SP0033', 8000, 277000, NULL),
('SP0034', 5080, 20000, NULL),
('SP0035', 3680, 127000, NULL),
('SP0036', 13000, 9200, NULL),
('SP0037', 13200, 32500, NULL),
('SP0038', 26600, 33000, NULL),
('SP0039', 8040, 6700, NULL),
('SP0040', 9560, 66500, NULL),
('SP0041', 9560, 20100, NULL),
('SP0042', 3800, 23900, NULL),
('SP0043', 17200, 23900, NULL),
('SP0044', 18000, 9500, NULL),
('SP0045', 3560, 43000, NULL),
('SP0046', 7000, 45000, NULL),
('SP0047', 46400, 89000, NULL),
('SP0048', 60000, 17500, NULL),
('SP0049', 3560, 116000, NULL),
('SP0050', 17200, 150000, NULL);
;

select * from HoaDon
select * from NhanVien
select * from SanPham
select * from NhanVien

INSERT INTO KhachHang (maKH, tenKH, ngaySinh, gioiTinh, loaiThanhVien)
VALUES
('KH001', 'Nguyễn Văn A', '1990-01-15', 'M', 'Thường'),
('KH002', 'Trần Thị B', '1985-03-22', 'F', 'VIP'),
('KH003', 'Lê Minh C', '1988-06-11', 'M', 'VIP'),
('KH004', 'Phan Mai D', '1992-11-30', 'F', 'Thường'),
('KH005', 'Đỗ Văn E', '1987-07-04', 'M', 'Thường'),
('KH006', 'Hoàng Thu F', '1994-05-25', 'F', 'VIP'),
('KH007', 'Ngô Minh G', '1991-02-17', 'M', 'VIP'),
('KH008', 'Trịnh Lệ H', '1989-12-05', 'F', 'VIP'),
('KH009', 'Vũ Ngọc I', '1986-10-10', 'M', 'VIP'),
('KH010', 'Bùi Lan J', '1993-08-18', 'F', 'VIP'),
('KH011', 'Phan Minh K', '1984-04-09', 'M', 'VIP'),
('KH012', 'Lý Thị L', '1995-09-13', 'F', 'VIP'),
('KH013', 'Hà Tấn M', '1990-02-25', 'M', 'Thường'),
('KH014', 'Nguyễn Thanh N', '1983-03-29', 'F', 'VIP'),
('KH015', 'Mai Phương O', '1982-07-15', 'F', 'Thường'),
('KH016', 'Tô Hữu P', '1996-11-23', 'M', 'VIP'),
('KH017', 'Phan Mai Q', '1991-05-30', 'F', 'VIP'),
('KH018', 'Đặng Văn R', '1992-09-04', 'M', 'VIP'),
('KH019', 'Lê Thị S', '1988-01-11', 'F', 'Thường'),
('KH020', 'Nguyễn Tấn T', '1995-12-21', 'M', 'VIP');

INSERT INTO NhanVien (maNV, tenNV, ngaySinh, diaChi, gioiTinh, luong, ngayVaoLam, sdt)
VALUES
('NV001', 'Nguyễn Văn A', '1985-06-01', 'Hà Nội', 'M', 15000.5, '2010-05-12', 123456789),
('NV002', 'Trần Thị B', '1990-07-15', 'TP.HCM', 'F', 17000.75, '2012-09-22', 234567890),
('NV003', 'Lê Minh C', '1988-02-10', 'Đà Nẵng', 'M', 16000.0, '2013-03-18', 345678901),
('NV004', 'Phan Mai D', '1993-09-23', 'Hải Phòng', 'F', 14000.5, '2015-07-25', 456789012),
('NV005', 'Đỗ Văn E', '1992-11-05', 'Hà Nội', 'M', 15500.0, '2014-02-19', 567890123),
('NV006', 'Hoàng Thu F', '1989-03-18', 'TP.HCM', 'F', 14500.25, '2011-08-15', 678901234),
('NV007', 'Ngô Minh G', '1991-04-22', 'Đà Nẵng', 'M', 16500.0, '2016-06-10', 789012345),
('NV008', 'Trịnh Lệ H', '1990-08-30', 'Hải Phòng', 'F', 16000.5, '2014-04-12', 890123456),
('NV009', 'Vũ Ngọc I', '1987-01-10', 'Hà Nội', 'M', 17500.0, '2010-11-23', 901234567),
('NV010', 'Bùi Lan J', '1986-05-12', 'TP.HCM', 'F', 15000.75, '2012-05-17', 102345678),
('NV011', 'Phan Minh K', '1994-07-04', 'Đà Nẵng', 'M', 16000.25, '2017-03-19', 203456789),
('NV012', 'Lý Thị L', '1992-06-21', 'Hải Phòng', 'F', 15000.0, '2014-12-01', 314567890),
('NV013', 'Hà Tấn M', '1991-12-02', 'Hà Nội', 'M', 17000.0, '2013-09-13', 425678901),
('NV014', 'Nguyễn Thanh N', '1995-04-19', 'TP.HCM', 'F', 15500.0, '2016-01-25', 536789012),
('NV015', 'Mai Phương O', '1988-08-07', 'Đà Nẵng', 'F', 16500.5, '2014-06-09', 647890123);

INSERT INTO HoaDon (maHoaDon, ngayLap, tongTien, hinhThucThanhToan, maKH, maNV)
VALUES
('HD001', '2022-06-01', 500000, 'Ngân Hàng', 'KH001', 'NV001'),
('HD002', '2022-06-02', 300000, 'Tiền Mặt', 'KH002', 'NV002'),
('HD003', '2022-06-05', 700000, 'Ngân Hàng', 'KH003', 'NV003'),
('HD004', '2022-06-10', 450000, 'Tiền Mặt', 'KH004', 'NV004'),
('HD005', '2022-06-15', 600000, 'Ngân Hàng', 'KH005', 'NV005'),
('HD006', '2022-06-20', 800000, 'Tiền Mặt', 'KH006', 'NV006'),
('HD007', '2022-06-25', 350000, 'MOMO', 'KH007', 'NV007'),
('HD008', '2022-06-30', 550000, 'Tiền Mặt', 'KH008', 'NV008'),
('HD009', '2023-07-01', 400000, 'Ngân Hàng', 'KH009', 'NV009'),
('HD010', '2023-07-02', 750000, 'Tiền Mặt', 'KH010', 'NV010'),
('HD011', '2023-07-05', 600000, 'MOMO', 'KH011', 'NV011'),
('HD012', '2023-07-10', 450000, 'Tiền Mặt', 'KH012', 'NV012'),
('HD013', '2023-07-12', 200000, 'Ngân Hàng', 'KH013', 'NV013'),
('HD014', '2023-07-15', 500000, 'MOMO', 'KH014', 'NV014'),
('HD015', '2023-07-20', 650000, 'Ngân Hàng', 'KH015', 'NV015'),
('HD016', '2023-07-22', 750000, 'Tiền Mặt', 'KH016', 'NV001'),
('HD017', '2023-07-25', 800000, 'MOMO', 'KH017', 'NV002'),
('HD018', '2023-07-28', 900000, 'Tiền Mặt', 'KH018', 'NV003'),
('HD019', '2023-08-01', 450000, 'MOMO', 'KH019', 'NV004'),
('HD020', '2023-08-05', 500000, 'Tiền Mặt', 'KH020', 'NV005'),
('HD021', '2023-08-10', 750000, 'Ngân Hàng', 'KH001', 'NV006'),
('HD022', '2023-08-12', 650000, 'Tiền Mặt', 'KH002', 'NV007'),
('HD023', '2023-08-15', 600000, 'MOMO', 'KH003', 'NV008'),
('HD024', '2023-08-18', 700000, 'Tiền Mặt', 'KH004', 'NV009'),
('HD025', '2023-08-20', 550000, 'Ngân Hàng', 'KH005', 'NV010'),
('HD026', '2023-08-22', 450000, 'Tiền Mặt', 'KH006', 'NV011'),
('HD027', '2023-08-25', 800000, 'MOMO', 'KH007', 'NV012'),
('HD028', '2023-08-28', 500000, 'Tiền Mặt', 'KH008', 'NV013'),
('HD029', '2024-09-01', 600000, 'MOMO', 'KH009', 'NV014'),
('HD030', '2024-09-05', 700000, 'Tiền Mặt', 'KH010', 'NV015');



--Call Stored NTT





    



