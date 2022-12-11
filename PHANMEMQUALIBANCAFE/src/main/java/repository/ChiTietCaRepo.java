/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Ca;
import domainmodel.ChiTietCa;
import domainmodel.NhanVien;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utility.Hibernateutility;

/**
 *
 * @author PC
 */
public class ChiTietCaRepo {

    public static void insertChiTietCa(LocalDateTime gioDen, Ca ca, NhanVien nv) {
        Session session = Hibernateutility.getFactory().openSession();
        Transaction trans = session.beginTransaction();
//        ChiTietSP chiTietSp = new ChiTietSP();
        ChiTietCa chiTietSp = new ChiTietCa();
        //chiTietSp.setGioDen(gioDen);

        chiTietSp.setCaKey(ca);
        chiTietSp.setNhanVienKey(nv);
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

    public static void update(LocalDateTime gioVe, Ca ca, NhanVien nv) {
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
//            cn.setMa(ma);
//            cn.setThanhPho(thanhpho);
//            cn.setQuocGia(quocgia);
            ChiTietCa ctCa = new ChiTietCa();
//ctCa.setGioDen(gioDen);
            //ctCa.setGioVe(gioVe);
            ctCa.setCaKey(ca);
            ctCa.setNhanVienKey(nv);
            session.update(ctCa);
            trans.commit();
            session.close();
        }
    }

    public static void main(String[] args) {

        Ca ca = new Ca();
        NhanVien nv = new NhanVien();
        nv.setId("BC026DB4-0CE4-4ECB-9D90-F9C43FC97984");
        ca.setId("30681BB5-1648-4AC1-A2AF-40E5F7E4D837");
        ChiTietCa CT = new ChiTietCa();

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDate = myDateObj.format(myFormatObj);

        LocalDateTime myTime = LocalDateTime.parse(formatDate, myFormatObj);

        LocalDateTime myDateObj1 = LocalDateTime.now();
        DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDate1 = myDateObj1.format(myFormatObj1);

        LocalDateTime myTime1 = LocalDateTime.parse(formatDate1, myFormatObj1);

//        insertChiTietCa(myTime1, ca, nv);
//        insertChiTietCa(myTime, ca, nv);
        update(myTime1, ca, nv);

    }
}
