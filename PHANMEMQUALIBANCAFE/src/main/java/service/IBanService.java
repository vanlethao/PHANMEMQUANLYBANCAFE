package service;

import domainmodel.Ban;
import domainmodel.ChiNhanh;
import domainmodel.KhuVuc;
import java.util.List;
import java.util.Set;
import viewmodel.BanViewModel;
import viewmodel.ChiNhanhViewModel_Hoang;
import viewmodel.KhuVucViewModel;

public interface IBanService {

    public List<BanViewModel> getAllBanByKhuVuc(String idKhuVuc);

    String insertBan(Integer SoBan, KhuVucViewModel kvView);

    public void deleteBan(String idBan);

    ChiNhanhViewModel_Hoang getChiNhanhByTaiKhoan(String idTaiKhoan);
}
