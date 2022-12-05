/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.time.LocalTime;

/**
 *
 * @author PC
 */
public class CaViewModel_Long {
    private String id;
    private String ma;
    private LocalTime gioBD;
    private LocalTime gioKT;

    public CaViewModel_Long() {
    }

    public CaViewModel_Long(String id, String ma, LocalTime gioBD, LocalTime gioKT) {
        this.id = id;
        this.ma = ma;
        this.gioBD = gioBD;
        this.gioKT = gioKT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public LocalTime getGioBD() {
        return gioBD;
    }

    public void setGioBD(LocalTime gioBD) {
        this.gioBD = gioBD;
    }

    public LocalTime getGioKT() {
        return gioKT;
    }

    public void setGioKT(LocalTime gioKT) {
        this.gioKT = gioKT;
    }

    @Override
    public String toString() {
        return "CaViewModel_Long{" + "id=" + id + ", ma=" + ma + ", gioBD=" + gioBD + ", gioKT=" + gioKT + '}';
    }
    
    
     public Object[] toDataRow() {
        return new Object[]{ma, gioBD,gioKT};
    }
}
