/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.Ca;
import domainmodel.ChiTietCa;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
//import viewmodel.ChiTietCaViewModel_long;

/**
 *
 * @author PC
 */
public interface IChiTietCa {
//    Set<ChiTietCaViewModel_long> getChiTietSpByIdSanPham(String id);
     void insertChiTietCa(LocalTime gioDen, LocalTime gioVe, String idCa);
}
