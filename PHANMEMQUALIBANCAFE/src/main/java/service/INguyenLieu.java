/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.ChiNhanh;
import domainmodel.NguyenLieu;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public interface INguyenLieu {
    List<NguyenLieu> getAll();
    String insertNguyenLieu(String ma, String ten, Date hsd, String dvt, Float slt);
     void deleteNguyenLieu(String maNL);
   void update(String id, String ma, String ten, String donViTinh);
  String getNguyeLieu(String ma);
}
