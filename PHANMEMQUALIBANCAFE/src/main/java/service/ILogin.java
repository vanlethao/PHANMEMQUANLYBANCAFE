/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.TaiKhoanNguoiDung;
import viewmodel.TaiKhoanNguoiDungViewModel_Hoang;

/**
 *
 * @author ASUS
 */
public interface ILogin {
    TaiKhoanNguoiDung getNguoiDung(String tenTaiKhoan,String matKhau);
}
