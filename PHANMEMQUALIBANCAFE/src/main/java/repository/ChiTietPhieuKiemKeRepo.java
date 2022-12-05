/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.ChiTietPhieuKiemKe;
import domainmodel.NguyenLieu;
import domainmodel.PhieuKiemKe;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.Hibernateutility;

/**
 *
 * @author PC
 */
public class ChiTietPhieuKiemKeRepo {
public Set<ChiTietPhieuKiemKe> getCYPKKbyPKK(String idPhieu){
    Set<ChiTietPhieuKiemKe> setCT = null;
      try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            PhieuKiemKe pkk = session.get(PhieuKiemKe.class, idPhieu);
//            setBan = kv.getListBan();
            setCT = pkk.getChiTietphieuKiem();
            trans.commit();
            session.close();
        }
        return setCT;
}
    
     public Set<ChiTietPhieuKiemKe> getPhieuNhapByChiTietPhieuNhap(String id) {
        Set<ChiTietPhieuKiemKe> setCTPN = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            PhieuKiemKe pn = session.get(PhieuKiemKe.class, id);
            setCTPN = pn.getChiTietphieuKiem();
            session.close();
        }
        return setCTPN;
    }

    public List<ChiTietPhieuKiemKe> getAllChiTietHoaDon() {
        List<ChiTietPhieuKiemKe> lstChiTietPKK = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            lstChiTietPKK = session.createQuery("From ChiTietPhieuKiemKe").list();
            trans.commit();
            session.close();
        }
        return lstChiTietPKK;
    }

    public void insertNguyenLieu(float SoLuong, float SoLuongThucTe, float SoLuongChenhLech, String liDo, String idnl, String idpk) {

        Session session = Hibernateutility.getFactory().openSession();
            Transaction trans = session.beginTransaction();
            ChiTietPhieuKiemKe CTpk = new ChiTietPhieuKiemKe();
            PhieuKiemKe pk = session.get(PhieuKiemKe.class, idpk);
            NguyenLieu nl = session.get(NguyenLieu.class, idnl);
            CTpk.setKiemKeKey(pk);
            CTpk.setNguyenLieuKey(nl);
            CTpk.setSoLuong(SoLuong);
            CTpk.setSoLuongChenhlech(SoLuongChenhLech);
            CTpk.setSoLuongThucTe(SoLuongThucTe);
            CTpk.setLiDo(liDo);
//            CTpk.setKiemKeKey(pkk);
session.save(CTpk);

            trans.commit();
            session.close();
        

//        return id;
    }

//    public static void main(String[] args) {
//        PhieuKiemKe pk = new PhieuKiemKe();
////                pk.setId("458B9550-3DA9-4606-89D9-01C0140204CE");
//        ChiTietPhieuKiemKe ct = new ChiTietPhieuKiemKe();
////       ct.getKiemKeKey().setId(id);
//
//        insertNguyenLieu(0, 0, 0, "sss", "72E60E8A-D4A3-41AC-977D-604B727BBEF8", "458B9550-3DA9-4606-89D9-01C0140204CE");
//    }

}
