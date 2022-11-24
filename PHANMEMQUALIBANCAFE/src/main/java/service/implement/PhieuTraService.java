/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.ChiTietPhieuTra;
import domainmodel.NguyenLieu;
import domainmodel.NhaCungCap;
import domainmodel.NhanVien;
import domainmodel.PhieuNhapHang;
import domainmodel.PhieuTraHang;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import repository.*;
import service.IPhieuNhap;
import service.IPhieuTra;
import viewmodel.NguyenLieuViewModel_Hoang;
import viewmodel.NhaCungCapViewModel_Hoang;
import viewmodel.NhanVienViewModel_Hoang;
import viewmodel.PhieuNhapViewModel;
import viewmodel.PhieuTraViewModel;

/**
 *
 * @author ASUS
 */
public class PhieuTraService implements IPhieuTra {

    PhieuTraRepo phieuTraRepo;

    public PhieuTraService() {
        phieuTraRepo = new PhieuTraRepo();;
    }

    @Override
    public List<PhieuTraViewModel> getAllPhieuTra() {
        List<PhieuTraViewModel> lstView = new ArrayList<>();
        var lstCtPhieuTra = phieuTraRepo.getAllPhieuTra();
        for (ChiTietPhieuTra x : lstCtPhieuTra) {
            PhieuTraViewModel ptView = new PhieuTraViewModel();
            ptView.setId(x.getPhieuTraKey().getId());
            ptView.setMaPhieuNhap(x.getPhieuTraKey().getMa());
            ptView.setMaNguyenLieu(x.getNguyenLieuKey().getMa());
            if (x.getNguyenLieuKey().getTen() != null) {
                ptView.setTenNguyenLieu(x.getNguyenLieuKey().getTen());
            }
            ptView.setMaNhaCungCap(x.getPhieuTraKey().getNhaCungCap().getMa());
            if (x.getPhieuTraKey().getNhaCungCap().getTen() != null) {
                ptView.setTenNhaCungCap(x.getPhieuTraKey().getNhaCungCap().getTen());
            }
            ptView.setMaNhanVien(x.getPhieuTraKey().getNhanVien().getMa());
            if (x.getPhieuTraKey().getNhanVien().getHoTen() != null) {
                ptView.setTenNhanVien(x.getPhieuTraKey().getNhanVien().getHoTen());
            }
            if (x.getPhieuTraKey().getNgayTra() != null) {
                ptView.setNgayTra(x.getPhieuTraKey().getNgayTra());
            }
            if (x.getSoLuongTra() != null) {
                ptView.setSoLuongTra(new BigDecimal(x.getSoLuongTra()));
            }
            if (x.getLiDo() != null) {
                ptView.setLyDo(x.getLiDo());
            }
            if (x.getPhieuTraKey().getTrangThai() != null) {
                ptView.setTrangThai(x.getPhieuTraKey().getTrangThai());
            }
            lstView.add(ptView);
        }
        return lstView;
    }

    @Override
    public PhieuTraHang getPhieuTraByMa(String maPT) {
        return phieuTraRepo.getPhieuTraByMa(maPT);
    }

    @Override
    public String updateTrangThaiPhieuTra(String maPT, Integer trangThai) {
        return phieuTraRepo.updateTrangThaiPhieuTra(maPT, trangThai);
    }

    @Override
    public List<PhieuTraViewModel> searchPhieuTra(String maPN) {
        List<PhieuTraViewModel> lstView = new ArrayList<>();
        var lstCtPhieuTra = phieuTraRepo.searchPhieuTra(maPN);
         for (ChiTietPhieuTra x : lstCtPhieuTra) {
            PhieuTraViewModel ptView = new PhieuTraViewModel();
            ptView.setId(x.getPhieuTraKey().getId());
            ptView.setMaPhieuNhap(x.getPhieuTraKey().getMa());
            ptView.setMaNguyenLieu(x.getNguyenLieuKey().getMa());
            if (x.getNguyenLieuKey().getTen() != null) {
                ptView.setTenNguyenLieu(x.getNguyenLieuKey().getTen());
            }
            ptView.setMaNhaCungCap(x.getPhieuTraKey().getNhaCungCap().getMa());
            if (x.getPhieuTraKey().getNhaCungCap().getTen() != null) {
                ptView.setTenNhaCungCap(x.getPhieuTraKey().getNhaCungCap().getTen());
            }
            ptView.setMaNhanVien(x.getPhieuTraKey().getNhanVien().getMa());
            if (x.getPhieuTraKey().getNhanVien().getHoTen() != null) {
                ptView.setTenNhanVien(x.getPhieuTraKey().getNhanVien().getHoTen());
            }
            if (x.getPhieuTraKey().getNgayTra() != null) {
                ptView.setNgayTra(x.getPhieuTraKey().getNgayTra());
            }
            if (x.getSoLuongTra() != null) {
                ptView.setSoLuongTra(new BigDecimal(x.getSoLuongTra()));
            }
            if (x.getLiDo() != null) {
                ptView.setLyDo(x.getLiDo());
            }
            if (x.getPhieuTraKey().getTrangThai() != null) {
                ptView.setTrangThai(x.getPhieuTraKey().getTrangThai());
            }
            lstView.add(ptView);
        }
        return lstView;
    }

}
