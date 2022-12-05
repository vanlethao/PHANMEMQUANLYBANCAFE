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

/**
 *
 * @author PC
 */
public interface ICa {
    List<Ca> getAll();
   void insertCa(String ma, String gioBD, String gioKT, int trangThai);
  CaViewModel_Long getSanPhamById(String id);
  String insertCTCa(String idMa,String gioDen,  String idNhanVien);
  List<ChiTietCaVM_Long> getAllCTCa();
}
