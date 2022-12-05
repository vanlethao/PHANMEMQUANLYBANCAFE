/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Ca;
import domainmodel.ChiNhanh;
import domainmodel.ChiTietCa;
import domainmodel.IdChiTietCa;
import domainmodel.NhanVien;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.IChiTietCa;
import utility.Hibernateutility;

/**
 *
 * @author PC
 */
public class CaRepo {

    public List<Ca> getAll() {
        Session session = Hibernateutility.getFactory().openSession();
        Query q = session.createQuery("From Ca");
        List<Ca> lst = q.getResultList();
        return lst;

    }

    public List<ChiTietCa> getAllCTCa() {
        Session session = Hibernateutility.getFactory().openSession();
        Query q = session.createQuery("From ChiTietCa");
        List<ChiTietCa> lst = q.getResultList();
        return lst;

    }

//          public String insertNguyenLieu(String ma, String ten, Date hsd, String dvt, Float slt, String idChiNhanh) {
//        String id = null;
//        try ( Session session = Hibernateutility.getFactory().openSession()) {
//            Transaction trans = session.beginTransaction();
//            NguyenLieu nguyenLieu = new NguyenLieu();
//            ChiNhanh cn = session.get(ChiNhanh.class, idChiNhanh);
//            cn.getListNguyenLieu().add(nguyenLieu);
//            nguyenLieu.setMa(ma);
//            nguyenLieu.setTen(ten);
//            nguyenLieu.setHanSuDung(hsd);
//            nguyenLieu.setDonViTinh(dvt);
//            nguyenLieu.setSoLuongTon(slt);
//            id = (String) session.save(nguyenLieu);
//
//            cn.getListNguyenLieu().add(nguyenLieu);
//
//            trans.commit();
//            session.close();
//        }
//
//        return id;
//
//    }
//      public String insertBan(Integer SoBan, KhuVuc kv) {
//        String id = null;
//        try (Session session = Hibernateutility.getFactory().openSession()) {
//            Transaction trans = session.beginTransaction();
//            Ban ban = new Ban();
//            ban.setSoBan(SoBan);
//            ban.setTrangThaiSuDung(1);
//            ban.setTrangThai(0);
//            ban.setKhuVuc(kv);
//            id = (String) session.save(ban);
//            trans.commit();
//            session.close();
//        }
//        return id;
//
//    }
    public String insertCTCa(String idMa, String gioDen, String idNhanVien) {
        String id = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            ChiTietCa ctCa = new ChiTietCa();

            NhanVien nv = session.get(NhanVien.class, idNhanVien);
            nv.getChiTietCa().add(ctCa);
            Ca ca = session.get(Ca.class, idMa);
//NhanVien nv = session.get(NhanVien.class, idNhanVien);
            ctCa.setGioDen(LocalTime.parse(gioDen));
            ctCa.setCaKey(ca);
            ctCa.setNhanVienKey(nv);
            id = (String) session.save(ctCa);
            trans.commit();
            session.close();
        }
        return id;
    }

    public String insertCa(String ma, String gioBD, String gioKT, int trangThai) {
        String id = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Ca ca = new Ca();
            ca.setMa(ma);
//            ca.setGioBatDau(gioBD);
//            ca.setGioKetThuc(gioKT);
            ca.setGioBatDau(LocalTime.parse(gioBD));
            ca.setGioKetThuc(LocalTime.parse(gioKT));
            ca.setTrangThai(trangThai);
            id = (String) session.save(ca);
            trans.commit();
            session.close();
        }
        return id;
    }

    public static Ca getSanPhamById(String id) {
        Ca sp;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            sp = session.get(Ca.class, id);
            session.close();
        }
        return sp;
    }

}
