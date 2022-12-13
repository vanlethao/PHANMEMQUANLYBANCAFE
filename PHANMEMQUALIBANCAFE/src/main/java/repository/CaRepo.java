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

    public Ca getCabyMa(String maCa) {
        Ca ca = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Query query = session.createQuery("From Ca WHERE ma=:maCa");
            query.setParameter("maCa", maCa);
            List<Ca> ListCa = query.getResultList();
            if (ListCa.size() > 0) {
                ca = ListCa.get(0);
            }
            session.close();
        }
        return ca;
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

    public static Set<Ca> getCaOfNhanVien(String idNhanVien) {
        Set<Ca> caOfNhanVien = new HashSet<>();
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            NhanVien nhanVien = session.get(NhanVien.class, idNhanVien);
            Set<Ca> allCa = nhanVien.getSetCa();
            if (allCa != null) {
                for (Ca ca : allCa) {
                    caOfNhanVien.add(ca);
                }
            }
            session.close();
        }
        return caOfNhanVien;
    }

    public static void addCaToNhanVien(String idNhanVien, Set<String> setIdCa) {
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            NhanVien nhanVien = session.get(NhanVien.class, idNhanVien);
            nhanVien.getSetCa().clear();
            for (String idCa : setIdCa) {
                Ca ca = session.get(Ca.class, idCa);
                nhanVien.getSetCa().add(ca);
            }
            trans.commit();
            session.close();
        }
    }

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
