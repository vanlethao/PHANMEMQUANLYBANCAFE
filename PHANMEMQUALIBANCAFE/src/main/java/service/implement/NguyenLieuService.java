/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.NguyenLieu;
import java.util.Date;
import java.util.List;
import repository.NguyenLieuRepo;

import service.INguyenLieu;

/**
 *
 * @author PC
 */
public class NguyenLieuService implements INguyenLieu {

    private NguyenLieuRepo nr = new NguyenLieuRepo();

    @Override
    public List<NguyenLieu> getAll() {
        return nr.getAll();
    }

    @Override
    public String insertNguyenLieu(String ma, String ten, Date hsd, String dvt, Float slt) {
        return nr.insertNguyenLieu(ma, ten, hsd, dvt, slt);
    }

    @Override
    public String getNguyeLieu(String ma) {
        String id = null;
        if (nr.getNguyeLieu(ma) == null) {
            return id;
        } else {
            return id = nr.getNguyeLieu(ma).getId();
        }
    }

    @Override
    public void deleteNguyenLieu(String maNL) {
        NguyenLieu nguyenlieu = nr.getNguyeLieu(maNL);
        nr.deleteMauSac(maNL);
    }

    @Override
    public void update(String id, String ma, String ten, String donViTinh) {
        nr.update(id, ma, ten, donViTinh);
    }

    public static void main(String[] args) {
        NguyenLieuService ns = new NguyenLieuService();
        ns.update("BC99620B-A27E-436A-8B12-628CCCDF31F9", "nl1", "sss", "111");
    }

}
