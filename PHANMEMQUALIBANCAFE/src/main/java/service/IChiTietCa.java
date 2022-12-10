/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.Ca;
import domainmodel.ChiTietCa;
import domainmodel.NhanVien;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import viewmodel.CaViewModel_Long;
import viewmodel.NhanVienViewModel_Hoang;
//import viewmodel.ChiTietCaViewModel_long;

/**
 *
 * @author PC
 */
public interface IChiTietCa {
//    Set<ChiTietCaViewModel_long> getChiTietSpByIdSanPham(String id);
    void insertChiTietCa(LocalDateTime gioDen, CaViewModel_Long ca, NhanVienViewModel_Hoang nv);

}
