/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.ChiTietPhieuNhap;
import domainmodel.NguyenLieu;
import domainmodel.NhaCungCap;
import domainmodel.NhanVien;
import domainmodel.PhieuNhapHang;
import java.util.Date;
import java.util.List;
import viewmodel.NguyenLieuViewModel_Hoang;
import viewmodel.NhaCungCapViewModel_Hoang;
import viewmodel.NhanVienViewModel_Hoang;
import viewmodel.PhieuNhapViewModel;

/**
 *
 * @author trant
 */
public interface IPhieuNhap {

    List<PhieuNhapViewModel> getAllPhieuNhap();

    List<NguyenLieuViewModel_Hoang> getAllNguyenLieu();

    List<NhaCungCapViewModel_Hoang> getAllNhaCungCap();

    List<NhanVienViewModel_Hoang> getAllNhanVien();

    PhieuNhapViewModel getPhieuNhapByMa(String maPN);

    String updateTrangThaiPhieuNhap(String maPN, Integer trangThai);

    NhanVienViewModel_Hoang getNhanVienByMa(String maNhanVien);

    NhaCungCapViewModel_Hoang getNhaCungCapByMa(String maNhaCungCap);

    NguyenLieuViewModel_Hoang getNguyenLieuByMa(String maNguyenLieu);

    List<PhieuNhapViewModel> searchPhieuNhap(String maPN);

    String insertPhieuNhap(String maPN, NhaCungCapViewModel_Hoang ncc, NhanVienViewModel_Hoang nv, Date ngayNhap, int trangThai);

    void insertCTPhieuNhap(PhieuNhapViewModel pn, NguyenLieuViewModel_Hoang nl, float soLuongNhap, float donGia);
}
