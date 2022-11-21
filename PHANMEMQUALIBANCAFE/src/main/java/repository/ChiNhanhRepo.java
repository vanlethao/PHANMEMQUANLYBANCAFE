/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.ChiNhanh;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import utility.Hibernateutility;

/**
 *
 * @author PC
 */
public class ChiNhanhRepo{
     public List<ChiNhanh> getAll(){
        Session session = Hibernateutility.getFactory().openSession();
        Query q = session.createQuery("From ChiNhanh");
        List<ChiNhanh> lst = q.getResultList();
        return lst;
        
    }
    
     public String insertChiNhanh(String ma, String quocGia, String thanhPho, Date ngayKhaiTruong, int trangThai) {
        String id = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            ChiNhanh chinhanh = new ChiNhanh();
            chinhanh.setMa(ma);
            chinhanh.setQuocGia(quocGia);
            chinhanh.setThanhPho(thanhPho);
            chinhanh.setNgayKhaiTruong(ngayKhaiTruong);
            chinhanh.setTrangThai(trangThai);
          
            id = (String) session.save(chinhanh);
            trans.commit();
            session.close();
        }
        return id;
    }
//     


    public void update(ChiNhanh cn, String ma, String thanhpho, String quocgia) {
                try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            cn.setMa(ma);
            cn.setThanhPho(thanhpho);
            cn.setQuocGia(quocgia);
            session.update(cn);
            trans.commit();
            session.close();
        }
    }
    
   
      
         
               public Boolean deleteMauSac(String maMau) {
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            ChiNhanh mauSac = session.get(ChiNhanh.class, getChiNhanh(maMau).getId());
           session.delete(mauSac);
            trans.commit();
            return true;
            }catch(Exception e){
                e.printStackTrace();
           
        }
        return null;
      }
        
    


    public ChiNhanh getChiNhanh(String ma) {
                ChiNhanh chinhanh = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Query query = session.createQuery("FROM ChiNhanh Where ma=:ma");
            query.setParameter("ma", ma);
            List<ChiNhanh> list = query.getResultList();
            if (list.size() > 0) {
                chinhanh = list.get(0);
            }
            trans.commit();
            session.close();
        }
        return chinhanh;
    }
    
       
       public List<ChiNhanh> findByMa(String ma) {
        Transaction trans = null;
        List<ChiNhanh> listChiNhanh = new ArrayList<>();
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            trans = session.beginTransaction();
            Query query = session.createQuery("SELECT ChiNhanh FROM ChiNhanh WHERE Ma=:ma");
            query.setParameter("Ma", "%" + ma + "%");
           
           
            trans.commit();
            session.close();
        } catch (Exception ex) {
            System.out.println("Lỗi ko thể tìm kiếm");
        }
        return listChiNhanh;
    }
}
