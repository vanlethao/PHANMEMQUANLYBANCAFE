/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.TaiKhoanNguoiDung;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utility.Hibernateutility;

/**
 *
 * @author ASUS
 */
public class Login_NguoiDungRepo {
     public TaiKhoanNguoiDung getNguoiDung(String tenTaiKhoan,String matKhau) {
      TaiKhoanNguoiDung taiKhoan  = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM TaiKhoanNguoiDung Where TenTK=:tenTaiKhoan and MatKhau=:matKhau");
            query.setParameter("tenTaiKhoan", tenTaiKhoan);
            query.setParameter("matKhau", matKhau);
            taiKhoan = (TaiKhoanNguoiDung) query.uniqueResult();
            trans.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return taiKhoan;
    }
}
