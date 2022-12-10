/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author PC
 */
public class ChiTietCaVM_Long {
      private String id;
    private String ma;
    private LocalDateTime gioDen;
    private LocalDateTime gioVe;
    private String maNV;
    private String tenNV;

    public ChiTietCaVM_Long() {
    }

    public ChiTietCaVM_Long(String id, String ma, LocalDateTime gioDen, LocalDateTime gioVe, String maNV, String tenNV) {
        this.id = id;
        this.ma = ma;
        this.gioDen = gioDen;
        this.gioVe = gioVe;
        this.maNV = maNV;
        this.tenNV = tenNV;
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

    public LocalDateTime getGioDen() {
        return gioDen;
    }

    public void setGioDen(LocalDateTime gioDen) {
        this.gioDen = gioDen;
    }

    public LocalDateTime getGioVe() {
        return gioVe;
    }

    public void setGioVe(LocalDateTime gioVe) {
        this.gioVe = gioVe;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    @Override
    public String toString() {
        return "ChiTietCaVM_Long{" + "id=" + id + ", ma=" + ma + ", gioDen=" + gioDen + ", gioVe=" + gioVe + ", maNV=" + maNV + ", tenNV=" + tenNV + '}';
    }
    
    
    
    
}
