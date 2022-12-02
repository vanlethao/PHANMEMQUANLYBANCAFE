/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.ChiTietPhieuTra;
import domainmodel.PhieuTraHang;
import java.util.Date;
import java.util.List;
import java.util.Set;
import viewmodel.ChiTietPhieuTraViewModel;
import viewmodel.PhieuTraViewModel;

/**
 *
 * @author trant
 */
public interface IPhieuTra {

    List<PhieuTraViewModel> getAllPhieuTra();

//    List<ChiTietPhieuTraViewModel> getAllChiTietPhieuTra();

    Set<ChiTietPhieuTraViewModel> getPhieuTraByChiTietPhieuTra(String id);

    PhieuTraViewModel getPhieuTraByMa(String maPT);

    PhieuTraViewModel getPhieuTraByID(String id);

    String insertPhieuTra(String maPT, String idNcc, String idNv, Date ngayTra, int trangThai);

    void updateSoluongNguyenLieuTra(String idNguyenLieu, float soLuongTra);

    void insertCTPhieuTra(String idPt, String idNL, float soLuongTra, String lyDo);

    String updateTrangThaiPhieuTra(String maPT, Integer trangThai);

    List<PhieuTraViewModel> searchPhieuTra(String maPN);
}
