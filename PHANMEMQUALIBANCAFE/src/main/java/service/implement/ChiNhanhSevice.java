/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.ChiNhanh;
import domainmodel.KhuVuc;
import domainmodel.NhanVien;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import repository.ChiNhanhRepo;
import repository.KhuVucRepository;

import service.IChiNhanh;
import utility.Hibernateutility;
import viewmodel.ChiNhanhVM_Long;
import viewmodel.ChiNhanhViewModel_Long;
import viewmodel.KhuVucViewModel;
import viewmodel.NhanVienViewModel_Hoang;

/**
 *
 * @author PC
 */
public class ChiNhanhSevice implements IChiNhanh {

    private ChiNhanhRepo chinhanhRepo = new ChiNhanhRepo();
    KhuVucRepository kr = new KhuVucRepository();
    

//    @Override
//    public void insertChiNhanh(String ma, String quocGia, String thanhPho, Date ngayKhaiTruong, int trangThai) {
//        chinhanhRepo.insertChiNhanh(ma, quocGia, thanhPho, ngayKhaiTruong, trangThai);
//    }
    @Override
    public String getChiNhanh(String ma) {
        String id = null;
        if (chinhanhRepo.getChiNhanh(ma) == null) {
            return id;
        } else {
            return id = chinhanhRepo.getChiNhanh(ma).getId();
        }
    }

    @Override
    public void update(ChiNhanh cn, String ma, String thanhpho, String quocgia) {
        ChiNhanh chinhanh = chinhanhRepo.getChiNhanh(cn.getMa());
        chinhanhRepo.update(chinhanh, ma, thanhpho, quocgia);
    }

//    @Override
//    public List<ChiNhanhViewModel_Long> getAll() {
//        var lst = chinhanhRepo.getAll();
//        List<ChiNhanhViewModel_Long> lstVM = new ArrayList<>();
//      if(lst!=null){
//          for (ChiNhanh chiNhanh : lst) {
//              ChiNhanhViewModel_Long cnVM = new ChiNhanhViewModel_Long();
//              if(chiNhanh.getQuocGia()!=null){
//                  cnVM.setQuocGia(chiNhanh.getQuocGia());
//              }
//              if(chiNhanh.getThanhPho()!=null){
//                  cnVM.setThanhPho(chiNhanh.getThanhPho());
//              }
//             lstVM.add(cnVM);
//          }
//          
//      }
//
//        for (ChiNhanhViewModel_Long cnVM : lstVM) {
//            lstVM.add(new ChiNhanhViewModel_Long(cnVM.getId(), cnVM.getMa(), cnVM.getQuocGia(), cnVM.getThanhPho(), cnVM.getNgayKhaiTruong(), cnVM.getGiaTriDiem(), cnVM.getGiaTriDoiDiem(), cnVM.getIdThuongHieu()));
//        }
//
//        return lstVM;
////return chinhanhRepo.getAll();
//
//    }
    @Override
    public List<ChiNhanhVM_Long> getAll() {
//        return toDataView(chinhanhRepo.getAll());
        var allCN = chinhanhRepo.getAll();
        List<ChiNhanhVM_Long> lstViewMD = new ArrayList<>();
        for (ChiNhanh cn : allCN) {
            lstViewMD.add(new ChiNhanhVM_Long(cn.getId(), cn.getMa(), cn.getQuocGia(), cn.getThanhPho(), cn.getNgayKhaiTruong(), cn.getTrangThai(), cn.getGiaTriDoiDiem(), cn.getGiaTriDiem(),""));
        }
        return lstViewMD;

    }

//       @Override
//    public List<BanViewModel> getAllBanByKhuVuc(String idKhuVuc) {
//        var allBan = banRepository.getAllBanByKhuVuc(idKhuVuc);
//        List<BanViewModel> listView = new ArrayList<>();
//        for (Ban ban : allBan) {
//            BanViewModel banView = new BanViewModel();
//            if (ban.getTrangThaiSuDung() == 1) {
//                if (ban.getKhuVuc() != null) {
//                    banView.setMakhuvuc(ban.getKhuVuc().getMa());
//                } else {
//                    banView.setMakhuvuc("chưa có thông tin");
//                }
//                listView.add(new BanViewModel(ban.getId(), ban.getSoBan(), ban.getKhuVuc().getMa()));
//            }
//
//        }
//        return listView;
//    }
    private List<ChiNhanhVM_Long> toDataView(List<ChiNhanh> chiNhanhs) {
        List<ChiNhanhVM_Long> chiNhanhVs = new ArrayList<>();
        for (ChiNhanh cn : chiNhanhs) {
            ChiNhanhVM_Long cnV = toChiNhanhView(cn);

            chiNhanhVs.add(cnV);
        }
        return chiNhanhVs;
    }

    private ChiNhanhVM_Long toChiNhanhView(ChiNhanh cn) {
        return new ChiNhanhVM_Long(cn.getId(), cn.getMa(), cn.getQuocGia(), cn.getThanhPho(), cn.getNgayKhaiTruong(), cn.getTrangThai(), cn.getGiaTriDoiDiem(), cn.getGiaTriDiem(),"");
    }

//      var allPKK = pkkRepo.getAllPKK();
//       List<PhieuKiemKeViewModel_Long> lstViewMD= new ArrayList<>();
//       for(PhieuKiemKe pk : allPKK){
//           lstViewMD.add(new PhieuKiemKeViewModel_Long(pk.getId(),pk.getMa(),pk.getNgayKiemKe(),pk.getTrangThai()));
//       }
//       return lstViewMD;
    @Override
    public void deleteMauSac(String maMau) {
        ChiNhanh chinhanh = chinhanhRepo.getChiNhanh(maMau);
        chinhanhRepo.deleteMauSac(maMau);
    }

    @Override
    public List<ChiNhanh> findByMa(String ma) {
        return chinhanhRepo.findByMa(ma);
    }

    public static void main(String[] args) {
        System.out.println(new ChiNhanhRepo().findByMa("CN1"));
    }

//    @Override
//    public void insertChiNhanh(String ma, String quocGia, String thanhPho, Date ngayKhaiTruong, float giaTriDiem, float giaTriDoiDiem, int trangThai) {
//        chinhanhRepo.insertChiNhanh(ma, quocGia, thanhPho, ngayKhaiTruong, giaTriDiem, giaTriDoiDiem, trangThai);
//    }
    @Override
    public String insertChiNhanh(String ma, String quocGia, String thanhPho, Date ngayKhaiTruong, float giaTriDiem, float giaTriDoiDiem, int trangThai) {
//            KhuVuc kv = khuVucRepository.getKhuVucFromID(kvView.getIdKhuVuc());
//        return banRepository.insertBan(SoBan, kv);

        return chinhanhRepo.insertChiNhanh(ma, quocGia, thanhPho, ngayKhaiTruong, giaTriDiem, giaTriDoiDiem, trangThai);
    }




}
