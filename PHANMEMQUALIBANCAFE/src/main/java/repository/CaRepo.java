/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import domainmodel.Ca;
import domainmodel.ChiNhanh;
import java.time.LocalTime;
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
public class CaRepo {
     public List<Ca> getAll(){
        Session session = Hibernateutility.getFactory().openSession();
        Query q = session.createQuery("From Ca");
        List<Ca> lst = q.getResultList();
        return lst;
        
    }
     
     
          public String insertCa(String ma, LocalTime gioBD, LocalTime gioKT, int trangThai) {
        String id = null;
        try ( Session session = Hibernateutility.getFactory().openSession()) {
            Transaction trans = session.beginTransaction();
            Ca ca  = new Ca();
            ca.setMa(ma);
            ca.setGioBatDau(gioBD);
            ca.setGioKetThuc(gioKT);      
            id = (String) session.save(ca);
            trans.commit();
            session.close();
        }
        return id;
    }
          
          
     
}
