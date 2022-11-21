package viewmodel;

import java.math.BigDecimal;

public class ChiTietSPViewModel {

    private String maNguyenLieu;
    private String tenNguyenLieu;
    private BigDecimal dinhLuong;

    public ChiTietSPViewModel() {
    }

    public ChiTietSPViewModel(String maNguyenLieu, String tenNguyenLieu, BigDecimal dinhLuong) {
        this.maNguyenLieu = maNguyenLieu;
        this.tenNguyenLieu = tenNguyenLieu;
        this.dinhLuong = dinhLuong;
    }

    public String getMaNguyenLieu() {
        return maNguyenLieu;
    }

    public void setMaNguyenLieu(String maNguyenLieu) {
        this.maNguyenLieu = maNguyenLieu;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public BigDecimal getDinhLuong() {
        return dinhLuong;
    }

    public void setDinhLuong(BigDecimal dinhLuong) {
        this.dinhLuong = dinhLuong;
    }

}
