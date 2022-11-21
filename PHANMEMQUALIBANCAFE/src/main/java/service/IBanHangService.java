/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import viewmodel.Area;
import viewmodel.ProductForSale;
import viewmodel.Table;

/**
 *
 * @author trant
 */
public interface IBanHangService {

    List<ProductForSale> getAllProductForSale();

    boolean checkSoLuongMua(String soLuong);

    List<Area> getAllKhuVuc();

    List<Table> getAllBanByKhuVuc(Area are);
}
