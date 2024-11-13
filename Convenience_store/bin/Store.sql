USE QLStore;
GO


-- Tăng giảm số lượng
CREATE PROCEDURE GetSanPhamSorted 
    @sortOrder VARCHAR(4)
AS


BEGIN
    IF @sortOrder = 'ASC'
    BEGIN
        SELECT * FROM SanPham
        ORDER BY soLuong ASC;
    END
    ELSE IF @sortOrder = 'DESC'
    BEGIN
        SELECT * FROM SanPham
        ORDER BY soLuong DESC;
    END
    ELSE
    BEGIN
        RAISERROR('Tham số sắp xếp không hợp lệ', 16, 1);
    END
END;

-- Tăng giảm đơn giá
CREATE PROCEDURE SapxepDonGia
    @sortOrder VARCHAR(4)
AS


BEGIN
    IF @sortOrder = 'ASC'
    BEGIN
        SELECT * FROM SanPham
        ORDER BY donGia ASC;
    END
    ELSE IF @sortOrder = 'DESC'
    BEGIN
        SELECT * FROM SanPham
        ORDER BY donGia DESC;
    END
    ELSE
    BEGIN
        RAISERROR('Tham số sắp xếp không hợp lệ', 16, 1);
    END
END;





--Kiếm sản phẩm theo mã
CREATE PROCEDURE TimKiemMA
    @sMASP VARCHAR(6)
AS
BEGIN
    SELECT
      [maSP],
      [tenSP],
      [loaiSP],
      [soLuong],
      [xuatXu],
      [thuongHieu],
      [moTa],
      [nhaSanXuat],
      [donGia]
  FROM [QLStore].[dbo].[SanPham] 
WHERE maSP = @sMASP;
END;

--Tính còn bao nhiêu ngày hết hạn
CREATE PROCEDURE TinhNgayHetHan
    @maSP VARCHAR(10)
AS
BEGIN
    DECLARE @soNgayConLai INT;

    -- Validate if maSP exists in the table
    IF NOT EXISTS (SELECT 1 FROM DaySanPham WHERE maSP = @maSP)
    BEGIN
        PRINT 'Product ID not found';
        RETURN;  -- Return if the product ID does not exist
    END

    -- Calculate the remaining days
    SELECT @soNgayConLai = DATEDIFF(DAY, GETDATE(), ngayHetHan)
    FROM DaySanPham
    WHERE maSP = @maSP;

    -- If the expiration date is in the past, return 0
    IF @soNgayConLai < 0
        SET @soNgayConLai = 0;

    -- Return the result as a SELECT statement
    SELECT @soNgayConLai AS SoNgayConLai;
END;


--Lưu Sản Phẩm
CREATE PROCEDURE SuaSanPham
    @maSP VARCHAR(10),
    @tenSP NVARCHAR(150),
    @loaiSP NVARCHAR(50),
    @soLuong INT,
    @xuatXu NVARCHAR(50),
    @thuongHieu NVARCHAR(50),
    @moTa NVARCHAR(150),
    @nhaSanXuat NVARCHAR(150),
    @donGia FLOAT,
	@ngayNhap DATETIME,
	@donGiaBan FLOAT,
    @donGiaKhuyenMai FLOAT
AS
BEGIN

    UPDATE SanPham
    SET
        tenSP = @tenSP,
        loaiSP = @loaiSP,
        soLuong = @soLuong,
        xuatXu = @xuatXu,
        thuongHieu = @thuongHieu,
        moTa = @moTa,
        nhaSanXuat = @nhaSanXuat,
        donGia = @donGia

    WHERE maSP = @maSP;
    
	UPDATE DaySanPham
    SET
        ngayNhap = @ngayNhap
    WHERE maSP = @maSP;
	
	UPDATE DonGia
    SET
        donGiaBan = @donGiaBan,
        donGiaKhuyenMai = @donGiaKhuyenMai
    WHERE maSP = @maSP;
    
END;

-- lọc Xuất Xứ
CREATE PROCEDURE sp_LocSanPhamTheoXuatXu
    @xuatXu NVARCHAR(50)
AS
BEGIN
    SELECT *
    FROM SanPham
    WHERE xuatXu = @xuatXu;
END;

-- lọc Thương hiệu
CREATE PROCEDURE sp_LocSanPhamTheoThuonghieu 
    @thuongHieu NVARCHAR(50)
AS
BEGIN
    SELECT *
    FROM SanPham
    WHERE thuongHieu = @thuongHieu;
END;

--Xóa sản phẩm
CREATE PROCEDURE sp_XoaSanPhamTheoMa
    @maSP VARCHAR(10)
AS
BEGIN
    DELETE FROM SanPham
    WHERE maSP = @maSP;
END;
  --lọc số lương
  CREATE PROCEDURE sp_LocSanPhamTheoSoLuong
    @soLuong INT,
    @operator INT -- Nhận giá trị 1 hoặc 2 để lọc
AS
BEGIN
    IF @operator = 1
    BEGIN
        SELECT *
        FROM SanPham
        WHERE soLuong > @soLuong;
    END
    ELSE IF @operator = 2
    BEGIN
        SELECT *
        FROM SanPham
        WHERE soLuong < @soLuong;
    END

    
END;	