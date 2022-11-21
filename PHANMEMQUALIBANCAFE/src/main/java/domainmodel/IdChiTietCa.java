/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainmodel;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author trant
 */
public class IdChiTietCa implements Serializable {

    private Ca caKey;
    private NhanVien nhanVienKey;

    public IdChiTietCa() {
    }

    public IdChiTietCa(Ca caKey, NhanVien nhanVienKey) {
        this.caKey = caKey;
        this.nhanVienKey = nhanVienKey;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.caKey);
        hash = 59 * hash + Objects.hashCode(this.nhanVienKey);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IdChiTietCa other = (IdChiTietCa) obj;
        if (!Objects.equals(this.caKey, other.caKey)) {
            return false;
        }
        return Objects.equals(this.nhanVienKey, other.nhanVienKey);
    }

}
