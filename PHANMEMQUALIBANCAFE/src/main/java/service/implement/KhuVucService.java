package service.implement;

import domainmodel.KhuVuc;
import java.util.ArrayList;
import java.util.List;
import repository.KhuVucRepository;
import service.IKhuVucService;
import viewmodel.KhuVucViewModel;

public class KhuVucService implements IKhuVucService {

    KhuVucRepository khuVucRepository;

    public KhuVucService() {
        khuVucRepository = new KhuVucRepository();

    }

    @Override
    public List<KhuVucViewModel> getAllKhuVuc() {
        var allKhuVuc = khuVucRepository.getAllKhuVuc();
        List<KhuVucViewModel> listView = new ArrayList<>();
        for (KhuVuc kv : allKhuVuc) {
            listView.add(new KhuVucViewModel(kv.getId(), kv.getMa(), kv.getTrangThai()));
        }
        return listView;
    }

    @Override
    public String insertKhuVuc(String maKv, Integer TrangThai) {
        return khuVucRepository.insertKhuVuc(maKv, TrangThai);
    }
    

    @Override
    public void updateKhuVuc(KhuVucViewModel kvView, String maKv, Integer TrangThai) {
        KhuVuc kv = khuVucRepository.getKhuVucFromMa(kvView.getMakhuvuc());
        khuVucRepository.updateKhuVuc(kv, maKv, TrangThai);
    }
     @Override
    public void deleteKhuVuc(String idKhuVuc) {
        khuVucRepository.deleteKhuVuc(idKhuVuc);
    }

}
