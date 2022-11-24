/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import domainmodel.NhaCungCap;
import domainmodel.NhanVien;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.HoaDonChiTietRepo;
import service.IHoaDon;
import service.IHoaDonChiTiet;
import service.IPhieuNhap;
import service.IPhieuTra;
import service.implement.ChiTietHoaDonService;
import service.implement.HoaDonService;
import service.implement.PhieuNhapService;
import service.implement.PhieuTraService;
import viewmodel.ChitietHoaDonViewModel;
import viewmodel.HoaDonViewModel;
import viewmodel.NguyenLieuViewModel_Hoang;
import viewmodel.NhaCungCapViewModel_Hoang;
import viewmodel.NhanVienViewModel_Hoang;
import viewmodel.PhieuNhapViewModel;
import viewmodel.PhieuTraViewModel;

/**
 *
 * @author trant
 */
public class QLGiaoDich extends javax.swing.JPanel {

    /**
     * Creates new form QLGiaoDich
     */
    DefaultTableModel modelPhieuNhap = new DefaultTableModel();
    DefaultTableModel modelPhieuTra = new DefaultTableModel();
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel modelHDCT = new DefaultTableModel();
    IHoaDon hoaDonService = new HoaDonService();
    IHoaDonChiTiet hoaDonChiTietService = new ChiTietHoaDonService();
    List<HoaDonViewModel> lstHoaDon = new ArrayList<>();
    List<ChitietHoaDonViewModel> lstChiTietHD = new ArrayList();
    
    IPhieuNhap phieuNhapSevice = new PhieuNhapService();
    List<PhieuNhapViewModel> lstPhieuNhap = new ArrayList<>();
    
    IPhieuTra phieuTraService = new PhieuTraService();
    List<PhieuTraViewModel> lstPhieuTra = new ArrayList<>();
    
    public QLGiaoDich() {
        initComponents();
        loadAll();
    }
    
    private void loadAll() {
        lstHoaDon = hoaDonService.getAllHoaDon();
        loadTableHoaDon(lstHoaDon);
        lstPhieuNhap = phieuNhapSevice.getAllPhieuNhap();
        loadTablePhieuNhap(lstPhieuNhap);
        lstPhieuTra = phieuTraService.getAllPhieuTra();
        loadTablePhieuTra(lstPhieuTra);
        cboNguyenLieuNhap.setModel(new DefaultComboBoxModel(phieuNhapSevice.getAllNguyenLieu().toArray()));
        cboNhaCungCapNhap.setModel(new DefaultComboBoxModel(phieuNhapSevice.getAllNhaCungCap().toArray()));
        cboNhanVienNhap.setModel(new DefaultComboBoxModel(phieuNhapSevice.getAllNhanVien().toArray()));
        cboNguyenLieuTra.setModel(new DefaultComboBoxModel(phieuNhapSevice.getAllNguyenLieu().toArray()));
        cboNhaCungCapTra.setModel(new DefaultComboBoxModel(phieuNhapSevice.getAllNhaCungCap().toArray()));
        cboNhanVienTra.setModel(new DefaultComboBoxModel(phieuNhapSevice.getAllNhanVien().toArray()));
    }
    
    private void loadTableHoaDon(List<HoaDonViewModel> lstHoaDon) {
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        for (HoaDonViewModel x : lstHoaDon) {
            model.addRow(x.getDataHoaDonView());
        }
    }
    
    private void loadTablePhieuNhap(List<PhieuNhapViewModel> lstPhieuNhap) {
        modelPhieuNhap = (DefaultTableModel) tblPhieuNhap.getModel();
        
        modelPhieuNhap.setRowCount(0);
        for (PhieuNhapViewModel x : lstPhieuNhap) {
            //       if (x.getTrangThai() == 1) {
            modelPhieuNhap.addRow(x.getDataPhieuNhapView());
            //    }
        }
    }
    
    private void loadTablePhieuTra(List<PhieuTraViewModel> lstPhieuTra) {
        modelPhieuTra = (DefaultTableModel) tblPhieuTra.getModel();
        modelPhieuTra.setRowCount(0);
        for (PhieuTraViewModel x : lstPhieuTra) {
            //       if (x.getTrangThai() == 1) {
            modelPhieuTra.addRow(x.getPhieuTrahangView());
            //    }
        }
    }
    
    private void fillTablePhieuNhap(int index) {
        int row = tblPhieuNhap.getSelectedRow();
        if (tblPhieuNhap.getRowCount() >= 0) {
            txtMaPhieuNhap.setText((String) tblPhieuNhap.getValueAt(index, 0).toString());
            for (int i = 0; i < phieuNhapSevice.getAllNguyenLieu().size(); i++) {
                if (phieuNhapSevice.getAllNguyenLieu().get(i).getMa().equals(tblPhieuNhap.getValueAt(index, 1))) {
                    cboNguyenLieuNhap.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < phieuNhapSevice.getAllNguyenLieu().size(); i++) {
                if (phieuNhapSevice.getAllNguyenLieu().get(i).getTen().equals(tblPhieuNhap.getValueAt(index, 2))) {
                    cboNguyenLieuNhap.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < phieuNhapSevice.getAllNhaCungCap().size(); i++) {
                if (phieuNhapSevice.getAllNhaCungCap().get(i).getMa().equals(tblPhieuNhap.getValueAt(index, 3))) {
                    cboNhaCungCapNhap.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < phieuNhapSevice.getAllNhaCungCap().size(); i++) {
                if (phieuNhapSevice.getAllNhaCungCap().get(i).getTen().equals(tblPhieuNhap.getValueAt(index, 4))) {
                    cboNhaCungCapNhap.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < phieuNhapSevice.getAllNhanVien().size(); i++) {
                if (phieuNhapSevice.getAllNhanVien().get(i).getMa().equals(tblPhieuNhap.getValueAt(index, 5))) {
                    cboNhanVienNhap.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < phieuNhapSevice.getAllNhanVien().size(); i++) {
                if (phieuNhapSevice.getAllNhanVien().get(i).getHoTen().equals(tblPhieuNhap.getValueAt(index, 6))) {
                    cboNhanVienNhap.setSelectedIndex(i);
                }
            }
            dateNgayNhap.setDate((Date) tblPhieuNhap.getValueAt(index, 7));
            txtSoLuongNhap.setText(tblPhieuNhap.getValueAt(index, 8).toString());
            txtDonGia.setText((String) tblPhieuNhap.getValueAt(index, 9).toString());
        }
    }
    private void fillTablePhieuTra(int index) {
        
        if (tblPhieuTra.getRowCount() >= 0) {
            txtMaPhieuTra.setText((String) tblPhieuTra.getValueAt(index, 0).toString());
            for (int i = 0; i < phieuNhapSevice.getAllNguyenLieu().size(); i++) {
                if (phieuNhapSevice.getAllNguyenLieu().get(i).getMa().equals(tblPhieuTra.getValueAt(index, 1))) {
                    cboNguyenLieuTra.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < phieuNhapSevice.getAllNguyenLieu().size(); i++) {
                if (phieuNhapSevice.getAllNguyenLieu().get(i).getTen().equals(tblPhieuTra.getValueAt(index, 2))) {
                    cboNguyenLieuTra.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < phieuNhapSevice.getAllNhaCungCap().size(); i++) {
                if (phieuNhapSevice.getAllNhaCungCap().get(i).getMa().equals(tblPhieuTra.getValueAt(index, 3))) {
                    cboNhaCungCapTra.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < phieuNhapSevice.getAllNhaCungCap().size(); i++) {
                if (phieuNhapSevice.getAllNhaCungCap().get(i).getTen().equals(tblPhieuTra.getValueAt(index, 4))) {
                    cboNhaCungCapTra.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < phieuNhapSevice.getAllNhanVien().size(); i++) {
                if (phieuNhapSevice.getAllNhanVien().get(i).getMa().equals(tblPhieuTra.getValueAt(index, 5))) {
                    cboNhanVienTra.setSelectedIndex(i);
                }
            }
            for (int i = 0; i < phieuNhapSevice.getAllNhanVien().size(); i++) {
                if (phieuNhapSevice.getAllNhanVien().get(i).getHoTen().equals(tblPhieuTra.getValueAt(index, 6))) {
                    cboNhanVienTra.setSelectedIndex(i);
                }
            }
            dateNgayTra.setDate((Date) tblPhieuTra.getValueAt(index, 7));
            txtSoLuongNhap.setText(tblPhieuTra.getValueAt(index, 8).toString());
            txtLyDo.setText(tblPhieuTra.getValueAt(index, 9).toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLocHoaDon = new javax.swing.JButton();
        dateFrom = new com.toedter.calendar.JDateChooser();
        dateTo = new com.toedter.calendar.JDateChooser();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        rdoDaThanhToan = new javax.swing.JRadioButton();
        rdoDaHuy = new javax.swing.JRadioButton();
        btnHuyHoaDon = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        rdoHuyPhieuNhap = new javax.swing.JRadioButton();
        rdoHoanThanhPhieuNhap = new javax.swing.JRadioButton();
        btnHoanThanhPhieuNhap = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtTimKiemPhieuNhap = new javax.swing.JTextField();
        btnTimKiemPhieuNhap = new javax.swing.JButton();
        rdoPhieuNhapTam = new javax.swing.JRadioButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        btnCapNhatPhieuNhap = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnImport = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        cboNguyenLieuNhap = new javax.swing.JComboBox<>();
        cboNhaCungCapNhap = new javax.swing.JComboBox<>();
        cboNhanVienNhap = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        btnTaoPhieuNhap = new javax.swing.JButton();
        btnHuyPhieuNhap = new javax.swing.JButton();
        txtDonGia = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtMaPhieuNhap = new javax.swing.JTextField();
        dateNgayNhap = new com.toedter.calendar.JDateChooser();
        txtSoLuongNhap = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPhieuTra = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        txtTimKiemPhieuTra = new javax.swing.JTextField();
        rdoHuyPhieuTra = new javax.swing.JRadioButton();
        rdoHoanThanhPhieuTra = new javax.swing.JRadioButton();
        btnTimKiemPhieuTra = new javax.swing.JButton();
        btnHoanThanhPhieuTra = new javax.swing.JButton();
        rdoPhieuTraTam = new javax.swing.JRadioButton();
        rdoTatCaPhieuTra = new javax.swing.JRadioButton();
        btnCapNhatPhieuTra = new javax.swing.JButton();
        btnExport1 = new javax.swing.JButton();
        btnImport1 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cboNguyenLieuTra = new javax.swing.JComboBox<>();
        cboNhaCungCapTra = new javax.swing.JComboBox<>();
        cboNhanVienTra = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        btnTaoPhieuTra = new javax.swing.JButton();
        btnHuyPhieuTra = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLyDo = new javax.swing.JTextArea();
        dateNgayTra = new com.toedter.calendar.JDateChooser();
        jLabel40 = new javax.swing.JLabel();
        txtMaPhieuTra = new javax.swing.JTextField();
        txtSoLuongTra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        tblHoaDonChiTiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng mua", "Giá bán", "Thành tiền", "Thành tiền sau KM"
            }
        ));
        jScrollPane5.setViewportView(tblHoaDonChiTiet);
        if (tblHoaDonChiTiet.getColumnModel().getColumnCount() > 0) {
            tblHoaDonChiTiet.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Từ ngày");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("đến ngày");

        btnLocHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLocHoaDon.setText("Lọc hóa đơn");
        btnLocHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLocHoaDon)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLocHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(dateTo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateFrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        tblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày tạo", "Mã nhân viên", "Tên nhân viên", "Trạng thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblHoaDon);

        buttonGroup1.add(rdoDaThanhToan);
        rdoDaThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoDaThanhToan.setText("Ðã thanh toán");
        rdoDaThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDaHuy);
        rdoDaHuy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoDaHuy.setText("Ðã hủy");
        rdoDaHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaHuyActionPerformed(evt);
            }
        });

        btnHuyHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHuyHoaDon.setText("Hủy hóa đơn");
        btnHuyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(rdoDaHuy)
                .addGap(18, 18, 18)
                .addComponent(rdoDaThanhToan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuyHoaDon)
                .addContainerGap())
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoDaHuy)
                    .addComponent(rdoDaThanhToan)
                    .addComponent(btnHuyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Hóa đơn", jPanel1);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        buttonGroup1.add(rdoHuyPhieuNhap);
        rdoHuyPhieuNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoHuyPhieuNhap.setText("Đã hủy");
        rdoHuyPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHuyPhieuNhapActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHoanThanhPhieuNhap);
        rdoHoanThanhPhieuNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoHoanThanhPhieuNhap.setText("Đã hoàn thành");
        rdoHoanThanhPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHoanThanhPhieuNhapActionPerformed(evt);
            }
        });

        btnHoanThanhPhieuNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHoanThanhPhieuNhap.setText("Hoàn thành");
        btnHoanThanhPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhPhieuNhapActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Nhập mã phiếu:");

        txtTimKiemPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTimKiemPhieuNhapMouseReleased(evt);
            }
        });
        txtTimKiemPhieuNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemPhieuNhapKeyReleased(evt);
            }
        });

        btnTimKiemPhieuNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTimKiemPhieuNhap.setText("Tìm kiếm");
        btnTimKiemPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemPhieuNhapActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoPhieuNhapTam);
        rdoPhieuNhapTam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoPhieuNhapTam.setText("Phiếu tạm");
        rdoPhieuNhapTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPhieuNhapTamActionPerformed(evt);
            }
        });

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu nhập   ", "Mã nguyên liệu", "Tên nguyên liệu", "Mã nhà cung cấp", "Tên nhà cung cấp", "Mã nhân viên", "Tên nhân viên", "Ngày nhập", "Số lượng nhập", "Đơn giá", "Thành tiền", "Trạng thái"
            }
        ));
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblPhieuNhap);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setText("Tất cả");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        btnCapNhatPhieuNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCapNhatPhieuNhap.setText("Cập nhật phiếu nhập");
        btnCapNhatPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatPhieuNhapActionPerformed(evt);
            }
        });

        btnExport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExport.setText("Xuất excel");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        btnImport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnImport.setText("Mở excel");
        btnImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addComponent(btnExport))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtTimKiemPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTimKiemPhieuNhap)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoHuyPhieuNhap)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoPhieuNhapTam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoHoanThanhPhieuNhap)
                                .addGap(2, 2, 2))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnImport)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCapNhatPhieuNhap)
                                .addGap(29, 29, 29)
                                .addComponent(btnHoanThanhPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemPhieuNhap)
                    .addComponent(rdoHuyPhieuNhap)
                    .addComponent(rdoPhieuNhapTam)
                    .addComponent(rdoHoanThanhPhieuNhap)
                    .addComponent(jLabel32)
                    .addComponent(btnTimKiemPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(btnHoanThanhPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Nguyên liệu:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Nhà cung cấp:");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setText("Nhân viên:");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Ngày nhập:");

        cboNguyenLieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNguyenLieuNhapActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Số lượng nhập:");

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel38.setText("Đơn giá");

        btnTaoPhieuNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTaoPhieuNhap.setText("Tạo phiếu nhập");
        btnTaoPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoPhieuNhapActionPerformed(evt);
            }
        });

        btnHuyPhieuNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHuyPhieuNhap.setText("Hủy");
        btnHuyPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyPhieuNhapActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Mã phiếu nhập:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Phiếu nhập");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel38)
                            .addComponent(jLabel36)
                            .addComponent(jLabel39)
                            .addComponent(jLabel37))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnHuyPhieuNhap)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnTaoPhieuNhap))
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel18Layout.createSequentialGroup()
                                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(dateNgayNhap, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                                .addComponent(cboNhanVienNhap, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cboNhaCungCapNhap, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cboNguyenLieuNhap, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(txtMaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 21, Short.MAX_VALUE)))
                                .addContainerGap(61, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNguyenLieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboNhaCungCapNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(cboNhanVienNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateNgayNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuongNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(321, 321, 321))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Phiếu nhập hàng", jPanel2);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phiếu trả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        tblPhieuTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu trả", "Mã nguyên liệu", "Tên nguyên liệu", "Mã nhà cung cấp", "Nhà cung cấp", "Mã nhân viên", "Tên nhân viên", "Ngày trả", "Số lượng trả", "Lý do", "Trạng thái"
            }
        ));
        tblPhieuTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuTraMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPhieuTra);

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setText("Nhập mã phiếu:");

        buttonGroup1.add(rdoHuyPhieuTra);
        rdoHuyPhieuTra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoHuyPhieuTra.setText("Đã hủy");
        rdoHuyPhieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHuyPhieuTraActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHoanThanhPhieuTra);
        rdoHoanThanhPhieuTra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoHoanThanhPhieuTra.setText("Đã hoàn thành");
        rdoHoanThanhPhieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHoanThanhPhieuTraActionPerformed(evt);
            }
        });

        btnTimKiemPhieuTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTimKiemPhieuTra.setText("Tìm kiếm");
        btnTimKiemPhieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemPhieuTraActionPerformed(evt);
            }
        });

        btnHoanThanhPhieuTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHoanThanhPhieuTra.setText("Hoàn thành");
        btnHoanThanhPhieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanThanhPhieuTraActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoPhieuTraTam);
        rdoPhieuTraTam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoPhieuTraTam.setText("Phiếu tạm");
        rdoPhieuTraTam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoPhieuTraTamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoTatCaPhieuTra);
        rdoTatCaPhieuTra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoTatCaPhieuTra.setText("Tất cả");
        rdoTatCaPhieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTatCaPhieuTraActionPerformed(evt);
            }
        });

        btnCapNhatPhieuTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCapNhatPhieuTra.setText("Cập nhật phiếu trả");
        btnCapNhatPhieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatPhieuTraActionPerformed(evt);
            }
        });

        btnExport1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExport1.setText("Xuất excel");
        btnExport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExport1ActionPerformed(evt);
            }
        });

        btnImport1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnImport1.setText("Mở excel");
        btnImport1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImport1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTimKiemPhieuTra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTimKiemPhieuTra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoTatCaPhieuTra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoHuyPhieuTra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoPhieuTraTam)
                                .addGap(2, 2, 2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(btnExport1)
                                .addGap(18, 18, 18)
                                .addComponent(btnImport1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCapNhatPhieuTra)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHoanThanhPhieuTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoHoanThanhPhieuTra, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoHuyPhieuTra)
                    .addComponent(rdoHoanThanhPhieuTra)
                    .addComponent(rdoPhieuTraTam)
                    .addComponent(rdoTatCaPhieuTra)
                    .addComponent(jLabel41)
                    .addComponent(txtTimKiemPhieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemPhieuTra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnCapNhatPhieuTra, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(btnHoanThanhPhieuTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnImport1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExport1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phiếu trả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Nguyên liệu:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Nhà cung cấp:");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Nhân viên:");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Ngày trả:");

        cboNguyenLieuTra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNguyenLieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNguyenLieuTraActionPerformed(evt);
            }
        });

        cboNhaCungCapTra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboNhanVienTra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Số lượng trả:");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Lý do");

        btnTaoPhieuTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnTaoPhieuTra.setText("Tạo phiếu trả");

        btnHuyPhieuTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnHuyPhieuTra.setText("Hủy");
        btnHuyPhieuTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyPhieuTraActionPerformed(evt);
            }
        });

        txtLyDo.setColumns(20);
        txtLyDo.setRows(5);
        jScrollPane2.setViewportView(txtLyDo);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Mã phiếu trả");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Phiếu trả");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                            .addComponent(btnHuyPhieuTra)
                            .addGap(18, 18, 18)
                            .addComponent(btnTaoPhieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel16Layout.createSequentialGroup()
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26)
                                .addComponent(jLabel27)
                                .addComponent(jLabel28)
                                .addComponent(jLabel29)
                                .addComponent(jLabel31)
                                .addComponent(jLabel30)
                                .addComponent(jLabel40))
                            .addGap(25, 25, 25)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cboNhanVienTra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboNhaCungCapTra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboNguyenLieuTra, 0, 280, Short.MAX_VALUE)
                                .addComponent(txtMaPhieuTra)
                                .addComponent(txtSoLuongTra)
                                .addComponent(dateNgayTra, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(jScrollPane2))))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaPhieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboNguyenLieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboNhaCungCapTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboNhanVienTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtSoLuongTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel31))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaoPhieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyPhieuTra, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Phiếu trả hàng", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoDaHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaHuyActionPerformed
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        for (HoaDonViewModel x : lstHoaDon) {
            if (x.getTrangThai() == 0) {
                model.addRow(x.getDataHoaDonView());
            }
        }
    }//GEN-LAST:event_rdoDaHuyActionPerformed

    private void cboNguyenLieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNguyenLieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNguyenLieuNhapActionPerformed
//    PhieuNhapViewModel pnView = new PhieuNhapViewModel();
//
//    PhieuNhapViewModel getDataPhieuNhap() {
//        
//        return new PhieuNhapViewModel(pnView.getId(), txtMaPhieuNhap.getText(), ((NguyenLieuViewModel_Hoang) cboNguyenLieuNhap.getSelectedItem()).getMa(),
//                ((NhaCungCapViewModel_Hoang) cboNhaCungCapNhap.getSelectedItem()).getMa(), ((NhanVienViewModel_Hoang) cboNhanVienNhap.getSelectedItem()).getMa(), dateNgayNhap.getDate(), sln, donGia);
//    }
    private void btnTaoPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoPhieuNhapActionPerformed
        int row = tblPhieuNhap.getSelectedRow();
        PhieuNhapViewModel pnView = new PhieuNhapViewModel();
        pnView.setMaPhieuNhap(tblPhieuNhap.getValueAt(row, 0).toString());
        phieuNhapSevice.insertPhieuNhap(txtMaPhieuNhap.getText(), ((NhaCungCapViewModel_Hoang) cboNhaCungCapNhap.getSelectedItem()), ((NhanVienViewModel_Hoang) cboNhanVienNhap.getSelectedItem()), dateNgayNhap.getDate(), 1);
        phieuNhapSevice.insertCTPhieuNhap(pnView, ((NguyenLieuViewModel_Hoang) cboNguyenLieuNhap.getSelectedItem()), Float.parseFloat(txtSoLuongNhap.getText()), Float.parseFloat(txtDonGia.getText()));
        loadAll();
    }//GEN-LAST:event_btnTaoPhieuNhapActionPerformed

    private void btnHuyPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyPhieuNhapActionPerformed
        int row = tblPhieuNhap.getSelectedRow();
        PhieuNhapViewModel pnView = new PhieuNhapViewModel();
        lstPhieuNhap = phieuNhapSevice.getAllPhieuNhap();
        pnView = lstPhieuNhap.get(row);
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn phiếu nhập");
        } else {
            int chon = JOptionPane.showConfirmDialog(this, "Xác nhận hủy phiếu", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (chon == JOptionPane.YES_OPTION) {
                if (pnView.getTrangThai() == 1) {
                    JOptionPane.showMessageDialog(this, phieuNhapSevice.updateTrangThaiPhieuNhap(tblPhieuNhap.getValueAt(row, 0).toString(), 0));
                    loadHuyPhieuNhap(lstPhieuNhap);
                    rdoHuyPhieuNhap.setSelected(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Phiếu đã nhập không thể hủy");
                }
            }
        }
    }//GEN-LAST:event_btnHuyPhieuNhapActionPerformed

    private void btnCapNhatPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatPhieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatPhieuNhapActionPerformed

    private void cboNguyenLieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNguyenLieuTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNguyenLieuTraActionPerformed

    private void btnHuyPhieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyPhieuTraActionPerformed
        int row = tblPhieuTra.getSelectedRow();
        PhieuTraViewModel ptView = new PhieuTraViewModel();
        lstPhieuNhap = phieuNhapSevice.getAllPhieuNhap();
        ptView = lstPhieuTra.get(row);
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn phiếu trả");
        } else {
            if (ptView.getTrangThai() == 1) {
                int chon = JOptionPane.showConfirmDialog(this, "Xác nhận hủy phiếu", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (chon == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, phieuTraService.updateTrangThaiPhieuTra(tblPhieuTra.getValueAt(row, 0).toString(), 0));
                    lstPhieuTra = phieuTraService.getAllPhieuTra();
                    loadTableHuyPhieuTra(lstPhieuTra);
                    rdoHuyPhieuTra.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không thể hủy");
            }
        }
    }//GEN-LAST:event_btnHuyPhieuTraActionPerformed

    private void btnCapNhatPhieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatPhieuTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhatPhieuTraActionPerformed

    private void btnHuyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHoaDonActionPerformed
        int chon = JOptionPane.showConfirmDialog(this, "Xác nhận hủy hóa đơn", "Hủy", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            int row = tblHoaDon.getSelectedRow();
            JOptionPane.showMessageDialog(this, hoaDonService.updateTrangThai((String) tblHoaDon.getValueAt(row, 0), 0));
//        service.updateTrangThai((String) tblHoaDon.getValueAt(row, 0), 1);
            loadAll();
        }
    }//GEN-LAST:event_btnHuyHoaDonActionPerformed

    private void rdoDaThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaThanhToanActionPerformed
        loadTableHoaDon(lstHoaDon);
    }//GEN-LAST:event_rdoDaThanhToanActionPerformed
    private void loadTableHoaDonChiTiet(List<ChitietHoaDonViewModel> lstChiTietHD) {
        int row = tblHoaDon.getSelectedRow();
        model = (DefaultTableModel) tblHoaDonChiTiet.getModel();
        model.setRowCount(0);
        for (ChitietHoaDonViewModel x : lstChiTietHD) {
            model.addRow(x.getDataHoaDonChiTietView());
        }
    }
    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();
        lstChiTietHD = hoaDonChiTietService.getHoaDonChiTietByMaHoaDon(tblHoaDon.getValueAt(row, 0).toString());
        loadTableHoaDonChiTiet(lstChiTietHD);
    }//GEN-LAST:event_tblHoaDonMouseClicked
    private void loadHuyPhieuNhap(List<PhieuNhapViewModel> lstPhieuNhap) {
        modelPhieuNhap = (DefaultTableModel) tblPhieuNhap.getModel();
        model.setRowCount(0);
        for (PhieuNhapViewModel x : lstPhieuNhap) {
            if (x.getTrangThai() == 0) {
                modelPhieuNhap.addRow(x.getDataPhieuNhapView());
            }
        }
    }
    private void rdoHuyPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHuyPhieuNhapActionPerformed
        
        loadHuyPhieuNhap(lstPhieuNhap);
    }//GEN-LAST:event_rdoHuyPhieuNhapActionPerformed
    private void loadDaHoanThanh(List<PhieuNhapViewModel> lstPhieuNhap) {
        modelPhieuNhap = (DefaultTableModel) tblPhieuNhap.getModel();
        modelPhieuNhap.setRowCount(0);
        for (PhieuNhapViewModel x : lstPhieuNhap) {
            if (x.getTrangThai() == 3) {
                modelPhieuNhap.addRow(x.getDataPhieuNhapView());
            }
        }
    }
    private void rdoHoanThanhPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHoanThanhPhieuNhapActionPerformed
        loadDaHoanThanh(lstPhieuNhap);
    }//GEN-LAST:event_rdoHoanThanhPhieuNhapActionPerformed
    private void loadPhieuTam(List<PhieuNhapViewModel> lstPhieuNhap) {
        model = (DefaultTableModel) tblPhieuNhap.getModel();
        model.setRowCount(0);
        for (PhieuNhapViewModel x : lstPhieuNhap) {
            if (x.getTrangThai() == 1) {
                model.addRow(x.getDataPhieuNhapView());
            }
        }
    }
    private void rdoPhieuNhapTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPhieuNhapTamActionPerformed
        loadPhieuTam(lstPhieuNhap);
    }//GEN-LAST:event_rdoPhieuNhapTamActionPerformed

    private void btnTimKiemPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemPhieuNhapActionPerformed
        if (txtTimKiemPhieuNhap.getText().isEmpty()) {
            loadTablePhieuNhap(phieuNhapSevice.getAllPhieuNhap());
        } else {
            List<PhieuNhapViewModel> lstSearch = phieuNhapSevice.searchPhieuNhap(txtTimKiemPhieuNhap.getText());
            loadTablePhieuNhap(lstSearch);
        }
    }//GEN-LAST:event_btnTimKiemPhieuNhapActionPerformed
    private void loadTablePhieuTraTam(List<PhieuTraViewModel> lstPhieuTra) {
        modelPhieuTra = (DefaultTableModel) tblPhieuTra.getModel();
        modelPhieuTra.setRowCount(0);
        for (PhieuTraViewModel x : lstPhieuTra) {
            if (x.getTrangThai() == 1) {
                modelPhieuTra.addRow(x.getPhieuTrahangView());
            }
        }
    }
    private void rdoPhieuTraTamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoPhieuTraTamActionPerformed
        loadTablePhieuTraTam(lstPhieuTra);
    }//GEN-LAST:event_rdoPhieuTraTamActionPerformed

    private void btnHoanThanhPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhPhieuNhapActionPerformed
        int row = tblPhieuNhap.getSelectedRow();
        PhieuNhapViewModel pnView = new PhieuNhapViewModel();
        lstPhieuNhap = phieuNhapSevice.getAllPhieuNhap();
        pnView = lstPhieuNhap.get(row);
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn phiếu nhập");
        } else {
            int chon = JOptionPane.showConfirmDialog(this, "Xác nhận hủy phiếu", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (chon == JOptionPane.YES_OPTION) {
                if (pnView.getTrangThai() == 1) {
                    JOptionPane.showMessageDialog(this, phieuNhapSevice.updateTrangThaiPhieuNhap(tblPhieuNhap.getValueAt(row, 0).toString(), 3));
                    loadHuyPhieuNhap(lstPhieuNhap);
                    rdoHuyPhieuNhap.setSelected(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể hoàn thành");
                }
            }
        }
    }//GEN-LAST:event_btnHoanThanhPhieuNhapActionPerformed

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        int row = tblPhieuNhap.getSelectedRow();
        fillTablePhieuNhap(row);
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    private void btnTimKiemPhieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemPhieuTraActionPerformed
        if (txtTimKiemPhieuTra.getText().isEmpty()) {
            loadTablePhieuTra(phieuTraService.getAllPhieuTra());
        } else {
            List<PhieuTraViewModel> lstSearchPhieuTra = phieuTraService.searchPhieuTra(txtTimKiemPhieuTra.getText());
            loadTablePhieuTra(lstSearchPhieuTra);
        }
    }//GEN-LAST:event_btnTimKiemPhieuTraActionPerformed

    private void txtTimKiemPhieuNhapMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemPhieuNhapMouseReleased

    }//GEN-LAST:event_txtTimKiemPhieuNhapMouseReleased

    private void txtTimKiemPhieuNhapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemPhieuNhapKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTimKiemPhieuNhapKeyReleased

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        loadTablePhieuNhap(lstPhieuNhap);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void rdoTatCaPhieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTatCaPhieuTraActionPerformed
        loadTablePhieuTra(lstPhieuTra);
    }//GEN-LAST:event_rdoTatCaPhieuTraActionPerformed
    private void loadTableHuyPhieuTra(List<PhieuTraViewModel> lstPhieuTra) {
        modelPhieuTra = (DefaultTableModel) tblPhieuTra.getModel();
        modelPhieuTra.setRowCount(0);
        for (PhieuTraViewModel x : lstPhieuTra) {
            if (x.getTrangThai() == 0) {
                modelPhieuTra.addRow(x.getPhieuTrahangView());
            }
        }
    }
    private void rdoHuyPhieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHuyPhieuTraActionPerformed
        
        loadTableHuyPhieuTra(lstPhieuTra);
    }//GEN-LAST:event_rdoHuyPhieuTraActionPerformed
    private void loadTablePhieuTraHoanThanh(List<PhieuTraViewModel> lstPhieuTra) {
        modelPhieuTra = (DefaultTableModel) tblPhieuTra.getModel();
        modelPhieuTra.setRowCount(0);
        for (PhieuTraViewModel x : lstPhieuTra) {
            if (x.getTrangThai() == 3) {
                modelPhieuTra.addRow(x.getPhieuTrahangView());
            }
        }
    }
    private void rdoHoanThanhPhieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHoanThanhPhieuTraActionPerformed
        loadTablePhieuTraHoanThanh(lstPhieuTra);    }//GEN-LAST:event_rdoHoanThanhPhieuTraActionPerformed

    private void btnHoanThanhPhieuTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanThanhPhieuTraActionPerformed
        int row = tblPhieuTra.getSelectedRow();
        PhieuTraViewModel ptView = new PhieuTraViewModel();
        lstPhieuNhap = phieuNhapSevice.getAllPhieuNhap();
        ptView = lstPhieuTra.get(row);
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn phiếu trả");
        } else {
            if (ptView.getTrangThai() == 1) {
                int chon = JOptionPane.showConfirmDialog(this, "Xác nhận hủy phiếu", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (chon == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, phieuTraService.updateTrangThaiPhieuTra(tblPhieuTra.getValueAt(row, 0).toString(), 3));
                    lstPhieuTra = phieuTraService.getAllPhieuTra();
                    loadTablePhieuTraHoanThanh(lstPhieuTra);
                    rdoHoanThanhPhieuTra.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không thể hoàn thành");
            }
        }
    }//GEN-LAST:event_btnHoanThanhPhieuTraActionPerformed

    private void btnLocHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocHoaDonActionPerformed
        // TODO add your handling code here:
        if (dateFrom.getDate() == null || dateTo.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Sai định dạng ngày tháng năm");
        } else {
            List<HoaDonViewModel> lstSearchHoaDon = hoaDonService.locHoaDon(dateFrom.getDate(), dateTo.getDate());
            loadTableHoaDon(lstSearchHoaDon);
        }
    }//GEN-LAST:event_btnLocHoaDonActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        // TODO add your handling code here:
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;
        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\ASUS\\Desktop\\TestExcel");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChosser = excelFileChooser.showSaveDialog(null);
        if (excelChosser == JFileChooser.APPROVE_OPTION) {
            
            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
                for (int i = 0; i < modelPhieuNhap.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < modelPhieuNhap.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(modelPhieuNhap.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(this, "Exported");
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException ex) {
                }
            }
            
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportActionPerformed
        File exelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;
        
        String defauCurrentDirectoryPath = "C:\\Users\\ASUS\\Desktop\\TestExcel";
        JFileChooser exportFlieChooser = new JFileChooser(defauCurrentDirectoryPath);
        
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        exportFlieChooser.setFileFilter(fnef);
        exportFlieChooser.setDialogTitle("Select Excel file");
        int excelChooser = exportFlieChooser.showOpenDialog(null);
        
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                exelFile = exportFlieChooser.getSelectedFile();
                excelFIS = new FileInputStream(exelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
                
                for (int row = 0; row < excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    
                    XSSFCell excelMaPhieu = excelRow.getCell(0);
                    XSSFCell excelMaNguyenLieu = excelRow.getCell(1);
                    XSSFCell excelTenNguyenLieu = excelRow.getCell(2);
                    XSSFCell excelMaNcc = excelRow.getCell(3);
                    XSSFCell excelTenNCC = excelRow.getCell(4);
                    XSSFCell excelMaNV = excelRow.getCell(5);
                    XSSFCell excelTenNV = excelRow.getCell(6);
                    XSSFCell excelNgayNhap = excelRow.getCell(7);
                    XSSFCell excelSoLuong = excelRow.getCell(8);
                    XSSFCell excelDonGia = excelRow.getCell(9);
                    XSSFCell excelThanhTien = excelRow.getCell(10);
                    XSSFCell excelTrangThai = excelRow.getCell(11);
                    modelPhieuNhap.addRow(new Object[]{excelMaPhieu, excelMaNguyenLieu, excelTenNguyenLieu, excelMaNcc, excelTenNCC, excelMaNV, excelTenNV,
                         excelNgayNhap, excelSoLuong, excelDonGia, excelThanhTien, excelTrangThai});
                }
                JOptionPane.showMessageDialog(null, "Thành công");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelJTableImport != null) {
                        excelJTableImport.close();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
            }
        }
    }//GEN-LAST:event_btnImportActionPerformed

    private void btnExport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExport1ActionPerformed
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;
        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\ASUS\\Desktop\\TestExcel");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChosser = excelFileChooser.showSaveDialog(null);
        if (excelChosser == JFileChooser.APPROVE_OPTION) {
            
            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
                for (int i = 0; i < modelPhieuTra.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < modelPhieuTra.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);
                        excelCell.setCellValue(modelPhieuTra.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(this, "Exported");
            } catch (FileNotFoundException ex) {
            } catch (IOException ex) {
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException ex) {
                }
            }
            
        }
    }//GEN-LAST:event_btnExport1ActionPerformed

    private void btnImport1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImport1ActionPerformed
        // TODO add your handling code here:
        File exelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;
        
        String defauCurrentDirectoryPath = "C:\\Users\\ASUS\\Desktop\\TestExcel";
        JFileChooser exportFlieChooser = new JFileChooser(defauCurrentDirectoryPath);
        
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        exportFlieChooser.setFileFilter(fnef);
        exportFlieChooser.setDialogTitle("Select Excel file");
        int excelChooser = exportFlieChooser.showOpenDialog(null);
        
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                exelFile = exportFlieChooser.getSelectedFile();
                excelFIS = new FileInputStream(exelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
                
                for (int row = 0; row < excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    
                    XSSFCell excelMaPhieu = excelRow.getCell(0);
                    XSSFCell excelMaNguyenLieu = excelRow.getCell(1);
                    XSSFCell excelTenNguyenLieu = excelRow.getCell(2);
                    XSSFCell excelMaNcc = excelRow.getCell(3);
                    XSSFCell excelTenNCC = excelRow.getCell(4);
                    XSSFCell excelMaNV = excelRow.getCell(5);
                    XSSFCell excelTenNV = excelRow.getCell(6);
                    XSSFCell excelNgayNhap = excelRow.getCell(7);
                    XSSFCell excelSoLuong = excelRow.getCell(8);
                    XSSFCell excelLyDo = excelRow.getCell(9);
                    XSSFCell excelTrangThai = excelRow.getCell(11);
                    modelPhieuTra.addRow(new Object[]{excelMaPhieu, excelMaNguyenLieu, excelTenNguyenLieu, excelMaNcc, excelTenNCC, excelMaNV, excelTenNV,
                         excelNgayNhap, excelSoLuong, excelLyDo, excelTrangThai});
                }
                JOptionPane.showMessageDialog(null, "Thành công");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelJTableImport != null) {
                        excelJTableImport.close();
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
            }
        }
    }//GEN-LAST:event_btnImport1ActionPerformed

    private void tblPhieuTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuTraMouseClicked
        // TODO add your handling code here:
        int row = tblPhieuTra.getSelectedRow();
        fillTablePhieuTra(row);
    }//GEN-LAST:event_tblPhieuTraMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatPhieuNhap;
    private javax.swing.JButton btnCapNhatPhieuTra;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnExport1;
    private javax.swing.JButton btnHoanThanhPhieuNhap;
    private javax.swing.JButton btnHoanThanhPhieuTra;
    private javax.swing.JButton btnHuyHoaDon;
    private javax.swing.JButton btnHuyPhieuNhap;
    private javax.swing.JButton btnHuyPhieuTra;
    private javax.swing.JButton btnImport;
    private javax.swing.JButton btnImport1;
    private javax.swing.JButton btnLocHoaDon;
    private javax.swing.JButton btnTaoPhieuNhap;
    private javax.swing.JButton btnTaoPhieuTra;
    private javax.swing.JButton btnTimKiemPhieuNhap;
    private javax.swing.JButton btnTimKiemPhieuTra;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<PhieuNhapViewModel> cboNguyenLieuNhap;
    private javax.swing.JComboBox<String> cboNguyenLieuTra;
    private javax.swing.JComboBox<NhaCungCap> cboNhaCungCapNhap;
    private javax.swing.JComboBox<String> cboNhaCungCapTra;
    private javax.swing.JComboBox<NhanVien> cboNhanVienNhap;
    private javax.swing.JComboBox<String> cboNhanVienTra;
    private com.toedter.calendar.JDateChooser dateFrom;
    private com.toedter.calendar.JDateChooser dateNgayNhap;
    private com.toedter.calendar.JDateChooser dateNgayTra;
    private com.toedter.calendar.JDateChooser dateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoDaHuy;
    private javax.swing.JRadioButton rdoDaThanhToan;
    private javax.swing.JRadioButton rdoHoanThanhPhieuNhap;
    private javax.swing.JRadioButton rdoHoanThanhPhieuTra;
    private javax.swing.JRadioButton rdoHuyPhieuNhap;
    private javax.swing.JRadioButton rdoHuyPhieuTra;
    private javax.swing.JRadioButton rdoPhieuNhapTam;
    private javax.swing.JRadioButton rdoPhieuTraTam;
    private javax.swing.JRadioButton rdoTatCaPhieuTra;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTable tblPhieuTra;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextArea txtLyDo;
    private javax.swing.JTextField txtMaPhieuNhap;
    private javax.swing.JTextField txtMaPhieuTra;
    private javax.swing.JTextField txtSoLuongNhap;
    private javax.swing.JTextField txtSoLuongTra;
    private javax.swing.JTextField txtTimKiemPhieuNhap;
    private javax.swing.JTextField txtTimKiemPhieuTra;
    // End of variables declaration//GEN-END:variables

}
