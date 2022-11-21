/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author trant
 */
@Entity
@Table(name = "CHITIETPHIEUNHAP")
@IdClass(IdChiTietPhieuNhap.class)
public class ChiTietPhieuNhap implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdPhieuNhap")
    private PhieuNhapHang phieuNhapKey;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNguyenLieu")
    private NguyenLieu nguyenLieuKey;

    @Column(name = "SoLuongNhap")
    private float soLuongNhap;

    @Column(name = "DonGia")
    private float donGia;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(PhieuNhapHang phieuNhapKey, NguyenLieu nguyenLieuKey, float soLuongNhap, float donGia) {
        this.phieuNhapKey = phieuNhapKey;
        this.nguyenLieuKey = nguyenLieuKey;
        this.soLuongNhap = soLuongNhap;
        this.donGia = donGia;
    }

    public PhieuNhapHang getPhieuNhapKey() {
        return phieuNhapKey;
    }

    public void setPhieuNhapKey(PhieuNhapHang phieuNhapKey) {
        this.phieuNhapKey = phieuNhapKey;
    }

    public NguyenLieu getNguyenLieuKey() {
        return nguyenLieuKey;
    }

    public void setNguyenLieuKey(NguyenLieu nguyenLieuKey) {
        this.nguyenLieuKey = nguyenLieuKey;
    }

    public float getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(float soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

}
