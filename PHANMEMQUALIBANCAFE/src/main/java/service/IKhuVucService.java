package service;

import domainmodel.KhuVuc;
import java.util.List;
import viewmodel.BanViewModel;
import viewmodel.KhuVucViewModel;

public interface IKhuVucService {

    public List<KhuVucViewModel> getAllKhuVuc();

    String insertKhuVuc(String maKv, Integer TrangThai);

    void updateKhuVuc(KhuVucViewModel kv, String maKv, Integer TrangThai);
      public void deleteKhuVuc(String idKhuVuc);
}
