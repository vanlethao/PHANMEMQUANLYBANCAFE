/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.Ca;
import domainmodel.ChiTietCa;
import domainmodel.NhanVien;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import repository.CaRepo;
import repository.ChiTietCaRepo;
import service.IChiTietCa;
import viewmodel.CaViewModel_Long;
import viewmodel.NhanVienViewModel_Hoang;
//import viewmodel.ChiTietCaViewModel_long;

/**
 *
 * @author PC
 */
public class ChiTietCaService implements IChiTietCa {

    ChiTietCaRepo ctCa;
    CaRepo caRepo;

    public ChiTietCaService() {
        ctCa = new ChiTietCaRepo();
    }



    @Override
    public void insertChiTietCa(LocalDateTime gioDen, CaViewModel_Long ca, NhanVienViewModel_Hoang nv) {
//              Ca ca = caRepo.getSanPhamById(Ca);
              Ca ca1 = caRepo.getSanPhamById(ca.getId());
//              NhanVien nv1 = caRepo.getNhanVienFromID(nv.getId());
NhanVien nv1 = ctCa.getNhanVienByID(nv.getId());
        ctCa.insertChiTietCa(gioDen, ca1, nv1);
    }

}
