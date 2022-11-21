package service;

import domainmodel.KhuyenMai;
import domainmodel.NguyenLieu;
import java.util.List;
import viewmodel.KhuyenMaiDangHoatDong;
import viewmodel.NguyenLieuDangSuDung;
import viewmodel.SanPhamViewModel;

public interface ISanPhamService {

    List<SanPhamViewModel> getAllSanPham();

    String insertSanPham(String ma, String ten, float giaBan, String idkm, byte[] avatar);

    void UpdateSanPham(String id, String ma, String ten, float giaBan, KhuyenMai km, byte[] avatar);

    void deleteSanPham(String id);

    SanPhamViewModel getSanPhamById(String id);

    List<SanPhamViewModel> searchSanPham(String tenSp);

    List<KhuyenMaiDangHoatDong> getAllKhuyenMai();

    List<NguyenLieuDangSuDung> getAllNguyenLieu();
}
