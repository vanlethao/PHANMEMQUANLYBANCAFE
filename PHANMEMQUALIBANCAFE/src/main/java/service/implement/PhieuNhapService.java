/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.ChiTietPhieuNhap;
import domainmodel.NguyenLieu;
import domainmodel.NhaCungCap;
import domainmodel.NhanVien;
import domainmodel.PhieuNhapHang;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repository.*;
import service.IPhieuNhap;
import viewmodel.NguyenLieuViewModel_Hoang;
import viewmodel.NhaCungCapViewModel_Hoang;
import viewmodel.NhanVienViewModel_Hoang;
import viewmodel.PhieuNhapViewModel;

/**
 *
 * @author ASUS
 */
public class PhieuNhapService implements IPhieuNhap {

    PhieuNhapRepo phieuNhapRepo;

    public PhieuNhapService() {
        phieuNhapRepo = new PhieuNhapRepo();
    }

    @Override
    public List<PhieuNhapViewModel> getAllPhieuNhap() {
        List<PhieuNhapViewModel> lstView = new ArrayList<>();
        var lstCtPhieuNhap = phieuNhapRepo.getAllPhieuNhap();
        for (ChiTietPhieuNhap x : lstCtPhieuNhap) {
            PhieuNhapViewModel pnView = new PhieuNhapViewModel();
            pnView.setId(x.getPhieuNhapKey().getId());
            pnView.setMaPhieuNhap(x.getPhieuNhapKey().getMa());
            pnView.setMaNguyenLieu(x.getNguyenLieuKey().getMa());
            if (x.getNguyenLieuKey().getTen() != null) {
                pnView.setTenNguyenLieu(x.getNguyenLieuKey().getTen());
            }
            pnView.setMaNhaCungCap(x.getPhieuNhapKey().getNhaCungCap().getMa());
            if (x.getPhieuNhapKey().getNhaCungCap().getTen() != null) {
                pnView.setTenNhaCungCap(x.getPhieuNhapKey().getNhaCungCap().getTen());
            }
            pnView.setMaNhanVien(x.getPhieuNhapKey().getNhanVien().getMa());
            if (x.getPhieuNhapKey().getNhanVien().getHoTen() != null) {
                pnView.setTenNhanVien(x.getPhieuNhapKey().getNhanVien().getHoTen());
            }
            if (x.getPhieuNhapKey().getNgayNhap() != null) {
                pnView.setNgayNhap(x.getPhieuNhapKey().getNgayNhap());
            }
            if (x.getSoLuongNhap() != null) {
                pnView.setSoLuongNhap(new BigDecimal(x.getSoLuongNhap()));
            }
            if (x.getDonGia() != null) {
                pnView.setDonGia(new BigDecimal(x.getDonGia()));
            }
            if (x.getPhieuNhapKey().getTrangThai() != null) {
                pnView.setTrangThai(x.getPhieuNhapKey().getTrangThai());
            }
            lstView.add(pnView);
        }
        return lstView;
    }

    @Override
    public List<NguyenLieuViewModel_Hoang> getAllNguyenLieu() {
        List<NguyenLieuViewModel_Hoang> lstViewNL = new ArrayList<>();
        var lstNguyenLieu = phieuNhapRepo.getAllNguyenLieu();
        for (NguyenLieu x : lstNguyenLieu) {
            NguyenLieuViewModel_Hoang nlView = new NguyenLieuViewModel_Hoang();
            nlView.setMa(x.getMa());
            if (x.getTen() != null) {
                nlView.setTen(x.getTen());
            }
            lstViewNL.add(nlView);
        }
        return lstViewNL;
    }

    @Override
    public List<NhaCungCapViewModel_Hoang> getAllNhaCungCap() {
        List<NhaCungCapViewModel_Hoang> lstViewNCC = new ArrayList<>();
        var lstNCC = phieuNhapRepo.getAllNhaCungCap();
        for (NhaCungCap x : lstNCC) {
            NhaCungCapViewModel_Hoang nccView = new NhaCungCapViewModel_Hoang();
            nccView.setMa(x.getMa());
            if (x.getTen() != null) {
                nccView.setTen(x.getTen());
            }
            lstViewNCC.add(nccView);
        }
        return lstViewNCC;
    }

    @Override
    public List<NhanVienViewModel_Hoang> getAllNhanVien() {
        List<NhanVienViewModel_Hoang> lstViewNV = new ArrayList<>();
        var lstNV = phieuNhapRepo.getAllNhanVien();
        for (NhanVien x : lstNV) {
            NhanVienViewModel_Hoang nccView = new NhanVienViewModel_Hoang();
            nccView.setMa(x.getMa());
            if (x.getHoTen() != null) {
                nccView.setHoTen(x.getHoTen());
            }
            lstViewNV.add(nccView);
        }
        return lstViewNV;
    }

    @Override
    public String updateTrangThaiPhieuNhap(String maPN, Integer trangThai) {
        return phieuNhapRepo.updateTrangThaiPhieuNhap(maPN, trangThai);
    }

    @Override
    public PhieuNhapHang getPhieuNhapByMa(String maPN) {
        return phieuNhapRepo.getPhieuNhapByMa(maPN);
    }

    @Override
    public NhanVien getNhanVienByMa(String maNhanVien) {
        return phieuNhapRepo.getNhanVienByMa(maNhanVien);
    }

    @Override
    public NhaCungCap getNhaCungCapByMa(String maNhaCungCap) {
        return phieuNhapRepo.getNhaCungCapByMa(maNhaCungCap);
    }

    @Override
    public NguyenLieu getNguyenLieuByMa(String maNguyenLieu) {
        return phieuNhapRepo.getNguyenLieuByMa(maNguyenLieu);
    }

    public static void main(String[] args) {
        PhieuNhapService hds = new PhieuNhapService();
        List<PhieuNhapViewModel> list = hds.getAllPhieuNhap();
        for (PhieuNhapViewModel x : list) {
            System.out.println(x.getMaNhanVien());
        }
    }

    @Override
    public List<PhieuNhapViewModel> searchPhieuNhap(String maPN) {
        var chiTietPhieuNhap = phieuNhapRepo.searchPhieuNhap(maPN);
        List<PhieuNhapViewModel> lstSearchView = new ArrayList<>();
        for (ChiTietPhieuNhap x : chiTietPhieuNhap) {

            PhieuNhapViewModel chiTietView = new PhieuNhapViewModel();
            chiTietView.setId(x.getPhieuNhapKey().getId());
            chiTietView.setMaPhieuNhap(x.getPhieuNhapKey().getMa());
            chiTietView.setMaNguyenLieu(x.getNguyenLieuKey().getMa());
            if (x.getNguyenLieuKey().getTen() != null) {
                chiTietView.setTenNguyenLieu(x.getNguyenLieuKey().getTen());
            }
            chiTietView.setMaNhaCungCap(x.getPhieuNhapKey().getNhaCungCap().getMa());
            if (x.getPhieuNhapKey().getNhaCungCap().getTen() != null) {
                chiTietView.setTenNhaCungCap(x.getPhieuNhapKey().getNhaCungCap().getTen());
            }
            chiTietView.setMaNhanVien(x.getPhieuNhapKey().getNhanVien().getMa());
            if (x.getPhieuNhapKey().getNhanVien().getHoTen() != null) {
                chiTietView.setTenNhanVien(x.getPhieuNhapKey().getNhanVien().getHoTen());
            }
            if (x.getPhieuNhapKey().getNgayNhap() != null) {
                chiTietView.setNgayNhap(x.getPhieuNhapKey().getNgayNhap());
            }
            if (x.getSoLuongNhap() != null) {
                chiTietView.setSoLuongNhap(new BigDecimal(x.getSoLuongNhap()));
            }
            if (x.getDonGia() != null) {
                chiTietView.setDonGia(new BigDecimal(x.getDonGia()));
            }
            if (x.getPhieuNhapKey().getTrangThai() != null) {
                chiTietView.setTrangThai(x.getPhieuNhapKey().getTrangThai());
            }
            lstSearchView.add(chiTietView);
        }
        return lstSearchView;
    }

    @Override
    public String insertPhieuNhap(String maPN, NhaCungCapViewModel_Hoang ncc, NhanVienViewModel_Hoang nv, Date ngayNhap, int trangThai) {
        NhaCungCap nhaCungCap = phieuNhapRepo.getNhaCungCapByMa(ncc.getMa());
        NhanVien nhanVien = phieuNhapRepo.getNhanVienByMa(nv.getMa());
        return phieuNhapRepo.insertPhieuNhap(maPN, nhaCungCap, nhanVien, ngayNhap, trangThai);
    }

    @Override
    public void insertCTPhieuNhap(PhieuNhapViewModel pn, NguyenLieuViewModel_Hoang nl, float soLuongNhap, float donGia) {
        PhieuNhapHang pnh = phieuNhapRepo.getPhieuNhapByMa(pn.getMaPhieuNhap());
        NguyenLieu nguyenLieu = phieuNhapRepo.getNguyenLieuById(nl.getMa());
        phieuNhapRepo.insertCTPhieuNhap(pnh, nguyenLieu, soLuongNhap, donGia);
    }

}
