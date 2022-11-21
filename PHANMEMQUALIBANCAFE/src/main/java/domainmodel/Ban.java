/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author trant
 */
@Entity
@Table(name = "BAN")
public class Ban implements Serializable {

    @Id
    @GeneratedValue(generator = "GenIdSql")
    @GenericGenerator(name = "GenIdSql", strategy = "guid")
    @Column(name = "Id")
    private String id;
    @Column(name = "SoBan")
    private Integer soBan;
    @Column(name = "TrangThai")
    private Integer trangThai;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKhuVuc")
    private KhuVuc khuVuc;

    public Ban() {
    }

    public Ban(String id, Integer soBan, Integer trangThai, KhuVuc khuVuc) {
        this.id = id;
        this.soBan = soBan;
        this.trangThai = trangThai;
        this.khuVuc = khuVuc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSoBan() {
        return soBan;
    }

    public void setSoBan(Integer soBan) {
        this.soBan = soBan;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public KhuVuc getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(KhuVuc khuVuc) {
        this.khuVuc = khuVuc;
    }

}
