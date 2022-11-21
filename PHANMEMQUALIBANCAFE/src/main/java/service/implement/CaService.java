/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.Ca;
import java.time.LocalTime;
import java.util.List;
import repository.CaRepo;
import service.ICa;

/**
 *
 * @author PC
 */
public class CaService implements ICa {

    private CaRepo cr = new CaRepo();

    @Override
    public List<Ca> getAll() {
        return cr.getAll();
    }

    @Override
    public void insertCa(String ma, LocalTime gioBD, LocalTime gioKT, int trangThai) {
       cr.insertCa(ma, gioBD, gioKT, trangThai);  
    }
    
    
//    @Override
//    public void insertChiNhanh(String ma, String quocGia, String thanhPho, Date ngayKhaiTruong, int trangThai) {
//        chinhanhRepo.insertChiNhanh(ma, quocGia, thanhPho, ngayKhaiTruong, trangThai);
//    }

}
