package repository;

import domainmodel.ChiTietSP;
import domainmodel.KhuyenMai;
import domainmodel.NguyenLieu;
import domainmodel.SanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.Hibernateutility;

public class SanPhamRespository {

    public List<SanPham> getAllSanPham() {
        List<SanPham> list = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            list = session.createQuery("FROM SanPham").list();
            session.close();
        }
        return list;
    }

    public String insertSanPham(String ma, String ten, float giaBan, String idKhuyenMai, byte[] avatar) {
        String id = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            SanPham sanpham = new SanPham();
            sanpham.setId(id);
            sanpham.setMa(ma);
            sanpham.setGiaBan(giaBan);
            sanpham.setTrangThai(1);
            sanpham.setKhuyenMai(getKhyenMaiById(idKhuyenMai));
            sanpham.setAvatar(avatar);
            id = (String) session.save(sanpham);
            trans.commit();
            session.close();
        }
        return id;

    }

    public void UpdateSanPham(String id, String ma, String ten, float giaBan, KhuyenMai km, byte[] avatar) {
        try (Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            SanPham sanpham = session.get(SanPham.class, id);
            sanpham.setMa(ma);
            sanpham.setGiaBan(giaBan);
            sanpham.setKhuyenMai(km);
            sanpham.setAvatar(avatar);
            session.update(sanpham);
            trans.commit();
            session.close();
        }

    }

    public void deleteSanPham(String id) {
        Session session = Hibernateutility.getFactory().openSession();
        Transaction trans = session.beginTransaction();
        SanPham sanPham = session.get(SanPham.class, id);
        sanPham.setTrangThai(0);
        session.update(sanPham);
        trans.commit();
        session.close();
    }

    public List<SanPham> searchSanPham(String tenSp) {
        Transaction trans = null;
        List<SanPham> listSP = new ArrayList<>();
        try (Session session = Hibernateutility.getFactory().openSession()) {
            trans = session.beginTransaction();
            Query query = session.createQuery("FROM SanPham WHERE ten like :Ten");
            query.setParameter("Ten", "%" + tenSp + "%");
            List<SanPham> listSearch = query.list();
            for (SanPham sanPham : listSearch) {
                listSP.add(sanPham);
            }
            trans.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Lỗi ko thể tìm kiếm");
        }
        return listSP;
    }

    public static SanPham getSanPhamById(String id) {
        SanPham sp;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            sp = session.get(SanPham.class, id);
            session.close();
        }
        return sp;
    }

    public List<KhuyenMai> getAllKhuyenMai() {
        List<KhuyenMai> listKm = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            listKm = session.createQuery("FROM KhuyenMai").list();
            session.close();
        }
        return listKm;
    }

    public KhuyenMai getKhyenMaiById(String id) {
        KhuyenMai khuyenMai;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            khuyenMai = session.get(KhuyenMai.class, id);
            session.close();
        }
        return khuyenMai;
    }

    public List<NguyenLieu> getAllNguyenLieu() {
        List<NguyenLieu> listNguyenLieu = null;
        try (Session session = Hibernateutility.getFactory().openSession()) {
            listNguyenLieu = session.createQuery("FROM NguyenLieu").list();
            session.close();
        }
        return listNguyenLieu;
    }
}
