/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.ChiTietPhieuNhap;
import domainmodel.HoaDonBanHang;
import domainmodel.NguyenLieu;
import domainmodel.NhaCungCap;
import domainmodel.NhanVien;
import domainmodel.PhieuNhapHang;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.Hibernateutility;

/**
 *
 * @author ASUS
 */
public class PhieuNhapRepo {

    public List<ChiTietPhieuNhap> getAllPhieuNhap() {
        List<ChiTietPhieuNhap> lstCtPhieuNhap = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            lstCtPhieuNhap = session.createQuery("from ChiTietPhieuNhap").list();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lstCtPhieuNhap;
    }
    public List<NguyenLieu> getAllNguyenLieu() {
        List<NguyenLieu> lstNguyenLieu = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            lstNguyenLieu = session.createQuery("from NguyenLieu").list();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lstNguyenLieu;
    }
    public List<NhaCungCap> getAllNhaCungCap() {
        List<NhaCungCap> lstNhaCungCap = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            lstNhaCungCap = session.createQuery("from NhaCungCap").list();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lstNhaCungCap;
    }
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> lstNhanVien = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            lstNhanVien = session.createQuery("from NhanVien").list();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lstNhanVien;
    }
//    public String insertPhieuNhap(ChiTietPhieuNhap ctpn,PhieuNhapHang pnh,NguyenLieu nl,NhaCungCap ncc,NhanVien nv,){
//        
//    }
     public PhieuNhapHang getPhieuNhapByMa(String maPN) {
        PhieuNhapHang phieuNhapHang = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("From PhieuNhapHang Where Ma=:Ma");
            query.setParameter("Ma",maPN);
            phieuNhapHang =(PhieuNhapHang) query.uniqueResult();
            trans.commit();
            session.close();
        }
        return phieuNhapHang;
    }
       public String updateTrangThaiPhieuNhap(String maPN,Integer trangThai) {
           try ( Session session = Hibernateutility.getFactory().openSession()) {
               Transaction trans= session.beginTransaction();
               PhieuNhapHang phieuNhapHang = getPhieuNhapByMa(maPN);
               phieuNhapHang.setTrangThai(trangThai);
               session.update(phieuNhapHang);
               trans.commit();
               session.close();
                return "Thanh Cong";
           }catch(Exception e){
               return "That bai";
           }
    }
}
