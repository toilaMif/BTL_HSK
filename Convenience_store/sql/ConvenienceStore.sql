--create database QLstore
--go

use QLstore
go
CREATE TABLE SanPham(
   maSP  VARCHAR (10) primary key,
   tenSP NVARCHAR (150) NOT NULL, 
   loaiSP NVARCHAR (50) NOT NULL,
   soLuong int NOT NULL,
   xuatXu NVARCHAR (50) NOT NULL,
   thuongHieu NVARCHAR (50) NOT NULL,
   moTa NVARCHAR (150),
   nhaSanXuat NVARCHAR (150),
);

CREATE TABLE DaySanPham(
	maSP VARCHAR(10) NOT NULL,
	ngayNhap DateTime NOT NULL,
	ngaySanXuat DateTime NOT NULL,
	NgayHetHan DateTime NOT NULL,
	FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);
CREATE TABLE DonGia (
	maSP VARCHAR(10) NOT NULL,
    donGiaNhap FLOAT NOT NULL,
    donGiaBan FLOAT NOT NULL,
    donGiaKhuyenMai FLOAT,
	FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);
CREATE TABLE ChuongTrinhKhuyenMai(
	maKM VARCHAR (10) primary key,
	maSP VARCHAR(10) NOT NULL,
	han DateTime NOT NULL,
	loaiKM NVARCHAR (50) NOT NULL,
	FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);
CREATE TABLE ChiTietKhuyenMai(
	maCTKM VARCHAR (10) primary key,
	maKM VARCHAR (10) NOT NULL,
	mucGiamGia FLOAT NOT NULL,
	quaTang NVARCHAR (50),
	dieuKien NVARCHAR(50),
	moTA NVARCHAR (100),
	FOREIGN KEY (maKM) REFERENCES ChuongTrinhKhuyenMai(maKM)

	
);





 --INSERT SP


INSERT INTO SanPham (maSP, tenSP, loaiSP, soLuong, xuatXu, thuongHieu, moTa, nhaSanXuat) VALUES 
('SP0001', N'Toastie Sa Tế Chà Bông Kiểu Thái', N'Đồ Ăn', 30, N'Việt Nam', N'7-Select SSV', N'', N''),
('SP0002', N'Hot Dog Xúc Xích Classsic', N'Đồ Ăn', 20, N'Việt Nam', N'7-Select SSV', N'', N''), (
'SP0003', N'Snack Slide Original 150g -T10', N'Đồ Ăn', 50, N'Malaysia', N'Slide', N'Sản phẩm: Snack Slide Original 150g', N'CÔNG TY TNHH PHÂN PHỐI TIÊN TIẾN'), 
('SP0004', N'Snack Slide Hot Spicy 150g -T10', N'Đồ Ăn', 50, N'Malaysia', N'Slide', N'Sản phẩm: Snack Slide Hot Spicy 150g', N'CÔNG TY TNHH PHÂN PHỐI TIÊN TIẾN'), 
('SP0005', N'Rong Biển O''Food Vị Mực 6g -T10', N'Đồ Ăn', 100, N'Việt Nam', N'O''Food', N'Sản phẩm: Rong Biển O''Food Vị Mực 6g', N'CHI NHÁNH CÔNG TY TNHH DAESANG VIỆT NAM'), 
('SP0006', N'Milo Sữa Lúa Mạch 180ml', N'Đồ Uống', 200, N'Việt Nam', N'Milo', N'Sản phẩm này là thức uống bổ sung', N'CÔNG TY TNHH PHÂN PHỐI QUẢ TÁO ĐỎ'), 
('SP0007', N'Sữa Sahmyook Đậu Đen ÓcChó HạnhNhân950ml', N'Đồ Uống', 150, N'Korea', N'Sahmyook', N'Sữa Sahmyook Hộp 950ml', N'CÔNG TY TNHH DỊCH VỤ VẠN LỘC PHÁT'), 
('SP0008', N'Sữa Tươi Tiệt Trùng TH Nguyên Chất 1L', N'Đồ Uống', 100, N'Việt Nam', N'TH True Milk', N'STTT TH Nguyên Chất 1L', N'CÔNG TY CP CHUỖI THỰC PHẨM'), 
('SP0009', N'Dasani Nước Tinh Khiết 1.5L Nước Suối Water', N'Đồ Uống Đóng chai', 300, N'Việt Nam', N'Dasani', N'Dasani Nước Tinh Khiết 1.5L Nước Suối', N'CÔNG TY TNHH NƯỚC GIẢI KHÁT COCA-COLA VIỆT NAM'), 
('SP0010', N'Lavie Nước Khoáng 1.5L Nước Suối Water', N'Đồ Uống Đóng chai', 250, N'Việt Nam', N'Lavie', N'Lavie Nước Khoáng 1.5L Nước Suối', N'CÔNG TY TNHH BÁN LẺ SONG MÃ'),
('SP0011', N'Nước Aquafina 1.5L', N'Đồ Uống Đóng chai', 200, N'Việt Nam', N'Aquafina', N'Aquafina Nước Tinh Khiết 1,5L Nước Suối Aqua', N'CÔNG TY TNHH SẢN XUẤT DỊCH VỤ THƯƠNG MẠI XUẤT NHẬP KHẨU MINH QUANG'),
('SP0012', N'Trứng Gà V.Food hộp x 6 trứng', N'Thực Phẩm', 100, N'Việt Nam', N'Vfood', N'Trứng Gà V.Food hộp x 6 trứng', N'CÔNG TY CP THỰC PHẨM VĨNH THÀNH ĐẠT'),
('SP0013', N'Trứng Gà Nhật ISE Vỉ 6 Qủa', N'Thực Phẩm', 100, N'Việt Nam', N'Vfood', N'Trứng Gà ISE', N'CÔNG TY CP THỰC PHẨM VĨNH THÀNH ĐẠT'),
('SP0014', N'Tôm Khô Hải Nam Size S 100g', N'Thực Phẩm', 50, N'Việt Nam', N'Hải Nam', N'Tôm Khô Hải Nam Size S 100g', N'CÔNG TY TNHH TM-SX HẢI NAM'),
('SP0015', N'Xúc Xích Ponnie Phô Mai Cá 45g -T10', N'Đồ Ăn', 200,N'Việt Nam', N'masan', N'Sản phẩm: Xúc Xích Ponnie Phô Mai Heo 45g', N'HỢP TÁC XÃ THƯƠNG MẠI PHƯỜNG 14 QUẬN 3'),
('SP0016', N'Gỏi Khô Gà Rau Răm 40g', N'Đồ Ăn', 150, N'Việt Nam', N'OHAYO', N'Sản phẩm: Gỏi KhôGà RauRăm Ohayo 40g', N'CÔNG TY CỔ PHẦN THƯƠNG MẠI DỊCH VỤ 3H VIỆT NAM'),
('SP0017', N'Chân Gà Rút Xương Ohayo CayTê 60g', N'Đồ Ăn', 150, N'Việt Nam', N'OHAYO', N'Sản phẩm: Chân Gà RX Ohayo CayTê 60g', N'CÔNG TY CỔ PHẦN THƯƠNG MẠI DỊCH VỤ 3H VIỆT NAM'),
('SP0018', N'Chà Bông Cá Hồi Tươi SG Food Gói 35g', N'Đồ Hộp', 100, N'Việt Nam', N'Saigon Food', N'Sản phẩm: Chà Bông Cá Hồi Tươi SGF Gói 35g', N'CÔNG TY CP SÀI GÒN FOOD'),
('SP0019', N'Cá Hộp Ba Cô Gái 115g Tomato Sardines Canned Food', N'Đồ Hộp', 200, N'Việt Nam', N'Three Lady Cook', N'Sản phẩm: Cá Hộp Ba Cô Gái 115g', N'CÔNG TY TNHH THAI CORP INTERNATIONAL (VIỆT NAM)'),
('SP0020', N'Cá Xốt Cà 3 Cô Gái 190g', N'Đồ Hộp', 200, N'Việt Nam', N'Three Lady Cook', N'Sản phẩm: Cá Xốt Cà 3 Cô Gái 190g', N'CÔNG TY TNHH THAI CORP INTERNATIONAL (VIỆT NAM)'),
('SP0021', N'Thịt Hộp Spam Classic 340g', N'Đồ Hộp', 100, N'Unites States', N'Spam', N'Sản phẩm: Thịt Hộp Spam Class 340g', N'CÔNG TY TNHH TMDV TIẾP THỊ ĐỒNG THẮNG'),
('SP0022', N'Cá Ngừ Ngâm Dầu Nautilus 170g Oily Fish Sardines Canned Food', N'Đồ Hộp', 150, N'Thailand', N'Nautilus', N'Tên sản phẩm: Cá Ngừ Ngâm Dầu Nautilus 170g', N'CÔNG TY TNHH NAUTILUS FOOD (VIỆT NAM)'),
('SP0023', N'Đường Mía Biên Hòa T.Hạng 1kg', N'Gia Vị', 200, N'Việt Nam', N'Đường Biên Hòa', N'Sản phẩm : Đường BH/Mía T.Hạng 1kg', N'CÔNG TY CỔ PHẦN HÀNG TIÊU DÙNG BIÊN HÒA'),
('SP0024', N'Dầu Ăn Gạo Lứt Simply 1L', N'Gia Vị', 150, N'Việt Nam', N'Simply', N'Sản phẩm: Dầu Gạo Lứt Simply 1L', N'CÔNG TY TNHH MỘT THÀNH VIÊN PHẠM ANH'),
('SP0025', N'Dầu ăn Simply 1L Cooking Oil', N'Gia Vị', 150, N'Việt Nam', N'Simply', N'Sản phẩm: Dầu ăn Simply 1L new', N'CÔNG TY TNHH MỘT THÀNH VIÊN PHẠM ANH'),
('SP0026', N'Dầu Gội H&S Bạc Hà 625ml Shampoo', N'Dầu Gội', 100, N'Việt Nam', N'Head & Shoulders', N'Sản phẩm: Dầu Gội H&S Bạc Hà 625ml', N'CHI NHÁNH CÔNG TY TNHH DỊCH VỤ VÀ THƯƠNG MẠI MESA'),
('SP0027', N'Dầu Gội Clear Bạc Hà 630g Shampoo', N'Dầu Gội', 100, N'Việt Nam', N'Clear', N'Sản phẩm: Dầu Gội Clear Bạc Hà 630g', N'HỢP TÁC XÃ THƯƠNG MẠI QUẬN 3'),
('SP0028', N'Tắm Gội 2in1 Romano 180g -T10', N'Dầu Gội', 150, N'Việt Nam', N'Romano', N'Sản phẩm: Tắm Gội 2in1 Romano 180g', N'CÔNG TY CP THƯƠNG MẠI DỊCH VỤ QUẬN 3'),
('SP0029', N'Bột Giặt Omo 380g', N'Nước Giặt', 200, N'Việt Nam', N'Omo', N'Sản phẩm: BG Omo 380g', N'HỢP TÁC XÃ THƯƠNG MẠI QUẬN 3'),
('SP0030', N'Nước Giặt Omo Giữ Màu Túi 2.8kg -T10', N'Nước Giặt', 150, N'Việt Nam', N'Omo', N'Sản phẩm: Nước Giặt Omo Giữ Màu Túi 2.8kg', N'HỢP TÁC XÃ THƯƠNG MẠI QUẬN 3'),
('SP0031', N'Nước Giặt Downy Biển Xanh 2.65kg', N'Nước Giặt', 150, N'Việt Nam', N'Downy', N'Sản phẩm: Nước Giặt Downy Biển Xanh 2.65kg', N'CHI NHÁNH CÔNG TY TNHH DỊCH VỤ VÀ THƯƠNG MẠI MESA'),
('SP0032', N'Thùng 24 lon bia Tiger crystal lon 330ml', N'Đồ Uống Có Cồn', 200, N'Việt Nam', N'Tiger', N'Bia Tiger Crystal lon 330ml', N'CÔNG TY CỔ PHẦN BIA- RƯỢU – NƯỚC GIẢI KHÁT SÀI GÒN'),
('SP0033', N'Bia 333 Export thùng 24 lon x 330ml', N'Đồ Uống Có Cồn', 200, N'Việt Nam', N'Bia 333', N'Bia 333 Export lon 330ml', N'CÔNG TY CỔ PHẦN BIA- RƯỢU – NƯỚC GIẢI KHÁT SÀI GÒN'),
('SP0034', N'Nước giải khát Coca Cola chai 1.5lít', N'Đồ Uống Đóng chai', 300, N'Việt Nam', N'Coca cola', N'Nước giải khát Coca Cola chai 1.5L', N'CÔNG TY CỔ PHẦN BIA- RƯỢU – NƯỚC GIẢI KHÁT SÀI GÒN'),
('SP0035', N'Thùng 30 gói mì xào khô vị tôm xào chua ngọt Hảo Hảo 75g', N'Thực Phẩm Ăn Liền', 500, N'Việt Nam', N'Acecook', N'Mì xào khô vị tôm xào chua ngọt Hảo Hảo gói 75g', N'Công Ty Cp Acecook Việt Nam'),
('SP0036', N'Phở thịt bò Vifon gói 65g', N'Thực Phẩm Ăn Liền', 400, N'Việt Nam', N'Vifon', N'Phở thịt bò Vifon gói 65g', N'Công Ty Cp Vifon Việt Nam'),
('SP0037', N'Mì trộn tương đen Samyang gói 140g', N'Thực Phẩm Ăn Liền', 300, N'Korea', N'Samyang', N'Mì trộn tương đen Samyang', N'Công Ty Cp Samyang Việt Nam'),
('SP0038', N'Bột ngọt (mì chính) Ajinomoto 400g', N'Gia Vị', 200, N'Việt Nam', N'Ajinomoto', N'Bột ngọt (mì chính) Ajinomoto gói 400g', N'Công Ty Cp Ajinomoto Việt Nam'),
('SP0039', N'Muối biển Visaco Mặt trời (tinh) 450g', N'Gia Vị', 150, N'Việt Nam', N'Visaco', N'Muối biển Visaco Mặt trời (tinh) 450g', N'Công Ty Cp Visaco Việt Nam'),
('SP0040', N'Tương ớt chua ngọt Cholimex PET 2.1kg', N'Gia Vị', 100, N'Việt Nam', N'Cholimex PET', N'Tương ớt chua ngọt Cholimex PET 2.1kg', N'Công Ty Cp Cholimex PET Việt Nam'),
('SP0041', N'Nước tương Tam Thái Tử Nhất Ca chai 500ml', N'Gia Vị', 200, N'Việt Nam', N'Masan', N'Nước tương Tam Thái Tử Nhất Ca chai 500ml', N'Công ty cổ phần Hàng tiêu dùng Masan'),
('SP0042', N'Vỉ 5 bút bi Thiên Long TL027', N'Văn Phòng Phẩm', 300, N'Việt Nam', N'Thiên Long', N'Vỉ 5 bút bi Thiên Long TL027', N'Thiên Long là công ty chuyên về văn phòng phẩm'),
('SP0043', N'Vỉ 2 Bút lông dầu Thiên Long PM09', N'Văn Phòng Phẩm', 200, N'Việt Nam', N'Thiên Long', N'Vỉ 2 Bút lông dầu Thiên Long PM09', N'Thiên Long là công ty chuyên về văn phòng phẩm'),
('SP0044', N'Vỉ 2 cục Gôm Thiên Long 08', N'Văn Phòng Phẩm', 150, N'Việt Nam', N'Thiên Long', N'Vỉ 2 cục Gôm Thiên Long 08', N'Thiên Long là công ty chuyên về văn phòng phẩm'),
('SP0045', N'Khăn Ướt Kin Kin Hương Trà Xanh Gói 100 Tờ', N'Văn Phòng Phẩm', 100, N'Việt Nam', N'Kin Kin', N'Khăn Ướt Kin Kin Hương Trà Xanh Gói 100 Tờ', N'CÔNG TY TNHH KIN KIN LOGISTICS'),
('SP0046', N'Băng Vệ Sinh Kotex Max Cool Siêu Mỏng Cánh Gói 20 Miếng 23Cm', N'Thiết yếu', 200, N'Việt Nam', N'Kotex', N'Băng Vệ Sinh Kotex Max Cool Siêu Mỏng Cánh Gói 20 Miếng 23Cm', N'Kimberly-Clark Corporation tập đoàn chăm sóc cá nhân đa quốc gia'),
('SP0047', N'Bao cao su Durex Invisible Extra Thin Extra Sensitive siêu mỏng, vừa vặn và ôm sát (3 cái)', N'Thiết yếu', 150, N'Anh', N'DUREX', N'Bao cao su Durex Invisible Extra Thin Extra Sensitive siêu mỏng, vừa vặn và ôm sát (3 cái)', N'Reckitt Benckiser công ty hàng tiêu dùng đa quốc gia Anh-Hà Lan'),
('SP0048', N'Xà Bông Cục Lifebuoy Matcha & Khổ Qua 90G', N'Thiết yếu', 200, N'Việt Nam', N'Lifebuoy', N'Xà Bông Cục Lifebuoy Matcha & Khổ Qua 90G', N''),
('SP0049', N'Sữa Chống Nắng Sunplay Aqua Clear SPF50 25G', N'Thiết yếu', 100, N'Việt Nam', N'Sunplay', N'Sữa Chống Nắng Sunplay Aqua Clear SPF50 25G', N'CÔNG TY TNHH ROHTO-MENTHOLATUM (VIỆT NAM)'),
('SP0050', N'Nước Súc Miệng Listerine Coolmint 750Ml', N'Thiết yếu', 150, N'Việt Nam', N'Listerine', N'Nước Súc Miệng Listerine Coolmint 750Ml', N'');

INSERT INTO DaySanPham(maSP, ngayNhap, ngaySanXuat, ngayHetHan) VALUES 
('SP0001', '2024-01-10', '2024-01-05', '2024-07-05'),
('SP0002', '2024-02-15', '2024-02-10', '2024-08-10'),
('SP0003', '2024-03-20', '2024-03-15', '2024-09-15'),
('SP0004', '2024-01-12', '2024-01-08', '2024-07-08'),
('SP0005', '2024-02-17', '2024-02-12', '2024-08-12'),
('SP0006', '2024-03-22', '2024-03-18', '2024-09-18'),
('SP0007', '2024-01-14', '2024-01-09', '2024-07-09'),
('SP0008', '2024-02-19', '2024-02-14', '2024-08-14'),
('SP0009', '2024-03-24', '2024-03-20', '2024-09-20'),
('SP0010', '2024-01-16', '2024-01-11', '2024-07-11'),
('SP0011', '2024-02-21', '2024-02-16', '2024-08-16'),
('SP0012', '2024-03-26', '2024-03-22', '2024-09-22'),
('SP0013', '2024-01-18', '2024-01-13', '2024-07-13'),
('SP0014', '2024-02-23', '2024-02-18', '2024-08-18');




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


