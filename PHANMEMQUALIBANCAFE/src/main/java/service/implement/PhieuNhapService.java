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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import repository.*;
import service.IPhieuNhap;
import viewmodel.ChiTietPhieuNhapViewModel;
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
        var lstPhieuNhap = phieuNhapRepo.getAllPhieuNhap();
        for (PhieuNhapHang x : lstPhieuNhap) {
            PhieuNhapViewModel pnView = new PhieuNhapViewModel();
            pnView.setId(x.getId());
            pnView.setMaPhieuNhap(x.getMa());
//            pnView.setMaNguyenLieu(x.getNguyenLieuKey().getMa());
//            if (x.getNguyenLieuKey().getTen() != null) {
//                pnView.setTenNguyenLieu(x.getNguyenLieuKey().getTen());
//            }
            pnView.setMaNhaCungCap(x.getNhaCungCap().getMa());
            if (x.getNhaCungCap().getTen() != null) {
                pnView.setTenNhaCungCap(x.getNhaCungCap().getTen());
            }
            pnView.setMaNhanVien(x.getNhanVien().getMa());
            if (x.getNhanVien().getHoTen() != null) {
                pnView.setTenNhanVien(x.getNhanVien().getHoTen());
            }
            if (x.getNgayNhap() != null) {
                pnView.setNgayNhap(x.getNgayNhap());
            }
//            if (x.getSoLuongNhap() != null) {
//                pnView.setSoLuongNhap(new BigDecimal(x.getSoLuongNhap()));
//            }
//            if (x.getDonGia() != null) {
//                pnView.setDonGia(new BigDecimal(x.getDonGia()));
//            }
            if (x.getTrangThai() != null) {
                pnView.setTrangThai(x.getTrangThai());
            }
            lstView.add(pnView);
        }
        return lstView;
    }

    @Override
    public Set<ChiTietPhieuNhapViewModel> getPhieuNhapByChiTietPhieuNhap(String id) {
        var chiTietPhieuNhap = phieuNhapRepo.getPhieuNhapByChiTietPhieuNhap(id);
        Set<ChiTietPhieuNhapViewModel> lstView = new HashSet<>();
        for (ChiTietPhieuNhap x : chiTietPhieuNhap) {
            ChiTietPhieuNhapViewModel ctView = new ChiTietPhieuNhapViewModel();
            ctView.setIdPhieuNhap(x.getPhieuNhapKey().getId());
            ctView.setIdNguyenLieu(x.getNguyenLieuKey().getId());
            if (x.getNguyenLieuKey().getMa() != null) {
                ctView.setMaNguyenLieu(x.getNguyenLieuKey().getMa());
            }
            if (x.getNguyenLieuKey().getTen() != null) {
                ctView.setTenNguyenLieu(x.getNguyenLieuKey().getTen());
            }
            if (x.getSoLuongNhap() != null) {
                ctView.setSoLuongNhap(new BigDecimal(x.getSoLuongNhap()));
            }
            if (x.getNguyenLieuKey().getDonViTinh() != null) {
                ctView.setDonViTinh(x.getNguyenLieuKey().getDonViTinh());
            }
            if (x.getDonGia() != null) {
                ctView.setDonGia(new BigDecimal(x.getDonGia()));
            }
            lstView.add(ctView);
        }
        return lstView;
    }

    @Override
    public List<NguyenLieuViewModel_Hoang> getAllNguyenLieu() {
        List<NguyenLieuViewModel_Hoang> lstViewNL = new ArrayList<>();
        var lstNguyenLieu = phieuNhapRepo.getAllNguyenLieu();
        for (NguyenLieu x : lstNguyenLieu) {
            NguyenLieuViewModel_Hoang nlView = new NguyenLieuViewModel_Hoang();
            nlView.setId(x.getId());
            nlView.setMa(x.getMa());
            if (x.getTen() != null) {
                nlView.setTen(x.getTen());
            }
            if (x.getDonViTinh() != null) {
                nlView.setDonVitinh(x.getDonViTinh());
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
            nccView.setId(x.getId());
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
            nccView.setId(x.getId());
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
    public PhieuNhapViewModel getPhieuNhapByMa(String maPN) {
        PhieuNhapHang pn = phieuNhapRepo.getPhieuNhapByMa(maPN);
        PhieuNhapViewModel pnView = null;
        if (pn != null) {
            pnView = new PhieuNhapViewModel();
            pnView.setMaPhieuNhap(pn.getId());
        }
        return pnView;
    }

    @Override
    public NhanVienViewModel_Hoang getNhanVienByMa(String maNhanVien) {
        NhanVien nv = phieuNhapRepo.getNhanVienByMa(maNhanVien);
        NhanVienViewModel_Hoang nlView = null;
        if (nv != null) {
            nlView = new NhanVienViewModel_Hoang();
            nlView.setMa(nv.getMa());
        }
        return nlView;
    }

    @Override
    public NhaCungCapViewModel_Hoang getNhaCungCapByMa(String maNhaCungCap) {
        NhaCungCap ncc = phieuNhapRepo.getNhaCungCapByMa(maNhaCungCap);
        NhaCungCapViewModel_Hoang nlView = null;
        if (ncc != null) {
            nlView = new NhaCungCapViewModel_Hoang();
            nlView.setMa(ncc.getMa());
        }
        return nlView;
    }

    @Override
    public NguyenLieuViewModel_Hoang getNguyenLieuByMa(String maNguyenLieu) {
        NguyenLieu nl = phieuNhapRepo.getNguyenLieuByMa(maNguyenLieu);
        NguyenLieuViewModel_Hoang nlView = null;
        if (nl != null) {
            nlView = new NguyenLieuViewModel_Hoang();
            nlView.setMa(nl.getMa());
        }
        return nlView;

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
//            chiTietView.setMaNguyenLieu(x.getNguyenLieuKey().getMa());
//            if (x.getNguyenLieuKey().getTen() != null) {
//                chiTietView.setTenNguyenLieu(x.getNguyenLieuKey().getTen());
//            }
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
//            if (x.getSoLuongNhap() != null) {
//                chiTietView.setSoLuongNhap(new BigDecimal(x.getSoLuongNhap()));
//            }
//            if (x.getDonGia() != null) {
//                chiTietView.setDonGia(new BigDecimal(x.getDonGia()));
//            }
            if (x.getPhieuNhapKey().getTrangThai() != null) {
                chiTietView.setTrangThai(x.getPhieuNhapKey().getTrangThai());
            }
            lstSearchView.add(chiTietView);
        }
        return lstSearchView;
    }

    @Override
    public String insertPhieuNhap(String maPN, String idNcc, String idNv, Date ngayNhap, int trangThai) {
        return phieuNhapRepo.insertPhieuNhap(maPN, idNcc, idNv, ngayNhap, trangThai);
    }

    @Override
    public void insertCTPhieuNhap(String idPn, String idNl, float soLuongNhap, float donGia) {
        phieuNhapRepo.insertCTPhieuNhap(idPn, idNl, soLuongNhap, donGia);
    }

    @Override
    public void updateSoluongNguyenLieu(String idNguyenLieu, float soLuongNhap) {
        phieuNhapRepo.updateSoluongNguyenLieu(idNguyenLieu, soLuongNhap);
    }

    @Override
    public PhieuNhapViewModel getPhieuNhapById(String idPhieuNhap) {
        PhieuNhapHang pn = phieuNhapRepo.getPhieuNhapById(idPhieuNhap);
        PhieuNhapViewModel pnView = null;
        if (pn != null) {
            pnView = new PhieuNhapViewModel();
        }
        return pnView;
    }

    @Override
    public void updatePhieuNhap(String idPN, String maPN, String idNCC, String idNV, Date ngayNhap) {
       phieuNhapRepo.updatePhieuNhap(idPN, maPN, idNCC, idNV, ngayNhap);
    }

    @Override
    public void deleteChiTietPnbyidPn(String idPn) {
        phieuNhapRepo.deleteChiTietPnbyidPn(idPn);
    }

    @Override
    public void updateCTPhieuNhap(String idPn, String idNl, float soLuongNhap, float donGia) {
        phieuNhapRepo.updateCTPhieuNhap(idPn, idNl, soLuongNhap, donGia);
    }

    

}
