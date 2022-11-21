/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author trant
 */
@Entity
@Table(name = "CA")
public class Ca implements Serializable {

    @Id
    @GeneratedValue(generator = "GenIdSql")
    @GenericGenerator(name = "GenIdSql", strategy = "guid")
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "GioBatDau")
    private LocalTime gioBatDau;

    @Column(name = "GioKetThuc")
    private LocalTime gioKetThuc;

    @Column(name = "TrangThai")
    private Integer trangThai;
    @OneToMany(mappedBy = "caKey", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ChiTietCa> chiTietCa;

    public Ca() {
    }

    public Ca(String id, String ma, LocalTime gioBatDau, LocalTime gioKetThuc, Integer trangThai, Set<ChiTietCa> chiTietCa) {
        this.id = id;
        this.ma = ma;
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
        this.trangThai = trangThai;
        this.chiTietCa = chiTietCa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(LocalTime gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public LocalTime getGioKetThuc() {
        return gioKetThuc;
    }

    public void setGioKetThuc(LocalTime gioKetThuc) {
        this.gioKetThuc = gioKetThuc;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Set<ChiTietCa> getChiTietCa() {
        return chiTietCa;
    }

    public void setChiTietCa(Set<ChiTietCa> chiTietCa) {
        this.chiTietCa = chiTietCa;
    }

    /**
     * @return the ma
     */
    public String getMa() {
        return ma;
    }

    /**
     * @param ma the ma to set
     */
    public void setMa(String ma) {
        this.ma = ma;
    }
    
    
        @Override
    public String toString() {
        return "Ca{" + "id=" + id + ", ma=" + ma + ", gioBatDau=" + gioBatDau + ", gioKetThuc=" + gioKetThuc + ", trangThai=" + trangThai + ", chiTietCa=" + chiTietCa + '}';
    }
    
    
    public Object[] toDataRow() {
        return new Object[]{ma, gioBatDau,gioKetThuc, trangThai==1?"con":"ko"};
    }

}
