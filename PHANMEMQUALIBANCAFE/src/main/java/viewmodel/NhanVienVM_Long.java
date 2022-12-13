/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author PC
 */
public class NhanVienVM_Long {
    private String id;
    private String ten;
    private String ma;
    private String idcn;

    public NhanVienVM_Long() {
    }

    public NhanVienVM_Long(String id, String ten, String ma, String idcn) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
        this.idcn = idcn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getIdcn() {
        return idcn;
    }

    public void setIdcn(String idcn) {
        this.idcn = idcn;
    }

    @Override
    public String toString() {
        return "NhanVienVM_Long{" + "id=" + id + ", ten=" + ten + ", ma=" + ma + ", idcn=" + idcn + '}';
    }
    
    
}
