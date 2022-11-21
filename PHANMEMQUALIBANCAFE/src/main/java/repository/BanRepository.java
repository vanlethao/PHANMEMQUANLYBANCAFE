package repository;

import domainmodel.Ban;
import domainmodel.HoaDonBanHang;
import domainmodel.KhuVuc;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.Hibernateutility;

public class BanRepository {

    public List<Ban> getAllBan() {
        List<Ban> list = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            list = session.createQuery("FROM Ban").list();
            trans.commit();
            session.close();
        }
        return list;
    }

    public String insertBan(Integer SoBan, KhuVuc kv) {
        String id = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Ban ban = new Ban();
            ban.setSoBan(SoBan);
            ban.setTrangThaiSuDung(1);
            ban.setTrangThai(0);
            ban.setKhuVuc(kv);
            id = (String) session.save(ban);
            trans.commit();
            session.close();
        }
        return id;

    }

    public void updateBan(String idBan, KhuVuc kv) {
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Ban ban = session.get(Ban.class, idBan);
            ban.setKhuVuc(kv);
            session.update(ban);
            trans.commit();
            session.close();
        }
    }

    public void deleteBan(String idBan) {
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Ban ban = session.get(Ban.class, idBan);
            ban.setTrangThaiSuDung(0);
            session.update(ban);
            trans.commit();
            session.close();
        }
    }

    public Integer getBanFormSoBan(Integer soBan) {
        Ban ban = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM Ban Where SoBan=:SoBan");
            query.setParameter("SoBan", soBan);
            List<Ban> list = query.getResultList();
            if (list.size() > 0) {
                ban = list.get(0);
            }

            trans.commit();
            session.close();
        }
        return soBan;
    }
}
