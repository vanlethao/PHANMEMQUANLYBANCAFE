/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Ban;
import domainmodel.KhachHang;
import domainmodel.KhuVuc;
import domainmodel.KhuyenMai;
import domainmodel.SanPham;
import java.math.BigDecimal;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.Hibernateutility;

/**
 *
 * @author trant
 */
public class BanHangRepo {

    public static List<SanPham> getAllSanPham() {
        List<SanPham> listSp = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            listSp = session.createQuery("FROM SanPham WHERE trangThai=1").list();
            session.close();
        }
        return listSp;
    }

    public static List<KhuVuc> getAllKhuVuc() {
        List<KhuVuc> listKhuVuc = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            listKhuVuc = session.createQuery("FROM KhuVuc WHERE trangThai=1").list();
            session.close();
        }
        return listKhuVuc;
    }

    public static List<KhuyenMai> getAllKhuyenMai() {
        List<KhuyenMai> listKhuyenMai = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            listKhuyenMai = session.createQuery("FROM KhuyenMai WHERE trangThai=1").list();
            session.close();
        }
        return listKhuyenMai;
    }

    public static Set<Ban> getAllBanByKhuVuc(KhuVuc khuVuc) {
        Set<Ban> setBan = new HashSet<>();
        Set<Ban> setBanDangHoatDong = new HashSet<>();
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            KhuVuc kv = session.get(KhuVuc.class, khuVuc.getId());
            setBan = kv.getListBan();
            for (Ban ban : setBan) {
                if (ban.getTrangThaiSuDung() == 1) {
                    setBanDangHoatDong.add(ban);
                }
            }
            session.close();
        }
        return setBanDangHoatDong;
    }

    public static KhuyenMai getKhuyenMaibySanPham(String id) {
        KhuyenMai khuyenMai = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            SanPham sp = session.get(SanPham.class, id);
            if (sp.getKhuyenMai() != null) {
                khuyenMai = sp.getKhuyenMai();
            }
            session.close();
        }
        return khuyenMai;
    }

    public String insertKhachHang(KhachHang khachHang) {
        String id = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            id = (String) session.save(khachHang);
            trans.commit();
            session.close();
        }
        return id;

    }

    public static KhachHang getKhachHangBySdt(String sdt) {
        KhachHang kh = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Query query = session.createQuery("FROM KhachHang WHERE sdt=:sdtKhach");
            query.setParameter("sdtKhach", sdt);
            List<KhachHang> listKh = query.getResultList();
            if (!listKh.isEmpty()) {
                kh = listKh.get(0);
            }
            session.close();
        }
        return kh;
    }

}
