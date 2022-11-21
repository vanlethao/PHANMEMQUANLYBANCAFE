package repository;

import domainmodel.KhuVuc;
import domainmodel.Ban;
import domainmodel.TaiKhoanNguoiDung;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.Hibernateutility;

public class KhuVucRepository {

    public List<KhuVuc> getAllKhuVuc() {
        List<KhuVuc> list = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            list = session.createQuery("FROM KhuVuc").list();
            trans.commit();
            session.close();
        }
        return list;
    }

    public String insertKhuVuc(String maKv, Integer TrangThai) {
        String id = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            KhuVuc kv = new KhuVuc();
            kv.setMa(maKv);
            kv.setTrangThai(TrangThai);
            id = (String) session.save(kv);
            trans.commit();
            session.close();
        }
        return id;

    }
   

    public void updateKhuVuc(KhuVuc kv,String maKv, Integer TrangThai) {
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            kv.setMa(maKv);
            kv.setTrangThai(TrangThai);
            session.update(kv);
            trans.commit();
            session.close();
        }
    }

    public KhuVuc getKhuVucFromMa(String maKhuVuc) {
        KhuVuc kv = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM KhuVuc Where Ma=:Ma");
            query.setParameter("Ma", maKhuVuc);
            List<KhuVuc> list = query.getResultList();
            if (list.size() > 0) {
                kv = list.get(0);
            }

            trans.commit();
            session.close();
        }
        return kv;
    }
    public void deleteKhuVuc(String idKhuVuc) {
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            KhuVuc kv = session.get(KhuVuc.class, idKhuVuc);
            kv.setTrangThai(0);
            session.update(kv);
            trans.commit();
            session.close();
        }
    }
    
}
