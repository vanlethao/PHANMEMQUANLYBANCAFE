package repository;

import domainmodel.ChiTietSP;
import domainmodel.NguyenLieu;
import domainmodel.SanPham;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.Hibernateutility;

public class ChiTietSanPhamRepository {

    public void insertChiTietSanPham(float dinhLuong, SanPham sp, NguyenLieu nguyenlieu) {
        Session session = Hibernateutility.getFactory().openSession();
        Transaction trans = session.beginTransaction();
        ChiTietSP chiTietSp = new ChiTietSP();
        chiTietSp.setDinhLuong(dinhLuong);
        chiTietSp.setSanPhamKey(sp);
        chiTietSp.setNguyenLieukey(nguyenlieu);
        session.save(chiTietSp);
        trans.commit();
        session.close();
    }

    public Set<ChiTietSP> getChiTietSpByIdSanPham(String id) {
        Set<ChiTietSP> setChiTiet = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            SanPham sp = session.get(SanPham.class, id);
            setChiTiet = sp.getChiTietSp();
            session.close();
        }
        return setChiTiet;
    }

    public static void deleteChiTietSpByIdSp(String id) {
        Set<ChiTietSP> setChiTiet = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            SanPham sp = session.get(SanPham.class, id);
            setChiTiet = sp.getChiTietSp();
            setChiTiet.clear();
            trans.commit();
            session.close();
        }

    }

    public static void main(String[] args) {
        deleteChiTietSpByIdSp("87B948F9-5E16-4065-9055-780C3AEDD55B");
    }

    public NguyenLieu getNguyenLieuByID(String id) {
        NguyenLieu nguyenLieu;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            nguyenLieu = session.get(NguyenLieu.class, id);
            session.close();
        }
        return nguyenLieu;
    }
}
