/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.ChiNhanh;
import domainmodel.NguyenLieu;
import java.util.Date;
import java.util.List;
import viewmodel.ChiNhanhVM_Long;
import viewmodel.NguyenLieuViewModel_Long;

/**
 *
 * @author PC
 */
public interface INguyenLieu {
    List<NguyenLieuViewModel_Long> getAll();
//      void insertNguyenLieuToChiNhanh(String idChiNhanh, NguyenLieu nguyenLieu, String ma, String ten, Date hsd, String dvt, Float slt);
    String insertNguyenLieu(String ma, String ten, Date hsd, String dvt, Float slt, String idChiNhanh);
    
     void deleteMauSac(String idnguyenLieu, String idChiNhanh);
void deleteNguyenLieu(String idNguyenLieu);
     void update(String id, String ma, String ten, String donViTinh);
  String getNguyeLieu(String ma);
}
