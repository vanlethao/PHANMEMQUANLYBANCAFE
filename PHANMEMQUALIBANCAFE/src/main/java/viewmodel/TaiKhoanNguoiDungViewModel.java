package viewmodel;


public class TaiKhoanNguoiDungViewModel {

    private String id;
    private String TenTk;
    private String MatKhau;
    private String MaNhanVien;
    private String tenNhanVien;

    public TaiKhoanNguoiDungViewModel() {
    }

    public TaiKhoanNguoiDungViewModel(String id, String TenTk, String MatKhau, String MaNhanVien, String tenNhanVien) {
        this.id = id;
        this.TenTk = TenTk;
        this.MatKhau = MatKhau;
        this.MaNhanVien = MaNhanVien;
        this.tenNhanVien = tenNhanVien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenTk() {
        return TenTk;
    }

    public void setTenTk(String TenTk) {
        this.TenTk = TenTk;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    

    public Object[] getDataTK() {
        return new Object[]{id, TenTk, MatKhau, tenNhanVien};
    }

    @Override
    public String toString() {
        return  MaNhanVien + tenNhanVien;
    }

  
}
