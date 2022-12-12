/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Ca;
import domainmodel.ChiNhanh;
import domainmodel.NhanVien;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.Hibernateutility;

/**
 *
 * @author PC
 */
public class CaRepo {
    
    public List<Ca> getAllCa() {
        List<Ca> lst = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Query q = session.createQuery("From Ca WHERE trangThai=1");
            lst = q.getResultList();
            session.close();
        }
        return lst;
    }

//    public Set<ChiTietCa> getChiTietCaByCa(String idCa) {
//        Set<ChiTietCa> setCa = new HashSet<>();
//        try ( Session session = Hibernateutility.getFactory().openSession()) {
//            Ca ca = session.get(Ca.class, idCa);
//            Set<ChiTietCa> chiTiet = ca.getChiTietCa();
//            if (chiTiet != null) {
//                for (ChiTietCa chiTietCa : chiTiet) {
//                    setCa.add(chiTietCa);
//                }
//            }
//            session.close();
//        }
//        return setCa;
//
//    }
    public static List<ChiNhanh> getAllChiNhanh() {
        List<ChiNhanh> ListChiNhanh = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            ListChiNhanh = session.createQuery("FROM ChiNhanh WHERE trangThai=1").list();
            session.close();
        }
        return ListChiNhanh;
    }
    
    public static Set<NhanVien> getNhanVienByChiNhanh(String idChiNhanh) {
        Set<NhanVien> setNhanVien = new HashSet<>();
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            ChiNhanh chiNhanh = session.get(ChiNhanh.class, idChiNhanh);
            Set<NhanVien> listNhanVien = chiNhanh.getSetNhanVien();
            if (listNhanVien != null) {
                for (NhanVien nhanVien : listNhanVien) {
                    setNhanVien.add(nhanVien);
                }
            }
            session.close();
        }
        return setNhanVien;
    }

//    public static void addNhanVienToCa(String idNhanVien, String idCa) {
//        try ( Session session = Hibernateutility.getFactory().openSession()) {
//            Ca ca = session.get(Ca.class, idCa);
//            Set<ChiTietCa> chiTietCa = ca.getChiTietCa();
//            NhanVien nhanVien = session.get(NhanVien.class, idNhanVien);
//            chiTietCa.add()
//            session.close();
//        }
//    }
    public String insertCa(Ca ca) {
        String id = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            id = (String) session.save(ca);
            trans.commit();
            session.close();
        }
        return id;
    }
    
}
