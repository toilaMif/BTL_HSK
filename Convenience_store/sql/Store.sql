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
