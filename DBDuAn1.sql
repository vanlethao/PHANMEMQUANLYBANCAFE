﻿
USE PHANMEMQUANLYBANCAFE

CREATE TABLE THUONGHIEU(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ten NVARCHAR(40) NULL,
)
CREATE TABLE TAIKHOANADMIN(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	TenTk VARCHAR(20) NOT NULL UNIQUE,
	MatKhau NVARCHAR(20) NULL,
	IdThuongHieu UNIQUEIDENTIFIER NULL UNIQUE
	CONSTRAINT FK_ADMIN_THUONGHIEU FOREIGN KEY(IdThuongHieu) REFERENCES dbo.THUONGHIEU(Id)
)
CREATE TABLE CHINHANH(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(5) NOT NULL UNIQUE,
	QuocGia NVARCHAR(15) NULL,
	ThanhPho NVARCHAR(20) NULL,
	NgayKhaiTruong DATE NULL,
	TrangThai INT NULL,
	IdThuongHieu UNIQUEIDENTIFIER  NULL,
	GiaTriDoiDiem FLOAT NULL,/*100000=1d*/
	GiaTriDiem FLOAT NULL	/*1000=1d*/
	CONSTRAINT FK_CHINHANH_THUONGHIEU FOREIGN KEY(IdThuongHieu) REFERENCES dbo.THUONGHIEU (Id) 
)

CREATE TABLE KHUVUC(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(5) NOT NULL UNIQUE,
	TrangThai INT NULL,
	IdChiNhanh UNIQUEIDENTIFIER NULL,
	CONSTRAINT FK_KHUVUC_CHINHANH FOREIGN KEY(idChiNhanh) REFERENCES dbo.CHINHANH(Id)

)
CREATE TABLE BAN(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	SoBan INT NOT NULL UNIQUE,
	TrangThai INT NULL,
	TrangThaiSuDung INT NULL,
	IdKhuVuc UNIQUEIDENTIFIER NULL,
	CONSTRAINT FK_BAN_KHUVUC FOREIGN KEY(IdKhuVuc) REFERENCES dbo.KHUVUC(Id) 

)
CREATE TABLE CA(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(5) NOT NULL UNIQUE,
	GioBatDau TIME NULL,
	GioKetThuc TIME NULL,
	TrangThai INT NULL
)

CREATE TABLE HOATDONGCA(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	IdCa UNIQUEIDENTIFIER NOT NULL,
	NgayThucHien DATE NULL,
	GioMoCa TIME NULL,
	GioDongCa TIME NULL,
	TienDauCa FLOAT NULL,
	TienCuoiCa FLOAT NULL,
	CONSTRAINT FK_HOATDONG_CA FOREIGN KEY(IdCa) REFERENCES dbo.CA (Id)
)

CREATE TABLE KHACHHANG(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(5) NOT NULL UNIQUE,
	HoTen NVARCHAR(30) NULL,
	QuocGia NVARCHAR(15) NULL,
	ThanhPho NVARCHAR(20) NULL,
	Sdt VARCHAR(12) NULL,
	GioiTinh NVARCHAR(5) NULL,
	TrangThai INT NULL,
	diemTichLuy INT NULL
)

CREATE TABLE CHITIETKHACHHANG(
	IdKhachHang UNIQUEIDENTIFIER NOT NULL ,
	IdChiNhanh UNIQUEIDENTIFIER NOT NULL ,
	CONSTRAINT FK_CHITIETCHINHANH_KHACHHANG FOREIGN KEY(IdKhachHang) REFERENCES dbo.KHACHHANG (Id),
	CONSTRAINT FK_CHITIETCHINHANH_CHINHANH FOREIGN KEY(IdChiNhanh) REFERENCES dbo.CHINHANH (Id)
)
ALTER TABLE dbo.CHITIETKHACHHANG ADD CONSTRAINT PK_CHITIETKHACH PRIMARY KEY(IdKhachHang,IdChiNhanh)
CREATE TABLE CHUCVU(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(5) NOT NULL UNIQUE,
	Ten NVARCHAR(20) NULL
)
CREATE TABLE NHANVIEN(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(5) NOT NULL UNIQUE,
	HoTen NVARCHAR(30) NULL,
	QuocGia NVARCHAR(15) NULL,
	ThanhPho NVARCHAR(20) NULL,
	Sdt VARCHAR(12) NULL,
	GioiTinh NVARCHAR(5) NULL,
	Luong FLOAT NULL,
	IdChiNhanh UNIQUEIDENTIFIER NULL,
	IdChucVu UNIQUEIDENTIFIER NULL,
	TrangThai INT NULL,
	Avatar VARBINARY(MAX) NULL,
	CONSTRAINT FK_NHANVIEN_CHINHANH FOREIGN KEY(IdChiNhanh) REFERENCES dbo.CHINHANH (Id),
	CONSTRAINT FK_NHANVIEN_CHUCVU FOREIGN KEY(IdChucVu) REFERENCES dbo.CHUCVU(Id)
)

CREATE TABLE CHITIETCA(
	IdCa UNIQUEIDENTIFIER NOT NULL,
	IdNv UNIQUEIDENTIFIER NOT NULL,
	CONSTRAINT FK_CHITIETCA_CA FOREIGN KEY(IdCa) REFERENCES dbo.CA (Id),
	CONSTRAINT FK_CHITIETCA_NHANVIEN FOREIGN KEY(IdNv) REFERENCES dbo.NHANVIEN(Id),
	CONSTRAINT PK_CHITIETCA PRIMARY KEY(IdCa,IdNv)
)
CREATE TABLE TAIKHOANNGUOIDUNG(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	TenTk VARCHAR(20) NOT NULL UNIQUE,
	MatKhau NVARCHAR(20) NOT NULL,
	TrangThai INT NULL,
	idNhanVien UNIQUEIDENTIFIER NULL ,
	CONSTRAINT FK_TAIKHOAN_NHANVIEN FOREIGN KEY(idNhanVien) REFERENCES dbo.NHANVIEN(Id)
)
CREATE TABLE NGUYENLIEU(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(15) NOT NULL UNIQUE,
	Ten NVARCHAR(20) NULL,
	HanSuDung DATE NULL,
	DonViTinh NVARCHAR(5) NULL,
	SoLuongTon FLOAT NULL
)
CREATE TABLE NGUYENLIEUCHINHANH(
	IdChiNhanh UNIQUEIDENTIFIER NOT NULL,
	IdNguyenLieu UNIQUEIDENTIFIER NOT NULL,
	CONSTRAINT FK_NGUYENLIEUCHINHANH_CHINHANH FOREIGN KEY(IdChiNhanh) REFERENCES dbo.CHINHANH(Id),
	CONSTRAINT FK_NGUYENLIEUCHINHANH_NGUYENLIEU FOREIGN KEY(IdNguyenLieu) REFERENCES dbo.NGUYENLIEU(Id),
	CONSTRAINT PK_NGUYENLIEUCHINHANH PRIMARY KEY(IdChiNhanh,IdNguyenLieu)
)
CREATE TABLE PHIEUKIEMKE(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(15) NOT NULL UNIQUE,
	NgayKiemKe DATE NULL,
	TrangThai INT NULL,
	IdNhanVien UNIQUEIDENTIFIER NULL,
	CONSTRAINT FK_PHIEUKIEMKE_NHANVIEN FOREIGN KEY(IdNhanVien) REFERENCES dbo.NHANVIEN(Id)
)
CREATE TABLE CHITIETPHIEUKIEMKE(
	IdPhieuKiem UNIQUEIDENTIFIER NOT NULL,
	IdNguyenLieu UNIQUEIDENTIFIER NOT NULL,
	SoLuong FLOAT NULL,
	SoLuongThucTe FLOAT NULL,
	SoLuongChenhLech FLOAT NULL,
	LiDo NVARCHAR(100)NULL,
	CONSTRAINT FK_CHITIETPHIEUKIEM_PHIEUKIEM FOREIGN KEY(IdPhieuKiem) REFERENCES dbo.PHIEUKIEMKE(Id),
	CONSTRAINT FK_CHITIETPHIEUKIEM_NGUYENLIEU FOREIGN KEY(IdNguyenLieu) REFERENCES dbo.NGUYENLIEU(Id),
	CONSTRAINT PK_CHITIETKIEMKE PRIMARY KEY(IdPhieuKiem,IdNguyenLieu)
)
CREATE TABLE NHACUNGCAP(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(15) NOT NULL UNIQUE,
	Ten NVARCHAR(30)NULL,
	TrangThai INT NULL
)
CREATE TABLE PHIEUTRAHANG(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(15) NOT NULL UNIQUE,
	NgayTra DATE NULL,
	TrangThai INT NULL,
	IdNhanVien UNIQUEIDENTIFIER NULL,
	IdNhaCungCap UNIQUEIDENTIFIER NULL,
	CONSTRAINT FK_PHIEUTRA_NHACUNGCAP FOREIGN KEY(IdNhaCungCap) REFERENCES dbo.NHACUNGCAP(Id),
	CONSTRAINT FK_PHIEUTRA_NHANVIEN FOREIGN KEY(IdNhanVien) REFERENCES dbo.NHANVIEN(Id)
)
CREATE TABLE PHIEUNHAPHANG(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(15) NOT NULL UNIQUE,
	NgayNhap DATE NULL,
	TrangThai INT NULL,
	IdNhanVien UNIQUEIDENTIFIER NULL,
	IdNhaCungCap UNIQUEIDENTIFIER NULL,
	CONSTRAINT FK_PHIEUNHAP_NHACUNGCAP FOREIGN KEY(IdNhaCungCap) REFERENCES dbo.NHACUNGCAP(Id),
	CONSTRAINT FK_PHIEUNHAP_NHANVIEN FOREIGN KEY(IdNhanVien) REFERENCES dbo.NHANVIEN(Id)

)
CREATE TABLE CHITIETPHIEUNHAP(
	IdPhieuNhap UNIQUEIDENTIFIER NOT NULL ,
	IdNguyenLieu UNIQUEIDENTIFIER NOT NULL ,
	SoLuongNhap FLOAT NULL,
	DonGia FLOAT NULL
	CONSTRAINT FK_CHITIETPHIEUNHAP_PHIEUTRA FOREIGN KEY(IdPhieuNhap) REFERENCES dbo.PHIEUNHAPHANG(Id),
	CONSTRAINT FK_CHITIETPHIEUNHAP_NGUYENLIEU FOREIGN KEY(IdNguyenLieu) REFERENCES dbo.NGUYENLIEU(Id),
	CONSTRAINT PK_CHITIETPHIEUNHAP PRIMARY KEY(IdPhieuNhap,IdNguyenLieu)
)
CREATE TABLE CHITIETPHIEUTRA(
	IdPhieuTra UNIQUEIDENTIFIER NOT NULL ,
	IdNguyenLieu UNIQUEIDENTIFIER NOT NULL ,
	SoLuongTra FLOAT NULL,
	Lido NVARCHAR(100) NULL,
	CONSTRAINT FK_CHITIETPHIEUTRA_PHIEUTRA FOREIGN KEY(IdPhieuTra) REFERENCES dbo.PHIEUTRAHANG(Id),
	CONSTRAINT FK_CHITIETPHIEUTRA_NGUYENLIEU FOREIGN KEY(IdNguyenLieu) REFERENCES dbo.NGUYENLIEU(Id),
	CONSTRAINT PK_CHITIETPHIEUTRA PRIMARY KEY(IdPhieuTra,IdNguyenLieu)
)
CREATE TABLE KHUYENMAI(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ten NVARCHAR(30) NULL,
	NgayBatDau DATE NULL,
	NgayKetThuc DATE NULL,
	Mota NVARCHAR(200) NULL,
	GiaTriChietKhau FLOAT NULL,
	TrangThai INT NULL
)
CREATE TABLE SANPHAM(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(10) NOT NULL UNIQUE,
	Ten NVARCHAR(20) NULL,
	GiaBan FLOAT NULL,
	TrangThai INT NULL,
	IdKhuyenMai UNIQUEIDENTIFIER NULL,
	Avatar VARBINARY(MAX) NULL,
	CONSTRAINT FK_SANPHAM_KHUYENMAI FOREIGN KEY(IdKhuyenMai) REFERENCES dbo.KHUYENMAI(Id)
)

CREATE TABLE CHITIETSANPHAM(
	IdSanPham UNIQUEIDENTIFIER NOT NULL,
	IdNguyenlieu UNIQUEIDENTIFIER NOT NULL,
	DinhLuong FLOAT NULL,
	CONSTRAINT FK_CHITIETSP_SANPHAM FOREIGN KEY(IdSanPham) REFERENCES dbo.SANPHAM(Id),
	CONSTRAINT FK_CHITIETSP_NGUYENLIEU FOREIGN KEY(IdNguyenlieu) REFERENCES dbo.NGUYENLIEU(Id),
)
ALTER TABLE dbo.CHITIETSANPHAM ADD CONSTRAINT PK_CHITIETSP PRIMARY KEY(IdNguyenlieu,IdSanPham)

CREATE TABLE HOADON(
	Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY DEFAULT NEWID(),
	Ma VARCHAR(10)NOT NULL UNIQUE,
	NgayTao DATETIME NULL,
	IdNhanVien UNIQUEIDENTIFIER NULL,
	idBan UNIQUEIDENTIFIER NULL,
	TrangThai INT NULL,
	CONSTRAINT FK_HOADON_NHANVIEN FOREIGN KEY(IdNhanVien) REFERENCES dbo.NHANVIEN(Id),
	CONSTRAINT FK_HOADON_BAN FOREIGN KEY(idBan) REFERENCES dbo.BAN(Id)
)
CREATE TABLE CHITIETHOADON(
	IdSanPham UNIQUEIDENTIFIER NOT NULL,
	IdHoaDon UNIQUEIDENTIFIER NOT NULL,
	SoLuongMua INT NULL,
	ThanhTien FLOAT NULL,
	ThanhTienSauKm FLOAT NULL,
	CONSTRAINT FK_CHITIETHOADON_SANPHAM FOREIGN KEY(IdSanPham) REFERENCES dbo.SANPHAM(Id),
	CONSTRAINT FK_CHITIETHOADON_HOADON FOREIGN KEY(IdHoaDon) REFERENCES dbo.HOADON(Id),
	CONSTRAINT PK_HOADONCHITIET PRIMARY KEY(IdSanPham,IdHoaDon)
)
