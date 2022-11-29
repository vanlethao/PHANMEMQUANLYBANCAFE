/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.NhanVien;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import viewmodel.Area;
import viewmodel.KhuyenMaiDangHoatDong;
import viewmodel.ProductForSale;
import viewmodel.Table;
import viewmodel.ThemKhachViewModel;

/**
 *
 * @author trant
 */
public interface IBanHangService {

    List<ProductForSale> getAllProductForSale();

    boolean checkSo(String soLuong);

    List<Area> getAllKhuVuc();

    List<KhuyenMaiDangHoatDong> getAllKhuyenMai();

    KhuyenMaiDangHoatDong getKhuyenMaibySanPham(String id);

    List<Table> getAllBanByKhuVuc(Area are);

    String insertKhachHang(ThemKhachViewModel khachHang);

    ThemKhachViewModel getKhachHangBySdt(String sdt);

    Float getGiaTriDoiDiem();

    Float getGiaTriDiem();

    String inserHoaDon(String ma, Date ngayTao, String idNhanVien,
            Integer soBan);

    void insertChiTietHoaDon(String idSanPham, String idHoaDon, int soLuongMua,
            BigDecimal thanhTien, BigDecimal thanhTienSauKM);

    String autoGenMaHoaDon();

    NhanVien getNhanVienbyTaiKhoan(String idTaiKhoan);
}
