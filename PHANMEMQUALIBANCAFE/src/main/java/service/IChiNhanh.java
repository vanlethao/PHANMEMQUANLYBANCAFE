/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainmodel.ChiNhanh;
import java.util.Date;
import java.util.List;


/**
 *
 * @author PC
 */
public interface IChiNhanh {

    List<ChiNhanh> getAll();
    void insertChiNhanh(String ma, String quocGia, String thanhPho, Date ngayKhaiTruong, int trangThai);
 void update(ChiNhanh cnV, String ma, String thanhpho, String quocgia);
 void deleteMauSac(String maMau);
  String getChiNhanh(String ma);
  List<ChiNhanh> findByMa(String ma);

}
