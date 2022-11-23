package service;

import java.util.List;
import viewmodel.NguyenLieuDangSuDung;
import viewmodel.SanPhamViewModel;

public interface ISanPhamService {

    List<SanPhamViewModel> getAllSanPhamDangBan();

    List<SanPhamViewModel> getAllSanPhamDaXoa();

    String insertSanPham(String ma, String ten, float giaBan, byte[] avatar);

    void UpdateSanPham(String id, String ma, String ten, float giaBan, byte[] avatar);

    void deleteSanPham(String id);

    SanPhamViewModel getSanPhamById(String id);

    SanPhamViewModel getSanPhamByMa(String ma);

    List<SanPhamViewModel> searchSanPham(String tenSp);

    List<NguyenLieuDangSuDung> getAllNguyenLieu();
}
