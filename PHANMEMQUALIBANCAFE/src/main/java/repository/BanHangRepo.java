/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Ban;
import domainmodel.KhuVuc;
import domainmodel.SanPham;
import java.util.HashSet;

import java.util.List;
import java.util.Set;
import org.hibernate.Session;
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

}
