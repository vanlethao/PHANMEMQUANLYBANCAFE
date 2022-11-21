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
import java.util.List;
import viewmodel.PhieuNhapViewModel;

/**
 *
 * @author trant
 */
public interface IPhieuNhap {

    List<PhieuNhapViewModel> getAllPhieuNhap();

    List<NguyenLieu> getAllNguyenLieu();

    List<NhaCungCap> getAllNhaCungCap();

    List<NhanVien> getAllNhanVien();

    PhieuNhapHang getPhieuNhapByMa(String maPN);

    String updateTrangThaiPhieuNhap(String maPN, Integer trangThai);

}
