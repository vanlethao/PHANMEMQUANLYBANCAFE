/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.Ban;
import domainmodel.KhuVuc;
import domainmodel.SanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import repository.BanHangRepo;
import service.IBanHangService;
import viewmodel.Area;
import viewmodel.ProductForSale;
import viewmodel.Table;

/**
 *
 * @author trant
 */
public class BanHangService implements IBanHangService {

    BanHangRepo _BanHangRepo;

    public BanHangService() {
        _BanHangRepo = new BanHangRepo();
    }

    @Override
    public List<ProductForSale> getAllProductForSale() {
        List<ProductForSale> listProductForSale = new ArrayList<>();
        var product = _BanHangRepo.getAllSanPham();
        if (product != null) {
            for (SanPham sanPham : product) {
                ProductForSale pfs = new ProductForSale();
                pfs.setIdSp(sanPham.getId());
                pfs.setMaSp(sanPham.getMa());
                if (sanPham.getTen() != null) {
                    pfs.setTenSp(sanPham.getTen());
                }
                if (sanPham.getGiaBan() != null) {
                    pfs.setGiaBan(new BigDecimal(sanPham.getGiaBan()));
                }
                if (sanPham.getTrangThai() != null) {
                    pfs.setTrangThai(sanPham.getTrangThai());
                }
                if (sanPham.getKhuyenMai() != null) {
                    pfs.setTenKhuyenMai(sanPham.getKhuyenMai().getTen());
                }
                if (sanPham.getAvatar() != null) {
                    pfs.setAvatar(sanPham.getAvatar());
                }
                listProductForSale.add(pfs);
            }
        }
        return listProductForSale;
    }

    @Override
    public boolean checkSoLuongMua(String soLuong) {
        Pattern checkInt = Pattern.compile("^[0-9]+$");
        if (!checkInt.matcher(soLuong).find()) {
            return false;
        }
        return true;
    }

    @Override
    public List<Area> getAllKhuVuc() {
        List<Area> listArea = new ArrayList<>();
        var khuVuc = _BanHangRepo.getAllKhuVuc();
        if (khuVuc != null) {
            for (KhuVuc kv : khuVuc) {
                Area area = new Area();
                area.setIdArea(kv.getId());
                area.setCodeArea(kv.getMa());
                listArea.add(area);
            }
        }
        return listArea;
    }

    @Override
    public List<Table> getAllBanByKhuVuc(Area area) {
        KhuVuc kv = new KhuVuc();
        kv.setId(area.getIdArea());
        List<Table> listTable = new ArrayList<>();
        var listBan = BanHangRepo.getAllBanByKhuVuc(kv);
        if (listBan.size() > 0) {
            for (Ban ban : listBan) {
                Table table = new Table();
                table.setSoBan(ban.getSoBan());
                table.setTrangThaiBan(ban.getTrangThai());
                listTable.add(table);
            }
        }
        return listTable;
    }
}
