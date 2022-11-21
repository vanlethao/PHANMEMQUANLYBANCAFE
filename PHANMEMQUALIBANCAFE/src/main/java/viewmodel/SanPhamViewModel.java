package viewmodel;

import java.math.BigDecimal;

public class SanPhamViewModel {

    private String idSp;
    private String maSp;
    private String tenSp;
    private BigDecimal giaBan;
    private String tenKhuyenMai;

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(String idSp, String maSp, String tenSp, BigDecimal giaBan, String tenKhuyenMai) {
        this.idSp = idSp;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.giaBan = giaBan;
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public String getIdSp() {
        return idSp;
    }

    public void setIdSp(String idSp) {
        this.idSp = idSp;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    /**
     * @return the tenKhuyenMai
     */
    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    /**
     * @param tenKhuyenMai the tenKhuyenMai to set
     */
    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

}
