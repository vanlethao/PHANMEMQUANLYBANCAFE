package viewmodel;


public class KhuVucViewModel {
    private String idKhuVuc;
    private String makhuvuc;
    private int trangthai;

    public KhuVucViewModel() {
    }

    public KhuVucViewModel(String idKhuVuc, String makhuvuc, int trangthai) {
        this.idKhuVuc = idKhuVuc;
        this.makhuvuc = makhuvuc;
        this.trangthai = trangthai;
    }

    public String getIdKhuVuc() {
        return idKhuVuc;
    }

    public void setIdKhuVuc(String idKhuVuc) {
        this.idKhuVuc = idKhuVuc;
    }

    public String getMakhuvuc() {
        return makhuvuc;
    }

    public void setMakhuvuc(String makhuvuc) {
        this.makhuvuc = makhuvuc;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
     public Object[] getDataKhuVuc() {
        return new Object[]{idKhuVuc, makhuvuc, trangthai == 0 ? "Dừng Hoạt Động" : "Đang Hoạt Động"};
    }

    @Override
    public String toString() {
        return makhuvuc ;
    }
     
}
