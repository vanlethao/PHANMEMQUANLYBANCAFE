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
import java.util.ArrayList;
import java.util.List;
import repository.*;
import service.IPhieuNhap;
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
            pnView.setMaPhieuNhap(x.getPhieuNhapKey().getMa());
            pnView.setMaNguyenLieu(x.getNguyenLieuKey().getMa());
            pnView.setTenNguyenLieu(x.getNguyenLieuKey().getTen());
            pnView.setMaNhaCungCap(x.getPhieuNhapKey().getNhaCungCap().getMa());
            pnView.setTenNhaCungCap(x.getPhieuNhapKey().getNhaCungCap().getTen());
            pnView.setMaNhanVien(x.getPhieuNhapKey().getNhanVien().getMa());
            pnView.setTenNhanVien(x.getPhieuNhapKey().getNhanVien().getHoTen());
            pnView.setNgayNhap(x.getPhieuNhapKey().getNgayNhap());
            pnView.setSoLuongNhap(x.getSoLuongNhap());
            pnView.setDonGia(x.getDonGia());
            pnView.setTrangThai(x.getPhieuNhapKey().getTrangThai());
            lstView.add(pnView);
        }
        return lstView;
    }

    @Override
    public List<NguyenLieu> getAllNguyenLieu() {
        return phieuNhapRepo.getAllNguyenLieu();
    }

    @Override
    public List<NhaCungCap> getAllNhaCungCap() {
        return phieuNhapRepo.getAllNhaCungCap();
    }

    @Override
    public List<NhanVien> getAllNhanVien() {
        return phieuNhapRepo.getAllNhanVien();
    }

    @Override
    public PhieuNhapHang getPhieuNhapByMa(String maPN) {
        return phieuNhapRepo.getPhieuNhapByMa(maPN);
    }

    @Override
    public String updateTrangThaiPhieuNhap(String maPN, Integer trangThai) {
        return phieuNhapRepo.updateTrangThaiPhieuNhap(maPN, trangThai);
    }

    public static void main(String[] args) {
        PhieuNhapService hds = new PhieuNhapService();
        List<PhieuNhapViewModel> list = hds.getAllPhieuNhap();
        for (PhieuNhapViewModel x : list) {
            System.out.println(x.getMaNhanVien());
        }
    }
}
