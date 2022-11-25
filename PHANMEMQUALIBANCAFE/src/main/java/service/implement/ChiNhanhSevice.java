/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.ChiNhanh;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import repository.ChiNhanhRepo;

import service.IChiNhanh;
import utility.Hibernateutility;

/**
 *
 * @author PC
 */
public class ChiNhanhSevice implements IChiNhanh {

    private ChiNhanhRepo chinhanhRepo = new ChiNhanhRepo();

    @Override
    public void insertChiNhanh(String ma, String quocGia, String thanhPho, Date ngayKhaiTruong, int trangThai) {
        chinhanhRepo.insertChiNhanh(ma, quocGia, thanhPho, ngayKhaiTruong, trangThai);
    }

    @Override
    public String getChiNhanh(String ma) {
        String id = null;
        if (chinhanhRepo.getChiNhanh(ma) == null) {
            return id;
        } else {
            return id = chinhanhRepo.getChiNhanh(ma).getId();
        }
    }

    @Override
    public void update(ChiNhanh cn, String ma, String thanhpho, String quocgia) {
        ChiNhanh chinhanh = chinhanhRepo.getChiNhanh(cn.getMa());
        chinhanhRepo.update(chinhanh, ma, thanhpho, quocgia);
    }

    @Override
    public List<ChiNhanh> getAll() {

        var allmauSac = chinhanhRepo.getAll();
        List<ChiNhanh> listView = new ArrayList<>();
        for (ChiNhanh chinhanh : allmauSac) {
            //listView.add(new ChiNhanh(null, chinhanh.getMa(), chinhanh.getQuocGia(), chinhanh.getThanhPho(), chinhanh.getNgayKhaiTruong(), chinhanh.getTrangThai(), chinhanh.getThuongHieu()));
        }
        return listView;
    }
//

    @Override
    public void deleteMauSac(String maMau) {
        ChiNhanh chinhanh = chinhanhRepo.getChiNhanh(maMau);
        chinhanhRepo.deleteMauSac(maMau);
    }

    @Override
    public List<ChiNhanh> findByMa(String ma) {
        return chinhanhRepo.findByMa(ma);
    }

    public static void main(String[] args) {
        System.out.println(new ChiNhanhRepo().findByMa("CN1"));
    }

}
