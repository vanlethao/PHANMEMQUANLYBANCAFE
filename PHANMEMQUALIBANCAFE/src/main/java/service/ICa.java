/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainmodel.Ca;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ICa {
    List<Ca> getAll();
   void insertCa(String ma, LocalTime gioBD, LocalTime gioKT, int trangThai);
}
