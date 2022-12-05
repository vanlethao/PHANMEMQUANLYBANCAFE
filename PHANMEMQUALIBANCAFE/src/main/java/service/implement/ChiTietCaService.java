/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.Ca;
import domainmodel.ChiTietCa;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import repository.CaRepo;
import repository.ChiTietCaRepo;
import service.IChiTietCa;
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

//    @Override
//    public Set<ChiTietCaViewModel_long> getChiTietSpByIdSanPham(String id) {
//
//        Set<ChiTietCa> setChiTiet = ctCa.getChiTietSpByIdSanPham(id);
//        Set<ChiTietCaViewModel_long> setChiTietView = new HashSet<>();
//        for (ChiTietCa chiTietSP : setChiTiet) {
//            ChiTietCaViewModel_long ctView = new ChiTietCaViewModel_long();
//            ctView.setId(chiTietSP.getCaKey().getId());
//            ctView.setGioDen(chiTietSP.getCaKey().getGioBatDau());
//            ctView.setGioVe(chiTietSP.getCaKey().getGioKetThuc());
//
//            setChiTietView.add(ctView);
//        }
//        return setChiTietView;
//    }

    @Override
    public void insertChiTietCa(LocalTime gioDen, LocalTime gioVe, String idCa) {
        Ca ca = caRepo.getSanPhamById(idCa);
        ctCa.insertChiTietCa(gioDen, gioVe, ca);
    }

//    @Override
//    public Set<ChiTietCaViewModel_long> getChiTietSpByIdSanPham(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

}
