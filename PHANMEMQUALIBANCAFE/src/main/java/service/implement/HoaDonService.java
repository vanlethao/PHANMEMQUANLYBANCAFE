/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import viewmodel.HoaDonViewModel;
import domainmodel.HoaDonBanHang;
import domainmodel.NhanVien;
import java.util.ArrayList;
import java.util.List;
import repository.HoaDonRepo;
import repository.PhieuNhapRepo;
import service.IHoaDon;

/**
 *
 * @author trant
 */
public class HoaDonService implements IHoaDon {

    private HoaDonRepo hoaDonRepo;

    public HoaDonService() {
        hoaDonRepo = new HoaDonRepo();
    }

    @Override
    public List<HoaDonViewModel> getAllHoaDon() {
        var hoaDon = hoaDonRepo.getAllHoaDon();
        List<HoaDonViewModel> lstView = new ArrayList<>();
        for (HoaDonBanHang x : hoaDon) {
            HoaDonViewModel qlhd = new HoaDonViewModel();
            qlhd.setMaHoaDon(x.getMa());
            qlhd.setNgayTao(x.getNgayTao());
            qlhd.setMaNhanVien(x.getNhanVien().getMa());
            qlhd.setTenNhanVien(x.getNhanVien().getHoTen());
            qlhd.setTrangThai(x.getTrangThai());
            lstView.add(qlhd);
        }
        return lstView;
    }

    @Override
    public HoaDonBanHang getHoaDonByMa(String maHD) {
        return hoaDonRepo.getHoaDonByMa(maHD);
    }

    @Override
    public String updateTrangThai(String maHD, Integer trangThai) {
        return hoaDonRepo.updateTrangThai(maHD, trangThai);
    }

    public static void main(String[] args) {
        HoaDonService hds = new HoaDonService();
        List<HoaDonViewModel> list = hds.getAllHoaDon();
        for (HoaDonViewModel hoaDonViewModel : list) {
            System.out.println(hoaDonViewModel.getTrangThai());
        }
    }
}
