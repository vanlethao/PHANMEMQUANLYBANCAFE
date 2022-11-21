package service;

import domainmodel.KhuVuc;
import java.util.List;
import viewmodel.BanViewModel;
import viewmodel.KhuVucViewModel;

public interface IBanService {

    public List<BanViewModel> getAllBan();

    String insertBan(Integer SoBan,  KhuVucViewModel kvView);
    public void deleteBan(String idBan);
}
