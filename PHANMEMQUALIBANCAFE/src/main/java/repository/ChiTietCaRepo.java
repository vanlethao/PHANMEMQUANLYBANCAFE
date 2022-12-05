/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Ca;
import domainmodel.ChiTietCa;
import domainmodel.NhanVien;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.Hibernateutility;

/**
 *
 * @author PC
 */
public class ChiTietCaRepo {


    public void insertChiTietCa(LocalTime gioDen, LocalTime gioVe, Ca ca) {
             Session session = Hibernateutility.getFactory().openSession();
        Transaction trans = session.beginTransaction();
//        ChiTietSP chiTietSp = new ChiTietSP();
ChiTietCa chiTietSp = new ChiTietCa();
        chiTietSp.setGioDen(gioDen);
        chiTietSp.setGioVe(gioVe);
        chiTietSp.setCaKey(ca);
        session.save(chiTietSp);
        trans.commit();
        session.close();
    }
    
    

    public Set<ChiTietCa> getChiTietSpByIdSanPham(String id) {
        Set<ChiTietCa> setChiTiet = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Ca ca = session.get(Ca.class, id);
            setChiTiet = ca.getChiTietCa();
            session.close();
        }
        return setChiTiet;
    }
    
    public NhanVien getNhanVienByID(String id) {
        NhanVien nhanVien;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            nhanVien = session.get(NhanVien.class, id);
            session.close();
        }
        return nhanVien;
    }


}
