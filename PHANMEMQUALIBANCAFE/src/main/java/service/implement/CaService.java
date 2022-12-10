/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.Ca;
import domainmodel.ChiTietCa;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import repository.CaRepo;
import service.ICa;
import viewmodel.CaViewModel_Long;
import viewmodel.ChiTietCaVM_Long;
import viewmodel.NhanVienViewModel_Hoang;

/**
 *
 * @author PC
 */
public class CaService implements ICa {

    private CaRepo cr;

    
//     public SanPhamService() {
//        cr = new CaRepo();
//    }

    public CaService() {
        cr = new CaRepo();
    }
    
    
    
    @Override
    public List<CaViewModel_Long> getAll() {
//        var lst = cr.getAll();
//        List<CaViewModel_Long> lstVM = new ArrayList<>();
//        return lstVM;

  var allCa = cr.getAll();
       
       List<CaViewModel_Long> lstViewMD= new ArrayList<>();
       for(Ca ca : allCa){
//           lstViewMD.add(new ChiTietPhieuKiemKeViewModel_Long("", "", ctpk.getSoLuong(), ctpk.getSoLuongChenhlech(), ctpk.getSoLuongThucTe(), ctpk.getLiDo()));
//lstViewMD.add(new NguyenLieuViewModel_Long(ctpk.getId(), ctpk.getMa(), ctpk.getTen(), ctpk.getHanSuDung(), ctpk.getDonViTinh(), ctpk.getSoLuongTon()));
lstViewMD.add(new CaViewModel_Long(ca.getId(), ca.getMa(), ca.getGioBatDau(), ca.getGioKetThuc()));
       }
       return lstViewMD;
    }

    @Override
    public void insertCa(String ma, String gioBD, String gioKT, int trangThai) {
        cr.insertCa(ma, gioBD, gioKT, trangThai);
    }

    @Override
    public CaViewModel_Long getSanPhamById(String id) {
        Ca sanPham = cr.getSanPhamById(id);
        CaViewModel_Long caView = new CaViewModel_Long();
        caView.setId(sanPham.getId());
        caView.setMa(sanPham.getMa());

        return caView;
    }

//    @Override
//    public String insertCTCa(String idMa, String gioDen, String idNhanVien) {
//     return cr.insertCTCa(idMa, gioDen, idNhanVien);
//    }

//    @Override
//    public List<ChiTietCaVM_Long> getAllCTCa() {
//          var allPKK = cr.getAllCTCa();
//       
//       List<ChiTietCaVM_Long> lstViewMD= new ArrayList<>();
//       for(ChiTietCa ctCa : allPKK){
////           lstViewMD.add(new ChiTietPhieuKiemKeViewModel_Long("", "", ctpk.getSoLuong(), ctpk.getSoLuongChenhlech(), ctpk.getSoLuongThucTe(), ctpk.getLiDo()));
//lstViewMD.add(new ChiTietCaVM_Long(ctCa.getCaKey().getId(),ctCa.getCaKey().getMa() , ctCa.getGioDen(), ctCa.getGioVe(), ctCa.getNhanVienKey().getMa(), ctCa.getNhanVienKey().getHoTen()));
//
//       }
//       return lstViewMD;
//    }

   

    @Override
    public List<ChiTietCaVM_Long> getAllCTCa() {
        var allCa = cr.getAllCTCa();
       
       List<ChiTietCaVM_Long> lstViewMD= new ArrayList<>();
       for(ChiTietCa ctca : allCa){
//           lstViewMD.add(new ChiTietPhieuKiemKeViewModel_Long("", "", ctpk.getSoLuong(), ctpk.getSoLuongChenhlech(), ctpk.getSoLuongThucTe(), ctpk.getLiDo()));
//lstViewMD.add(new NguyenLieuViewModel_Long(ctpk.getId(), ctpk.getMa(), ctpk.getTen(), ctpk.getHanSuDung(), ctpk.getDonViTinh(), ctpk.getSoLuongTon()));
//lstViewMD.add(new CaViewModel_Long(ca.getId(), ca.getMa(), ca.getGioBatDau(), ca.getGioKetThuc()));
lstViewMD.add(new ChiTietCaVM_Long(ctca.getCaKey().getId(), ctca.getCaKey().getMa(), ctca.getGioDen(), ctca.getGioVe(), ctca.getNhanVienKey().getId(), ctca.getNhanVienKey().getHoTen()));
       }
       return lstViewMD;
    }

    
}
