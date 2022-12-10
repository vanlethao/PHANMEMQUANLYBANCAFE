/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.Ca;
import domainmodel.ChiTietCa;
import java.time.LocalTime;
import java.util.List;
import viewmodel.CaViewModel_Long;
import viewmodel.ChiTietCaVM_Long;
import viewmodel.NhanVienViewModel_Hoang;

/**
 *
 * @author PC
 */
public interface ICa {
    List<CaViewModel_Long> getAll();
   void insertCa(String ma, String gioBD, String gioKT, int trangThai);
  CaViewModel_Long getSanPhamById(String id);
 

  List<ChiTietCaVM_Long> getAllCTCa();
}
