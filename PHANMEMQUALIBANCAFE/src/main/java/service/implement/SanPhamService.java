package service.implement;

import domainmodel.KhuyenMai;
import domainmodel.NguyenLieu;
import domainmodel.SanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import repository.SanPhamRespository;
import service.ISanPhamService;
import viewmodel.KhuyenMaiDangHoatDong;
import viewmodel.NguyenLieuDangSuDung;
import viewmodel.SanPhamViewModel;

public class SanPhamService implements ISanPhamService {

    private SanPhamRespository sanPhamRepo;

    public SanPhamService() {
        sanPhamRepo = new SanPhamRespository();
    }

    @Override
    public List<SanPhamViewModel> getAllSanPham() {
        var listSanPham = sanPhamRepo.getAllSanPham();
        List<SanPhamViewModel> lisetView = new ArrayList<>();
        if (listSanPham != null) {
            for (SanPham sanPham : listSanPham) {
                if (sanPham.getTrangThai() == 1) {
                    SanPhamViewModel spView = new SanPhamViewModel();
                    spView.setIdSp(sanPham.getId());
                    spView.setMaSp(sanPham.getMa());
                    if (sanPham.getTen() != null) {
                        spView.setTenSp(sanPham.getTen());
                    }
                    if (sanPham.getGiaBan() != null) {
                        spView.setGiaBan(new BigDecimal(sanPham.getGiaBan()));
                    }
                    if (sanPham.getKhuyenMai().getTen() != null) {
                        spView.setTenKhuyenMai(sanPham.getKhuyenMai().getTen());
                    }
                    lisetView.add(spView);
                }

            }
        }
        return lisetView;
    }

    @Override
    public String insertSanPham(String ma, String ten, float giaBan, String idkm, byte[] avatar) {
        String id = sanPhamRepo.insertSanPham(ma, ten, giaBan, idkm, avatar);
        return id;
    }

    @Override
    public void UpdateSanPham(String id, String ma, String ten, float giaBan, KhuyenMai km, byte[] avatar) {
        sanPhamRepo.UpdateSanPham(id, ma, ten, giaBan, km, avatar);
    }

    @Override
    public void deleteSanPham(String id) {
        sanPhamRepo.deleteSanPham(id);
    }

    @Override
    public List<SanPhamViewModel> searchSanPham(String tenSp) {
        List<SanPhamViewModel> listView = new ArrayList<>();
        var listSp = sanPhamRepo.searchSanPham(tenSp);
        for (SanPham sanPham : listSp) {
            SanPhamViewModel spView = new SanPhamViewModel();
            spView.setMaSp(sanPham.getMa());
            if (sanPham.getTen() != null) {
                spView.setTenSp(sanPham.getTen());
            }
            if (sanPham.getGiaBan() != null) {
                spView.setGiaBan(new BigDecimal(sanPham.getGiaBan()));
            }
            listView.add(spView);

        }
        return listView;
    }

    @Override
    public SanPhamViewModel getSanPhamById(String id) {
        SanPham sanPham = sanPhamRepo.getSanPhamById(id);
        SanPhamViewModel spView = new SanPhamViewModel();
        spView.setMaSp(sanPham.getMa());
        if (sanPham.getTen() != null) {
            spView.setTenSp(sanPham.getTen());
        }
        if (sanPham.getGiaBan() != null) {
            spView.setGiaBan(new BigDecimal(sanPham.getGiaBan()));
        }
        return spView;
    }

    @Override
    public List<KhuyenMaiDangHoatDong> getAllKhuyenMai() {
        var listKm = sanPhamRepo.getAllKhuyenMai();
        List<KhuyenMaiDangHoatDong> listSaleActive = new ArrayList<>();
        if (listKm != null) {
            for (KhuyenMai khuyenMai : listKm) {
                KhuyenMaiDangHoatDong kmActive = new KhuyenMaiDangHoatDong();
                kmActive.setIdKhuyenMai(khuyenMai.getId());
                if (khuyenMai.getTen() != null) {
                    kmActive.setTenKhuyenMai(khuyenMai.getTen());
                }
                if (khuyenMai.getMota() != null) {
                    kmActive.setMoTa(khuyenMai.getMota());
                }
                listSaleActive.add(kmActive);
            }
        }
        return listSaleActive;
    }

    @Override
    public List<NguyenLieuDangSuDung> getAllNguyenLieu() {
        List<NguyenLieuDangSuDung> listNguyenLieu = new ArrayList<>();
        var ListNl = sanPhamRepo.getAllNguyenLieu();
        if (ListNl != null) {
            for (NguyenLieu nguyenLieu : ListNl) {
                NguyenLieuDangSuDung nl = new NguyenLieuDangSuDung();
                nl.setId(nguyenLieu.getId());
                nl.setMa(nguyenLieu.getMa());
                nl.setTen(nguyenLieu.getTen());
                listNguyenLieu.add(nl);
            }
        }
        return listNguyenLieu;
    }

}
