/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import domainmodel.NguyenLieu;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class PhieuNhapViewModel {

    private String id;
    private String maPhieuNhap;
    private String maNguyenLieu;
    private String tenNguyenLieu;
    private String maNhaCungCap;
    private String tenNhaCungCap;
    private String maNhanVien;
    private String tenNhanVien;
    private Date ngayNhap;
    private float soLuongNhap;
    private double donGia;
    private int trangThai;

    public double thanhTien() {
        return soLuongNhap * donGia;
    }

    public PhieuNhapViewModel() {
    }

    public PhieuNhapViewModel(String id, String maPhieuNhap, String maNguyenLieu, String tenNguyenLieu, String maNhaCungCap, String tenNhaCungCap, String maNhanVien, String tenNhanVien, Date ngayNhap, float soLuongNhap, double donGia, int trangThai) {
        this.id = id;
        this.maPhieuNhap = maPhieuNhap;
        this.maNguyenLieu = maNguyenLieu;
        this.tenNguyenLieu = tenNguyenLieu;
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.ngayNhap = ngayNhap;
        this.soLuongNhap = soLuongNhap;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaNguyenLieu() {
        return maNguyenLieu;
    }

    public void setMaNguyenLieu(String maNguyenLieu) {
        this.maNguyenLieu = maNguyenLieu;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public float getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(float soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    public String getStatus(){
        if (trangThai ==0 ) {
            return "Đã hủy";
        }else if (trangThai ==1) {
            return "Phiếu tạm";
        }else if(trangThai == 3){
            return "Đã hoàn thành";
        }
        return null;
    }
    public Object[] getDataPhieuNhapView() {
        return new Object[]{maPhieuNhap, maNguyenLieu, tenNguyenLieu, maNhaCungCap,
            tenNhaCungCap, maNhanVien, tenNhanVien, ngayNhap, soLuongNhap, donGia,thanhTien(), getStatus()};
    }
}
