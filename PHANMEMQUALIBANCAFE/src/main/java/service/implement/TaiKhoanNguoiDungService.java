package service.implement;

import domainmodel.NhanVien;
import domainmodel.TaiKhoanNguoiDung;

import java.util.ArrayList;
import java.util.List;
import repository.TaiKhoanNguoiDungRepository;
import service.ITaiKhoanNguoiDungService;
import viewmodel.TaiKhoanNguoiDungViewModel;

public class TaiKhoanNguoiDungService implements ITaiKhoanNguoiDungService {

    TaiKhoanNguoiDungRepository taiKhoanNguoiDungRepository;

    public TaiKhoanNguoiDungService() {
        taiKhoanNguoiDungRepository = new TaiKhoanNguoiDungRepository();
    }

    @Override
    public List<TaiKhoanNguoiDungViewModel> getAllTkNguoiDung() {
        var allTk = taiKhoanNguoiDungRepository.getAllTaiKhoanNguoiDung();
        List<TaiKhoanNguoiDungViewModel> listView = new ArrayList<>();
        for (TaiKhoanNguoiDung tk : allTk) {
            if (tk.getTrangThai() !=0) {
                 listView.add(new TaiKhoanNguoiDungViewModel(tk.getId(), tk.getTenTK(), tk.getMatKhau(), tk.getNhanVien().getHoTen()));
            }
           
        }
        return listView;
    }
    @Override
    public List<NhanVien> getAllNV() {
    
        var nv = taiKhoanNguoiDungRepository.getAllNhanVien();
        List<NhanVien> listView = new ArrayList<>();
        for (NhanVien NV : nv) {
            NhanVien nvView = new NhanVien();
            nvView.setId(NV.getId());
            nvView.setMa(NV.getMa());
            nvView.setHoTen(NV.getHoTen());
            listView.add(nvView);
        }
        return listView;
  
    }
    @Override
    public String inserttkNguoiDung(String TenTk, String MatKhau, NhanVien nv) {      
        return taiKhoanNguoiDungRepository.insertTaiKhoanNguoiDung(TenTk, MatKhau, nv);
    }

     @Override
    public void updateTKNguoiDung(String id, String TenTk, String MatKhau, NhanVien nv1) {
        NhanVien nv = taiKhoanNguoiDungRepository.getNhanVienFromHoTen(nv1.getHoTen());
        taiKhoanNguoiDungRepository.updateTaiKhoanNguoiDung(id, TenTk,MatKhau,nv);
    }

    @Override
    public void deletetkNguoiDung(String idTk) {
        taiKhoanNguoiDungRepository.deleteTaiKhoanNguoiDung(idTk);
    }

    @Override
    public String getIdFromMa(String idTk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
