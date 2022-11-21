/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.ChiTietPhieuTra;
import domainmodel.PhieuTraHang;
import java.util.List;

/**
 *
 * @author trant
 */
public interface IPhieuTra {

    List<ChiTietPhieuTra> getAllPhieuNhap();

    PhieuTraHang getPhieuTraByMa(String maPT);

    String updateTrangThaiPhieuTra(String maPT, Integer trangThai);
}
