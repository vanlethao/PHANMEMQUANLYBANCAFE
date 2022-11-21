/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.ChiNhanh;
import domainmodel.NguyenLieu;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.Hibernateutility;

/**
 *
 * @author PC
 */
public class NguyenLieuRepo {

    public List<NguyenLieu> getAll() {
        Session session = Hibernateutility.getFactory().openSession();
        Query q = session.createQuery("From NguyenLieu");
        List<NguyenLieu> lst = q.getResultList();
        return lst;

    }

    public String insertNguyenLieu(String ma, String ten, Date hsd, String dvt, Float slt) {
        String id = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            NguyenLieu nguyenLieu = new NguyenLieu();
            nguyenLieu.setMa(ma);
            nguyenLieu.setTen(ten);
            nguyenLieu.setHanSuDung(hsd);
            nguyenLieu.setDonViTinh(dvt);
            nguyenLieu.setSoLuongTon(slt);

            id = (String) session.save(nguyenLieu);
            trans.commit();
            session.close();
        }
        return id;
    }

    public Boolean deleteMauSac(String maMau) {
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            NguyenLieu mauSac = session.get(NguyenLieu.class, getNguyeLieu(maMau).getId());
            session.delete(mauSac);
            trans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public NguyenLieu getNguyeLieu(String ma) {
        NguyenLieu mauSac = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM NguyenLieu Where ma=:ma");
            query.setParameter("ma", ma);
            List<NguyenLieu> list = query.getResultList();
            if (list.size() > 0) {
                mauSac = list.get(0);
            }
            trans.commit();
            session.close();
        }
        return mauSac;
    }

    public void update(String id, String ma, String ten, String donViTinh) {
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            NguyenLieu nguyenlieu = session.get(NguyenLieu.class, id);
            nguyenlieu.setMa(ma);
            nguyenlieu.setTen(ten);
            nguyenlieu.setDonViTinh(donViTinh);
            session.update(nguyenlieu);
            trans.commit();
            session.close();
        }
    }
}
