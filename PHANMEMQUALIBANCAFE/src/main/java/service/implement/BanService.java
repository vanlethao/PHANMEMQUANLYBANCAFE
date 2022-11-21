package service.implement;

import domainmodel.Ban;
import domainmodel.KhuVuc;
import java.util.ArrayList;
import java.util.List;
import repository.BanRepository;
import repository.KhuVucRepository;
import service.IBanHangService;
import service.IBanService;
import viewmodel.BanViewModel;
import viewmodel.KhuVucViewModel;

public class BanService implements IBanService {

    BanRepository banRepository;
    KhuVucRepository khuVucRepository;

    public BanService() {
        banRepository = new BanRepository();
        khuVucRepository = new KhuVucRepository();

    }

    @Override
    public List<BanViewModel> getAllBan() {
        var allBan = banRepository.getAllBan();
        List<BanViewModel> listView = new ArrayList<>();
        for (Ban ban : allBan) {
            if (ban.getTrangThaiSuDung()== 1) {
                listView.add(new BanViewModel(ban.getId(), ban.getSoBan(), ban.getKhuVuc().getMa()));
            }

        }
        return listView;
    }

    @Override
    public String insertBan(Integer SoBan,  KhuVucViewModel kvView) {
        KhuVuc kv = khuVucRepository.getKhuVucFromMa(kvView.getMakhuvuc());
        return banRepository.insertBan(SoBan,  kv);
    }

    @Override
    public void deleteBan(String idBan) {
        banRepository.deleteBan(idBan);
    }
    

}
