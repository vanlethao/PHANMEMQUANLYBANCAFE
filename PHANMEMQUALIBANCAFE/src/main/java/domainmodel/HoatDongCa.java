/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author trant
 */
@Entity
@Table(name = "HOATDONGCA")
public class HoatDongCa implements Serializable {

    @Id
    @GeneratedValue(generator = "GenIdSql")
    @GenericGenerator(name = "GenIdSql", strategy = "guid")
    @Column(name = "Id")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCa")
    private Ca ca;

    @Column(name = "NgayThucHien")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date ngayThucHien;

    @Column(name = "GioMoCa")
    private LocalTime gioMoCa;

    @Column(name = "GioDongCa")
    private LocalTime gioDongCa;

    @Column(name = "TienDauCa")
    private Float tienDauCa;

    @Column(name = "TienCuoiCa")
    private Float tienCuoiCa;

    public HoatDongCa() {
    }

    public HoatDongCa(String id, Ca ca, Date ngayThucHien, LocalTime gioMoCa, LocalTime gioDongCa, Float tienDauCa, Float tienCuoiCa) {
        this.id = id;
        this.ca = ca;
        this.ngayThucHien = ngayThucHien;
        this.gioMoCa = gioMoCa;
        this.gioDongCa = gioDongCa;
        this.tienDauCa = tienDauCa;
        this.tienCuoiCa = tienCuoiCa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ca getCa() {
        return ca;
    }

    public void setCa(Ca ca) {
        this.ca = ca;
    }

    public Date getNgayThucHien() {
        return ngayThucHien;
    }

    public void setNgayThucHien(Date ngayThucHien) {
        this.ngayThucHien = ngayThucHien;
    }

    public LocalTime getGioMoCa() {
        return gioMoCa;
    }

    public void setGioMoCa(LocalTime gioMoCa) {
        this.gioMoCa = gioMoCa;
    }

    public LocalTime getGioDongCa() {
        return gioDongCa;
    }

    public void setGioDongCa(LocalTime gioDongCa) {
        this.gioDongCa = gioDongCa;
    }

    public Float getTienDauCa() {
        return tienDauCa;
    }

    public void setTienDauCa(Float tienDauCa) {
        this.tienDauCa = tienDauCa;
    }

    public Float getTienCuoiCa() {
        return tienCuoiCa;
    }

    public void setTienCuoiCa(Float tienCuoiCa) {
        this.tienCuoiCa = tienCuoiCa;
    }

}
