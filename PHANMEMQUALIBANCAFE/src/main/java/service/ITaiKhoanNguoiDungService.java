package service;

import domainmodel.NhanVien;
import java.util.List;
import viewmodel.TaiKhoanNguoiDungViewModel;

public interface ITaiKhoanNguoiDungService {

    public List<TaiKhoanNguoiDungViewModel> getAllTkNguoiDung();

    public List<NhanVien> getAllNV();

    String inserttkNguoiDung(String TenTk, String MatKhau, NhanVien nv);

   void updateTKNguoiDung(String id, String TenTk, String MatKhau, NhanVien nv1);

    public void deletetkNguoiDung(String idTk);

    public String getIdFromMa(String idTk);
}
