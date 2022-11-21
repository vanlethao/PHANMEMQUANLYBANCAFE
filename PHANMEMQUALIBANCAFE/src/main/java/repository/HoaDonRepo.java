/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Ban;
import domainmodel.HoaDonBanHang;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.*;

/**
 *
 * @author trant
 */
public class HoaDonRepo {

    public static List<HoaDonBanHang> getAllHoaDon() {
        List<HoaDonBanHang> list;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            list = session.createQuery("FROM HoaDonBanHang").list();
            session.close();
        }
        return list;
    }

    public HoaDonBanHang getHoaDonByMa(String maHD) {
        HoaDonBanHang hdbh = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("From HoaDonBanHang Where Ma=:Ma");
            query.setParameter("Ma",maHD);
            hdbh =(HoaDonBanHang) query.uniqueResult();
            trans.commit();
            session.close();
        }
        return hdbh;
    }

    public String updateTrangThai(String maHD,Integer trangThai) {
           try ( Session session = Hibernateutility.getFactory().openSession()) {
               Transaction trans= session.beginTransaction();
               HoaDonBanHang hdbh = getHoaDonByMa(maHD);
               hdbh.setTrangThai(trangThai);
               session.update(hdbh);
               trans.commit();
               session.close();
                return "Thanh Cong";
           }catch(Exception e){
               return "That bai";
           }
           
    }

    public static void main(String[] args) {
        List<HoaDonBanHang> list = getAllHoaDon();
        for (HoaDonBanHang ban : list) {
            System.out.println(ban.getId());
        }
    }
}
