package repository;

import domainmodel.KhuVuc;
import domainmodel.ChiNhanh;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.Hibernateutility;

public class KhuVucRepository {

    public Set<KhuVuc> getAllKhuVucByChiNhanh(String IdchiNhanh) {
        Set<KhuVuc> setKhuVuc = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            ChiNhanh cn = session.get(ChiNhanh.class, IdchiNhanh);
            setKhuVuc = cn.getSetKhuVuc();
            trans.commit();
            session.close();
        }
        return setKhuVuc;
    }

    public String insertKhuVucToChiNhanh(String maKV, String idChiNhanh) {
        String id = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            ChiNhanh cn = session.get(ChiNhanh.class, idChiNhanh);
            KhuVuc kv = new KhuVuc();
            kv.setMa(maKV);
            kv.setChiNhanh(cn);
            kv.setTrangThai(1);
            id = (String) session.save(kv);
            trans.commit();
            session.close();
        }
        return id;

    }

    public void updateKhuVuc(KhuVuc kv, String maKv, Integer TrangThai) {
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            kv.setMa(maKv);
            kv.setTrangThai(TrangThai);
            session.update(kv);
            trans.commit();
            session.close();
        }
    }

    public KhuVuc getKhuVucFromID(String idKhuVuc) {
        KhuVuc kv = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            kv = session.get(KhuVuc.class, idKhuVuc);
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

    public List<ChiNhanh> getAllChiNhanh() {
        List<ChiNhanh> list = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            list = session.createQuery("FROM ChiNhanh where trangThai=1").list();
            trans.commit();
            session.close();
        }
        return list;
    }

}
