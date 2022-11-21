/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.time.LocalTime;
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
@Table(name = "CHITIETCA")
@IdClass(IdChiTietCa.class)
public class ChiTietCa implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCa")
    private Ca caKey;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNv")
    private NhanVien nhanVienKey;

    @Column(name = "GioDen")
    private LocalTime gioDen;

    @Column(name = "GioVe")
    private LocalTime gioVe;

    public ChiTietCa() {
    }

    public ChiTietCa(Ca caKey, NhanVien nhanVienKey, LocalTime gioDen, LocalTime gioVe) {
        this.caKey = caKey;
        this.nhanVienKey = nhanVienKey;
        this.gioDen = gioDen;
        this.gioVe = gioVe;
    }

    public Ca getCaKey() {
        return caKey;
    }

    public void setCaKey(Ca caKey) {
        this.caKey = caKey;
    }

    public NhanVien getNhanVienKey() {
        return nhanVienKey;
    }

    public void setNhanVienKey(NhanVien nhanVienKey) {
        this.nhanVienKey = nhanVienKey;
    }

    public LocalTime getGioDen() {
        return gioDen;
    }

    public void setGioDen(LocalTime gioDen) {
        this.gioDen = gioDen;
    }

    public LocalTime getGioVe() {
        return gioVe;
    }

    public void setGioVe(LocalTime gioVe) {
        this.gioVe = gioVe;
    }

}
