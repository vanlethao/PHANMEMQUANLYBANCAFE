/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.ChiTietPhieuTra;
import domainmodel.PhieuTraHang;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.*;
import utility.Hibernateutility;

/**
 *
 * @author ASUS
 */
public class PhieuTraRepo {
    public List<ChiTietPhieuTra> getAllPhieuNhap() {
        List<ChiTietPhieuTra> lstCtPhieuTra = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            lstCtPhieuTra = session.createQuery("from ChiTietPhieuTra").list();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lstCtPhieuTra;
    }
     public PhieuTraHang getPhieuTraByMa(String maPT) {
        PhieuTraHang phieuTraHang = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("From PhieuTraHang Where Ma=:Ma");
            query.setParameter("Ma",maPT);
            phieuTraHang =(PhieuTraHang) query.uniqueResult();
            trans.commit();
            session.close();
        }
        return phieuTraHang;
    }
       public String updateTrangThaiPhieuTra(String maPT,Integer trangThai) {
           try ( Session session = Hibernateutility.getFactory().openSession()) {
               Transaction trans= session.beginTransaction();
               PhieuTraHang phieuTraHang = getPhieuTraByMa(maPT);
               phieuTraHang.setTrangThai(trangThai);
               session.update(phieuTraHang);
               trans.commit();
               session.close();
                return "Thành công";
           }catch(Exception e){
               return "Thất bại";
           }
    }
}
