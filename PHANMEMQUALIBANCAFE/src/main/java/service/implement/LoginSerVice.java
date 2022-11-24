/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.implement;

import domainmodel.TaiKhoanNguoiDung;
import java.util.ArrayList;
import java.util.List;
import repository.Login_NguoiDungRepo;
import service.ILogin;
import viewmodel.TaiKhoanNguoiDungViewModel_Hoang;

/**
 *
 * @author ASUS
 */
public class LoginSerVice implements ILogin {

    Login_NguoiDungRepo logRepo;

    public LoginSerVice() {
        logRepo = new Login_NguoiDungRepo();
    }

    @Override
    public TaiKhoanNguoiDung getNguoiDung(String tenTaiKhoan, String matKhau) {
        return logRepo.getNguoiDung(tenTaiKhoan, matKhau);
    }

}
